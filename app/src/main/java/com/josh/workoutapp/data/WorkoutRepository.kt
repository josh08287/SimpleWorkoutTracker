package com.josh.workoutapp.data

import com.josh.workoutapp.data.db.*
import kotlinx.coroutines.flow.Flow

class WorkoutRepository(private val dao: WorkoutDao) {

    // ── Sessions ──────────────────────────────────────────────────────────

    suspend fun createSession(dayId: Int): Long =
        dao.insertSession(WorkoutSessionEntity(dayId = dayId))

    suspend fun markSessionComplete(sessionId: Long, durationSeconds: Long) {
        val session = dao.getSessionById(sessionId) ?: return
        dao.updateSession(session.copy(completed = true, durationSeconds = durationSeconds))
    }

    fun getAllSessions(): Flow<List<WorkoutSessionEntity>> = dao.getAllSessions()

    suspend fun getLastSession(dayId: Int): WorkoutSessionEntity? = dao.getLastSession(dayId)

    // ── Set Logs ──────────────────────────────────────────────────────────

    suspend fun saveSetLog(
        sessionId: Long,
        exerciseId: String,
        setIndex: Int,
        weightLbs: Float?,
        completed: Boolean
    ) {
        dao.upsertSetLog(
            SetLogEntity(
                sessionId = sessionId,
                exerciseId = exerciseId,
                setIndex = setIndex,
                weightLbs = weightLbs,
                completed = completed
            )
        )
    }

    fun getSetLogsForSession(sessionId: Long): Flow<List<SetLogEntity>> =
        dao.getSetLogsForSession(sessionId)

    suspend fun getSetLogsForSessionOnce(sessionId: Long): List<SetLogEntity> =
        dao.getSetLogsForSessionOnce(sessionId)

    /**
     * Returns the last weight used for an exercise, or null if no history.
     * This is used to pre-fill the weight input field.
     */
    suspend fun getLastUsedWeight(exerciseId: String): Float? =
        dao.getLastUsedWeight(exerciseId)

    // ── Reminder Settings ─────────────────────────────────────────────────

    suspend fun saveReminder(reminder: ReminderSettingEntity) =
        dao.upsertReminder(reminder)

    fun getAllReminders(): Flow<List<ReminderSettingEntity>> = dao.getAllReminders()

    suspend fun getReminderForDay(dayId: Int): ReminderSettingEntity? =
        dao.getReminderForDay(dayId)

    suspend fun getAllRemindersOnce(): List<ReminderSettingEntity> =
        dao.getAllRemindersOnce()
}
