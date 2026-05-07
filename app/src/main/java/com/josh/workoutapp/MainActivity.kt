package com.josh.workoutapp

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.josh.workoutapp.notifications.EXTRA_DAY_ID
import com.josh.workoutapp.ui.screens.ActiveWorkoutScreen
import com.josh.workoutapp.ui.screens.HistoryScreen
import com.josh.workoutapp.ui.screens.HomeScreen
import com.josh.workoutapp.ui.theme.WorkoutTheme

class MainActivity : ComponentActivity() {

    private val requestPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { /* no-op */ }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Request POST_NOTIFICATIONS on Android 13+
        if (checkSelfPermission(Manifest.permission.POST_NOTIFICATIONS)
            != PackageManager.PERMISSION_GRANTED
        ) {
            requestPermissionLauncher.launch(Manifest.permission.POST_NOTIFICATIONS)
        }

        // If launched from a notification tap, deep-link directly to that day's workout
        val deepLinkDayId = intent.getIntExtra(EXTRA_DAY_ID, -1)

        setContent {
            WorkoutTheme {
                WorkoutNavHost(startDayId = deepLinkDayId.takeIf { it > 0 })
            }
        }
    }
}

@Composable
private fun WorkoutNavHost(startDayId: Int?) {
    val navController = rememberNavController()
    val startDestination = if (startDayId != null) "workout/$startDayId" else "home"

    NavHost(navController = navController, startDestination = startDestination) {
        composable("home") {
            HomeScreen(
                onStartWorkout = { dayId -> navController.navigate("workout/$dayId") },
                onViewHistory = { navController.navigate("history") }
            )
        }
        composable("history") {
            HistoryScreen(onBack = { navController.popBackStack() })
        }
        composable(
            route = "workout/{dayId}",
            arguments = listOf(navArgument("dayId") { type = NavType.IntType })
        ) { backStackEntry ->
            val dayId = backStackEntry.arguments!!.getInt("dayId")
            ActiveWorkoutScreen(
                dayId = dayId,
                onBack = { navController.popBackStack() }
            )
        }
    }
}
