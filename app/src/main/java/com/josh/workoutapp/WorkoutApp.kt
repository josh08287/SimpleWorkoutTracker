package com.josh.workoutapp

import android.app.Application
import com.josh.workoutapp.data.PlanManager
import com.josh.workoutapp.data.WorkoutRepository
import com.josh.workoutapp.data.db.AppDatabase
import com.josh.workoutapp.notifications.NotificationScheduler

class WorkoutApp : Application() {

    val database by lazy { AppDatabase.getInstance(this) }
    val repository by lazy { WorkoutRepository(database.workoutDao()) }
    val planManager by lazy { PlanManager(this) }

    override fun onCreate() {
        super.onCreate()
        NotificationScheduler.createChannel(this)
    }
}
