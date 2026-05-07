package com.josh.workoutapp.data

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.flow.asStateFlow

/**
 * Top-level wrapper used in JSON plan files.
 * Fields not present in the JSON fall back to defaults via Gson's behaviour.
 */
data class WorkoutPlan(
    val planName: String = "Custom Plan",
    val days: List<WorkoutDay> = emptyList()
)

/**
 * Manages which plan is currently active — either the built-in default or a
 * user-imported JSON file.  State is persisted in SharedPreferences so it
 * survives process death.
 */
class PlanManager(context: Context) {

    private val prefs = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE)
    private val gson: Gson = GsonBuilder().create()

    private val _planUpdates = kotlinx.coroutines.flow.MutableStateFlow(0)
    val planUpdates = _planUpdates.asStateFlow()

    // ── Public queries ────────────────────────────────────────────────────

    val currentPlanName: String
        get() = prefs.getString(KEY_PLAN_NAME, DEFAULT_NAME) ?: DEFAULT_NAME

    val isUsingCustomPlan: Boolean
        get() = prefs.contains(KEY_CUSTOM_JSON)

    fun currentDays(): List<WorkoutDay> {
        val json = prefs.getString(KEY_CUSTOM_JSON, null) ?: return WorkoutData.days
        return try {
            val plan = gson.fromJson(json, WorkoutPlan::class.java)
            if (plan.days.isEmpty()) WorkoutData.days else plan.days
        } catch (_: Exception) {
            WorkoutData.days
        }
    }

    fun dayById(id: Int): WorkoutDay? = currentDays().firstOrNull { it.id == id }

    fun updateExerciseInPlan(oldExerciseId: String, newExercise: Exercise) {
        val days = currentDays()
        val oldName = days.flatMap { it.exercises }.find { it.id == oldExerciseId }?.name

        val updatedDays = days.map { day ->
            day.copy(exercises = day.exercises.map { ex ->
                val isMatch = ex.id == oldExerciseId || (oldName != null && ex.name == oldName)
                if (isMatch) newExercise else ex
            })
        }
        val plan = WorkoutPlan(currentPlanName, updatedDays)
        val json = gson.toJson(plan)
        prefs.edit()
            .putString(KEY_CUSTOM_JSON, json)
            .apply()
        _planUpdates.value++
    }

    // ── Mutation ──────────────────────────────────────────────────────────

    /**
     * Parses [json] and, if valid, stores it as the active plan.
     * Returns the plan name on success, or throws on parse/validation failure.
     */
    fun loadFromJson(json: String): String {
        val plan = gson.fromJson(json, WorkoutPlan::class.java)
            ?: throw IllegalArgumentException("Could not parse plan file")
        require(plan.days.isNotEmpty()) { "Plan contains no days" }
        plan.days.forEach { day ->
            require(day.id > 0) { "Every day must have a positive id" }
        }

        prefs.edit()
            .putString(KEY_CUSTOM_JSON, json)
            .putString(KEY_PLAN_NAME, plan.planName)
            .apply()
        _planUpdates.value++
        return plan.planName
    }

    fun resetToDefault() {
        prefs.edit()
            .remove(KEY_CUSTOM_JSON)
            .remove(KEY_PLAN_NAME)
            .apply()
        _planUpdates.value++
    }

    // ── Companion ─────────────────────────────────────────────────────────

    companion object {
        private const val PREFS = "plan_prefs"
        private const val KEY_CUSTOM_JSON = "custom_plan_json"
        private const val KEY_PLAN_NAME = "plan_name"
        private const val DEFAULT_NAME = "Josh's Workout"
    }
}
