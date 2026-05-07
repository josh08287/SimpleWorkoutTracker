package com.josh.workoutapp.data.db

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * One row per workout session (one per day per time you open and start a day's workout).
 */
@Entity(tableName = "workout_sessions")
data class WorkoutSessionEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val dayId: Int,
    val startTime: Long = System.currentTimeMillis(),
    val durationSeconds: Long = 0,
    val completed: Boolean = false
)

/**
 * One row per set completed. Stores the weight used and whether it was checked off.
 * exerciseId matches Exercise.id in WorkoutData (e.g. "d1_e1").
 */
@Entity(tableName = "set_logs")
data class SetLogEntity(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val sessionId: Long,
    val exerciseId: String,
    val setIndex: Int,           // 0-based
    val weightLbs: Float? = null,
    val completed: Boolean = false,
    val timestamp: Long = System.currentTimeMillis()
)

/**
 * Stores the user-configured reminder time for each workout day.
 * hour and minute are in 24h format. enabled toggles the alarm on/off.
 */
@Entity(tableName = "reminder_settings")
data class ReminderSettingEntity(
    @PrimaryKey val dayId: Int,  // matches WorkoutDay.id
    val enabled: Boolean = false,
    val hour: Int = 9,           // default 9:00 AM
    val minute: Int = 0,
    val dayOfWeek: Int           // Calendar.TUESDAY etc.
)
