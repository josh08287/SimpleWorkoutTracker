package com.josh.workoutapp.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface WorkoutDao {

    // ── Sessions ──────────────────────────────────────────────────────────

    @Insert
    suspend fun insertSession(session: WorkoutSessionEntity): Long

    @Update
    suspend fun updateSession(session: WorkoutSessionEntity)

    @Query("SELECT * FROM workout_sessions WHERE id = :sessionId")
    suspend fun getSessionById(sessionId: Long): WorkoutSessionEntity?

    @Query("SELECT * FROM workout_sessions WHERE dayId = :dayId ORDER BY startTime DESC LIMIT 1")
    suspend fun getLastSession(dayId: Int): WorkoutSessionEntity?

    @Query("SELECT * FROM workout_sessions ORDER BY startTime DESC")
    fun getAllSessions(): Flow<List<WorkoutSessionEntity>>

    // ── Set Logs ──────────────────────────────────────────────────────────

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertSetLog(setLog: SetLogEntity): Long

    @Query("SELECT * FROM set_logs WHERE sessionId = :sessionId ORDER BY exerciseId, setIndex")
    fun getSetLogsForSession(sessionId: Long): Flow<List<SetLogEntity>>

    @Query("SELECT * FROM set_logs WHERE sessionId = :sessionId ORDER BY exerciseId, setIndex")
    suspend fun getSetLogsForSessionOnce(sessionId: Long): List<SetLogEntity>

    /**
     * Returns the most recently logged weight for a given exercise across all sessions.
     * Used to pre-fill the weight input when starting a new session.
     */
    @Query("""
        SELECT sl.weightLbs FROM set_logs sl
        INNER JOIN workout_sessions ws ON sl.sessionId = ws.id
        WHERE sl.exerciseId = :exerciseId AND sl.completed = 1 AND sl.weightLbs IS NOT NULL
        ORDER BY ws.startTime DESC
        LIMIT 1
    """)
    suspend fun getLastUsedWeight(exerciseId: String): Float?

    // ── Reminder Settings ─────────────────────────────────────────────────

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsertReminder(reminder: ReminderSettingEntity)

    @Query("SELECT * FROM reminder_settings ORDER BY dayId")
    fun getAllReminders(): Flow<List<ReminderSettingEntity>>

    @Query("SELECT * FROM reminder_settings WHERE dayId = :dayId")
    suspend fun getReminderForDay(dayId: Int): ReminderSettingEntity?

    @Query("SELECT * FROM reminder_settings")
    suspend fun getAllRemindersOnce(): List<ReminderSettingEntity>
}
