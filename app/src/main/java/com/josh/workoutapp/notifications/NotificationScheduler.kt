package com.josh.workoutapp.notifications

import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import com.josh.workoutapp.data.db.ReminderSettingEntity
import java.util.Calendar

const val CHANNEL_ID = "workout_reminders"
const val EXTRA_DAY_ID = "extra_day_id"
const val EXTRA_DAY_NAME = "extra_day_name"

object NotificationScheduler {

    fun createChannel(context: Context) {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Workout Reminders",
            NotificationManager.IMPORTANCE_HIGH
        ).apply {
            description = "15-minute reminders before your scheduled workouts"
        }
        val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    /**
     * Schedules (or re-schedules) a weekly repeating alarm for the given reminder.
     * The alarm fires 15 minutes BEFORE the configured workout time.
     */
    fun schedule(context: Context, reminder: ReminderSettingEntity, dayName: String) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val pendingIntent = buildPendingIntent(context, reminder.dayId, dayName)

        // Calculate the next occurrence of this day/time minus 15 minutes
        val triggerAt = nextTriggerMillis(
            dayOfWeek = reminder.dayOfWeek,
            hour = reminder.hour,
            minute = reminder.minute,
            offsetMinutes = -15
        )

        // Schedule as a weekly repeating exact alarm
        alarmManager.setRepeating(
            AlarmManager.RTC_WAKEUP,
            triggerAt,
            AlarmManager.INTERVAL_DAY * 7,
            pendingIntent
        )
    }

    /**
     * Cancels the alarm for a given day.
     */
    fun cancel(context: Context, dayId: Int, dayName: String) {
        val alarmManager = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.cancel(buildPendingIntent(context, dayId, dayName))
    }

    private fun buildPendingIntent(context: Context, dayId: Int, dayName: String): PendingIntent {
        val intent = Intent(context, WorkoutAlarmReceiver::class.java).apply {
            putExtra(EXTRA_DAY_ID, dayId)
            putExtra(EXTRA_DAY_NAME, dayName)
        }
        return PendingIntent.getBroadcast(
            context,
            dayId, // unique request code per day
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )
    }

    /**
     * Finds the next epoch-millisecond timestamp for a given day-of-week and time,
     * offset by [offsetMinutes] (negative = earlier).
     */
    private fun nextTriggerMillis(
        dayOfWeek: Int,
        hour: Int,
        minute: Int,
        offsetMinutes: Int
    ): Long {
        val cal = Calendar.getInstance().apply {
            set(Calendar.DAY_OF_WEEK, dayOfWeek)
            set(Calendar.HOUR_OF_DAY, hour)
            set(Calendar.MINUTE, minute + offsetMinutes)
            set(Calendar.SECOND, 0)
            set(Calendar.MILLISECOND, 0)
        }
        // If the time has already passed this week, advance by 7 days
        if (cal.timeInMillis <= System.currentTimeMillis()) {
            cal.add(Calendar.WEEK_OF_YEAR, 1)
        }
        return cal.timeInMillis
    }
}
