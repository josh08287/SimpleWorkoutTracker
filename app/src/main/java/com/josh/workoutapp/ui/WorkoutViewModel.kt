package com.josh.workoutapp.ui

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.josh.workoutapp.WorkoutApp
import com.josh.workoutapp.data.Exercise
import com.josh.workoutapp.data.PlanManager
import com.josh.workoutapp.data.TrackingType
import com.josh.workoutapp.data.WarmupExercise
import com.josh.workoutapp.data.WorkoutDay
import com.josh.workoutapp.data.WorkoutRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

// ── UI state model ────────────────────────────────────────────────────────────

data class SetUiState(
    val index: Int,
    val weightInput: String = "",  // lbs as typed by the user
    val completed: Boolean = false
)

data class ExerciseUiState(
    val exercise: Exercise,
    val isExpanded: Boolean = false,
    val suggestedWeight: Float? = null,  // null = no history
    val sets: List<SetUiState>
)

data class WarmupUiState(
    val warmup: WarmupExercise,
    val checked: Boolean = false
)

data class WorkoutUiState(
    val day: WorkoutDay,
    val sessionId: Long = -1L,
    val warmupExpanded: Boolean = true,
    val warmupStates: List<WarmupUiState> = emptyList(),
    val exerciseStates: List<ExerciseUiState> = emptyList(),
    val isLoading: Boolean = true,
    val workoutStarted: Boolean = false,
    val totalSeconds: Long = 0L,
    val restSecondsLeft: Int = 0,
    val isRestTimerActive: Boolean = false
)

// ── ViewModel ─────────────────────────────────────────────────────────────────

class WorkoutViewModel(
    application: Application,
    private val dayId: Int
) : AndroidViewModel(application) {

    private val repository: WorkoutRepository =
        (application as WorkoutApp).repository
    private val planManager: PlanManager =
        (application as WorkoutApp).planManager

    private val _uiState = MutableStateFlow(
        WorkoutUiState(day = planManager.dayById(dayId)!!)
    )
    val uiState: StateFlow<WorkoutUiState> = _uiState.asStateFlow()

    private var stopwatchJob: Job? = null
    private var restTimerJob: Job? = null

    init {
        // Create the session up front so it's available regardless of plan updates.
        viewModelScope.launch {
            val sessionId = repository.createSession(dayId)
            _uiState.update { it.copy(sessionId = sessionId) }
        }
        // Keep UI in sync with plan changes (e.g. exercise swaps).
        viewModelScope.launch {
            planManager.planUpdates.collect {
                refreshWorkoutState()
            }
        }
    }

    private suspend fun refreshWorkoutState() {
        val day = planManager.dayById(dayId) ?: return
        val currentExercises = _uiState.value.exerciseStates.associateBy { it.exercise.id }
        val currentWarmups = _uiState.value.warmupStates.associateBy { it.warmup.id }

        val warmupStates = day.warmupExercises.map { warmup ->
            WarmupUiState(
                warmup = warmup,
                checked = currentWarmups[warmup.id]?.checked ?: false
            )
        }

        val exerciseStates = day.exercises.map { exercise ->
            val existing = currentExercises[exercise.id]
            if (existing != null && existing.exercise == exercise) {
                // If the exercise hasn't changed, keep its current state (sets, expanded, etc.)
                existing
            } else {
                // Exercise is new or changed (e.g., swapped)
                val lastWeight = if (exercise.trackingType == TrackingType.WEIGHT_REPS) {
                    repository.getLastUsedWeight(exercise.id)
                } else null

                ExerciseUiState(
                    exercise = exercise,
                    suggestedWeight = lastWeight,
                    sets = (0 until exercise.sets).map { i ->
                        SetUiState(
                            index = i,
                            weightInput = lastWeight?.let {
                                if (it == it.toLong().toFloat()) it.toLong().toString()
                                else it.toString()
                            } ?: ""
                        )
                    }
                )
            }
        }

        _uiState.update {
            it.copy(
                day = day,
                warmupStates = warmupStates,
                exerciseStates = exerciseStates,
                isLoading = false
            )
        }
    }

    // ── User actions ──────────────────────────────────────────────────

    fun startWorkout() {
        if (_uiState.value.workoutStarted) return
        _uiState.update { it.copy(workoutStarted = true) }
        startStopwatch()
    }

    private fun startStopwatch() {
        stopwatchJob?.cancel()
        stopwatchJob = viewModelScope.launch {
            val startTime = System.currentTimeMillis()
            while (true) {
                delay(1000)
                _uiState.update { it.copy(totalSeconds = (System.currentTimeMillis() - startTime) / 1000) }
            }
        }
    }

    private fun startRestTimer(seconds: Int) {
        restTimerJob?.cancel()
        _uiState.update { it.copy(restSecondsLeft = seconds, isRestTimerActive = true) }
        restTimerJob = viewModelScope.launch {
            while (_uiState.value.restSecondsLeft > 0) {
                delay(1000)
                _uiState.update { it.copy(restSecondsLeft = it.restSecondsLeft - 1) }
            }
            _uiState.update { it.copy(isRestTimerActive = false) }
        }
    }

    fun toggleWarmupSection() {
        _uiState.update { it.copy(warmupExpanded = !it.warmupExpanded) }
    }

    fun checkWarmup(warmupId: String) {
        _uiState.update { state ->
            state.copy(
                warmupStates = state.warmupStates.map { ws ->
                    if (ws.warmup.id == warmupId) ws.copy(checked = !ws.checked) else ws
                }
            )
        }
    }

    fun toggleExpanded(exerciseId: String) {
        _uiState.update { state ->
            state.copy(
                exerciseStates = state.exerciseStates.map { es ->
                    if (es.exercise.id == exerciseId) es.copy(isExpanded = !es.isExpanded)
                    else es
                }
            )
        }
    }

    fun updateWeight(exerciseId: String, setIndex: Int, weight: String) {
        _uiState.update { state ->
            state.copy(
                exerciseStates = state.exerciseStates.map { es ->
                    if (es.exercise.id != exerciseId) return@map es
                    es.copy(
                        sets = es.sets.map { s ->
                            if (s.index == setIndex) s.copy(weightInput = weight) else s
                        }
                    )
                }
            )
        }
    }

    fun completeSet(exerciseId: String, setIndex: Int) {
        val state = _uiState.value
        val exerciseState = state.exerciseStates.firstOrNull { it.exercise.id == exerciseId } ?: return
        val setState = exerciseState.sets.getOrNull(setIndex) ?: return
        val weightLbs = setState.weightInput.toFloatOrNull()

        // Persist to DB
        viewModelScope.launch {
            repository.saveSetLog(
                sessionId = state.sessionId,
                exerciseId = exerciseId,
                setIndex = setIndex,
                weightLbs = weightLbs,
                completed = true
            )
        }

        // Update UI
        _uiState.update { s ->
            s.copy(
                exerciseStates = s.exerciseStates.map { es ->
                    if (es.exercise.id != exerciseId) return@map es
                    es.copy(
                        sets = es.sets.map { set ->
                            if (set.index == setIndex) set.copy(completed = true) else set
                        }
                    )
                }
            )
        }

        // Start rest timer
        startRestTimer(exerciseState.exercise.restSeconds)
    }

    fun uncompleteSet(exerciseId: String, setIndex: Int) {
        viewModelScope.launch {
            val state = _uiState.value
            val exerciseState = state.exerciseStates.firstOrNull { it.exercise.id == exerciseId } ?: return@launch
            val setState = exerciseState.sets.getOrNull(setIndex) ?: return@launch
            repository.saveSetLog(
                sessionId = state.sessionId,
                exerciseId = exerciseId,
                setIndex = setIndex,
                weightLbs = setState.weightInput.toFloatOrNull(),
                completed = false
            )
        }
        _uiState.update { s ->
            s.copy(
                exerciseStates = s.exerciseStates.map { es ->
                    if (es.exercise.id != exerciseId) return@map es
                    es.copy(
                        sets = es.sets.map { set ->
                            if (set.index == setIndex) set.copy(completed = false) else set
                        }
                    )
                }
            )
        }
    }

    fun skipExercise(exerciseId: String) {
        val state = _uiState.value
        val exerciseState = state.exerciseStates.firstOrNull { it.exercise.id == exerciseId } ?: return
        
        // Mark all sets as completed
        viewModelScope.launch {
            exerciseState.sets.forEach { set ->
                repository.saveSetLog(
                    sessionId = state.sessionId,
                    exerciseId = exerciseId,
                    setIndex = set.index,
                    weightLbs = set.weightInput.toFloatOrNull(),
                    completed = true
                )
            }
        }

        _uiState.update { s ->
            s.copy(
                exerciseStates = s.exerciseStates.map { es ->
                    if (es.exercise.id != exerciseId) return@map es
                    es.copy(
                        isExpanded = false,
                        sets = es.sets.map { it.copy(completed = true) }
                    )
                }
            )
        }
    }

    fun swapExercise(currentExerciseId: String, newExercise: Exercise) {
        viewModelScope.launch {
            // Persist the swap in the plan so it stays swapped across all days and app restarts
            planManager.updateExerciseInPlan(currentExerciseId, newExercise)
            // The UI will update automatically via the planUpdates flow collection in init
        }
    }

    fun finishWorkout(onComplete: () -> Unit) {
        val sessionId = _uiState.value.sessionId
        val duration = _uiState.value.totalSeconds
        viewModelScope.launch {
            if (sessionId != -1L) {
                repository.markSessionComplete(sessionId, duration)
            }
        }
        onComplete()
    }

    // ── Progress helpers ──────────────────────────────────────────────────

    val completedExerciseCount: Int
        get() = _uiState.value.exerciseStates.count { es ->
            es.sets.all { it.completed }
        }

    val totalExerciseCount: Int
        get() = _uiState.value.exerciseStates.size

    // ── Factory ───────────────────────────────────────────────────────────

    class Factory(private val application: Application, private val dayId: Int) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T =
            WorkoutViewModel(application, dayId) as T
    }
}
