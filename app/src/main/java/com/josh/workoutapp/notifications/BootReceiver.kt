package com.josh.workoutapp.notifications

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.josh.workoutapp.data.WorkoutData
import com.josh.workoutapp.data.db.AppDatabase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 * Re-schedules all enabled workout reminders after a device reboot,
 * since AlarmManager alarms do not survive reboots.
 */
class BootReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        if (intent.action != Intent.ACTION_BOOT_COMPLETED) return

        CoroutineScope(Dispatchers.IO).launch {
            val dao = AppDatabase.getInstance(context).workoutDao()
            val reminders = dao.getAllRemindersOnce()
            reminders.filter { it.enabled }.forEach { reminder ->
                val dayName = WorkoutData.dayById(reminder.dayId)?.name ?: return@forEach
                NotificationScheduler.schedule(context, reminder, dayName)
            }
        }
    }
}
