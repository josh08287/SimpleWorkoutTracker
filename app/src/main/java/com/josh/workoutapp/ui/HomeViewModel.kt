package com.josh.workoutapp.ui

import android.app.Application
import android.content.Context
import android.net.Uri
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.josh.workoutapp.WorkoutApp
import com.josh.workoutapp.data.PlanManager
import com.josh.workoutapp.data.WorkoutRepository
import com.josh.workoutapp.data.db.ReminderSettingEntity
import com.josh.workoutapp.data.db.WorkoutSessionEntity
import com.josh.workoutapp.notifications.NotificationScheduler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Calendar

data class DayCardState(
    val dayId: Int,
    val dayLabel: String,
    val name: String,
    val focus: String,
    val lastSession: WorkoutSessionEntity? = null,
    val reminder: ReminderSettingEntity? = null
)

sealed class PlanImportResult {
    data class Success(val planName: String) : PlanImportResult()
    data class Error(val message: String) : PlanImportResult()
}

class HomeViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: WorkoutRepository =
        (application as WorkoutApp).repository
    private val planManager: PlanManager =
        (application as WorkoutApp).planManager

    private val _cards = MutableStateFlow<List<DayCardState>>(emptyList())
    val cards: StateFlow<List<DayCardState>> = _cards.asStateFlow()

    private val _importResult = MutableStateFlow<PlanImportResult?>(null)
    val importResult: StateFlow<PlanImportResult?> = _importResult.asStateFlow()

    val currentPlanName: String get() = planManager.currentPlanName
    val isUsingCustomPlan: Boolean get() = planManager.isUsingCustomPlan

    init {
        viewModelScope.launch {
            combine(
                repository.getAllSessions(),
                repository.getAllReminders(),
                planManager.planUpdates
            ) { sessions, reminders, _ ->
                planManager.currentDays().map { day ->
                    DayCardState(
                        dayId = day.id,
                        dayLabel = day.dayLabel,
                        name = day.name,
                        focus = day.focus,
                        lastSession = sessions.filter { it.dayId == day.id }
                            .maxByOrNull { it.startTime },
                        reminder = reminders.firstOrNull { it.dayId == day.id }
                    )
                }
            }.collect { _cards.value = it }
        }
    }

    // ── Plan import ───────────────────────────────────────────────────────

    fun importPlan(context: Context, uri: Uri) {
        viewModelScope.launch {
            try {
                val json = withContext(Dispatchers.IO) {
                    context.contentResolver.openInputStream(uri)
                        ?.bufferedReader()
                        ?.use { it.readText() }
                        ?: throw IllegalStateException("Could not open file")
                }
                val planName = planManager.loadFromJson(json)
                _importResult.value = PlanImportResult.Success(planName)
            } catch (e: Exception) {
                _importResult.value = PlanImportResult.Error(
                    e.message ?: "Invalid plan file"
                )
            }
        }
    }

    fun resetToDefaultPlan() {
        planManager.resetToDefault()
    }

    fun clearImportResult() {
        _importResult.value = null
    }

    // ── Reminders ─────────────────────────────────────────────────────────

    fun saveReminder(
        context: Context,
        dayId: Int,
        enabled: Boolean,
        hour: Int,
        minute: Int
    ) {
        viewModelScope.launch {
            val day = planManager.dayById(dayId) ?: return@launch
            val dayOfWeek = when (dayId) {
                1 -> Calendar.TUESDAY
                2 -> Calendar.WEDNESDAY
                3 -> Calendar.THURSDAY
                4 -> Calendar.FRIDAY
                else -> Calendar.TUESDAY
            }
            val reminder = ReminderSettingEntity(
                dayId = dayId,
                enabled = enabled,
                hour = hour,
                minute = minute,
                dayOfWeek = dayOfWeek
            )
            repository.saveReminder(reminder)

            if (enabled) {
                NotificationScheduler.schedule(context, reminder, day.name)
            } else {
                NotificationScheduler.cancel(context, dayId, day.name)
            }
        }
    }

    class Factory(private val application: Application) : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            HomeViewModel(application) as T
    }
}
