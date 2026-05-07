package com.josh.workoutapp.ui.screens

import android.app.Application
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.FileOpen
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.RestartAlt
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josh.workoutapp.ui.DayCardState
import com.josh.workoutapp.ui.HomeViewModel
import com.josh.workoutapp.ui.PlanImportResult
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    onStartWorkout: (Int) -> Unit,
    onViewHistory: () -> Unit,
    vm: HomeViewModel = viewModel(
        factory = HomeViewModel.Factory(
            LocalContext.current.applicationContext as Application
        )
    )
) {
    val cards by vm.cards.collectAsState()
    val importResult by vm.importResult.collectAsState()
    val context = LocalContext.current
    var showMenu by remember { mutableStateOf(false) }
    var showResetDialog by remember { mutableStateOf(false) }

    // File picker — opens any JSON file from device storage
    val importLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.OpenDocument()
    ) { uri ->
        uri?.let { vm.importPlan(context, it) }
    }

    // React to import results with a toast
    LaunchedEffect(importResult) {
        importResult?.let { result ->
            when (result) {
                is PlanImportResult.Success ->
                    Toast.makeText(context, "Loaded: ${result.planName}", Toast.LENGTH_SHORT).show()
                is PlanImportResult.Error ->
                    Toast.makeText(context, "Import failed: ${result.message}", Toast.LENGTH_LONG).show()
            }
            vm.clearImportResult()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(vm.currentPlanName, fontWeight = FontWeight.Bold)
                        if (vm.isUsingCustomPlan) {
                            Text(
                                "Custom plan",
                                style = MaterialTheme.typography.labelSmall,
                                color = MaterialTheme.colorScheme.primary
                            )
                        }
                    }
                },
                actions = {
                    IconButton(onClick = onViewHistory) {
                        Icon(Icons.Default.History, contentDescription = "View History")
                    }
                    // Overflow menu for plan management
                    Box {
                        IconButton(onClick = { showMenu = true }) {
                            Icon(Icons.Default.MoreVert, contentDescription = "Plan options")
                        }
                        DropdownMenu(
                            expanded = showMenu,
                            onDismissRequest = { showMenu = false }
                        ) {
                            DropdownMenuItem(
                                text = { Text("Import plan from JSON") },
                                leadingIcon = {
                                    Icon(Icons.Default.FileOpen, contentDescription = null)
                                },
                                onClick = {
                                    showMenu = false
                                    importLauncher.launch(arrayOf("application/json", "text/plain", "*/*"))
                                }
                            )
                            if (vm.isUsingCustomPlan) {
                                DropdownMenuItem(
                                    text = { Text("Reset to default plan") },
                                    leadingIcon = {
                                        Icon(Icons.Default.RestartAlt, contentDescription = null)
                                    },
                                    onClick = {
                                        showMenu = false
                                        showResetDialog = true
                                    }
                                )
                            }
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->
        if (showResetDialog) {
            AlertDialog(
                onDismissRequest = { showResetDialog = false },
                title = { Text("Reset Plan?") },
                text = { Text("This will undo all exercise swaps and restore the original workout plan. Your workout history will not be affected.") },
                confirmButton = {
                    TextButton(
                        onClick = {
                            vm.resetToDefaultPlan()
                            showResetDialog = false
                            Toast.makeText(context, "Restored default plan", Toast.LENGTH_SHORT).show()
                        }
                    ) { Text("Reset") }
                },
                dismissButton = {
                    TextButton(onClick = { showResetDialog = false }) { Text("Cancel") }
                }
            )
        }

        LazyColumn(
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            item {
                Text(
                    text = "Select a day to begin",
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    modifier = Modifier.padding(bottom = 4.dp)
                )
            }
            items(cards) { card ->
                DayCard(
                    card = card,
                    onStart = { onStartWorkout(card.dayId) },
                    onSaveReminder = { enabled, hour, minute ->
                        vm.saveReminder(
                            context = context,
                            dayId = card.dayId,
                            enabled = enabled,
                            hour = hour,
                            minute = minute
                        )
                    }
                )
            }
        }
    }
}

@Composable
private fun DayCard(
    card: DayCardState,
    onStart: () -> Unit,
    onSaveReminder: (Boolean, Int, Int) -> Unit
) {
    var showReminderSheet by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Day label + bell icon
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = card.dayLabel,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                IconButton(onClick = { showReminderSheet = true }) {
                    val hasReminder = card.reminder?.enabled == true
                    Icon(
                        imageVector = if (hasReminder) Icons.Default.Notifications
                                      else Icons.Default.NotificationsOff,
                        contentDescription = "Set reminder",
                        tint = if (hasReminder) MaterialTheme.colorScheme.primary
                               else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f)
                    )
                }
            }

            Spacer(Modifier.height(4.dp))
            Text(
                text = card.name,
                style = MaterialTheme.typography.titleMedium,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.focus,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(top = 2.dp)
            )

            // Last session date
            card.lastSession?.let { session ->
                val fmt = SimpleDateFormat("MMM d, yyyy", Locale.getDefault())
                Text(
                    text = "Last: ${fmt.format(Date(session.startTime))}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.secondary,
                    modifier = Modifier.padding(top = 6.dp)
                )
            } ?: Text(
                text = "No sessions yet",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                modifier = Modifier.padding(top = 6.dp)
            )

            // Reminder time summary
            card.reminder?.takeIf { it.enabled }?.let { r ->
                val amPm = if (r.hour < 12) "AM" else "PM"
                val h = if (r.hour % 12 == 0) 12 else r.hour % 12
                val m = r.minute.toString().padStart(2, '0')
                Text(
                    text = "Reminder: $h:$m $amPm (15 min before)",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.primary.copy(alpha = 0.8f),
                    modifier = Modifier.padding(top = 2.dp)
                )
            }

            Spacer(Modifier.height(12.dp))
            Button(
                onClick = onStart,
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.primary
                )
            ) {
                Icon(Icons.Default.PlayArrow, contentDescription = null)
                Spacer(Modifier.width(6.dp))
                Text("Start Workout")
            }
        }
    }

    if (showReminderSheet) {
        ReminderSheet(
            currentReminder = card.reminder,
            onDismiss = { showReminderSheet = false },
            onSave = { enabled, hour, minute ->
                onSaveReminder(enabled, hour, minute)
                showReminderSheet = false
            }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ReminderSheet(
    currentReminder: com.josh.workoutapp.data.db.ReminderSettingEntity?,
    onDismiss: () -> Unit,
    onSave: (Boolean, Int, Int) -> Unit
) {
    var enabled by remember { mutableStateOf(currentReminder?.enabled ?: false) }
    var hour by remember { mutableIntStateOf(currentReminder?.hour ?: 9) }
    var minute by remember { mutableIntStateOf(currentReminder?.minute ?: 0) }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp, vertical = 8.dp)
                .navigationBarsPadding()
        ) {
            Text(
                "Workout Reminder",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Text(
                "You'll get a notification 15 minutes before the time you set.",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                modifier = Modifier.padding(top = 4.dp, bottom = 16.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text("Enable reminder", style = MaterialTheme.typography.bodyLarge)
                Switch(checked = enabled, onCheckedChange = { enabled = it })
            }

            if (enabled) {
                Spacer(Modifier.height(20.dp))
                Text(
                    "Workout start time",
                    style = MaterialTheme.typography.labelLarge,
                    modifier = Modifier.padding(bottom = 12.dp)
                )
                TimePickerRow(hour = hour, minute = minute, onHourChange = { hour = it }, onMinuteChange = { minute = it })
            }

            Spacer(Modifier.height(24.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                OutlinedButton(onClick = onDismiss, modifier = Modifier.weight(1f)) {
                    Text("Cancel")
                }
                Button(
                    onClick = { onSave(enabled, hour, minute) },
                    modifier = Modifier.weight(1f)
                ) {
                    Text("Save")
                }
            }
            Spacer(Modifier.height(12.dp))
        }
    }
}

@Composable
private fun TimePickerRow(
    hour: Int,
    minute: Int,
    onHourChange: (Int) -> Unit,
    onMinuteChange: (Int) -> Unit
) {
    val amPm = if (hour < 12) "AM" else "PM"
    val displayHour = if (hour % 12 == 0) 12 else hour % 12

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        // Hour spinner
        NumberStepper(
            label = "Hour",
            value = displayHour,
            range = 1..12,
            onDecrease = {
                val newH = if (hour == 0) 23 else hour - 1
                onHourChange(newH)
            },
            onIncrease = {
                val newH = if (hour == 23) 0 else hour + 1
                onHourChange(newH)
            }
        )
        Text(":", style = MaterialTheme.typography.headlineMedium, fontWeight = FontWeight.Bold)
        // Minute stepper (steps of 5)
        NumberStepper(
            label = "Min",
            value = minute,
            display = minute.toString().padStart(2, '0'),
            range = 0..59,
            onDecrease = {
                val newM = if (minute < 5) 55 else minute - 5
                onMinuteChange(newM)
            },
            onIncrease = {
                val newM = if (minute >= 55) 0 else minute + 5
                onMinuteChange(newM)
            }
        )
        // AM/PM toggle
        FilledTonalButton(onClick = {
            onHourChange(if (hour < 12) hour + 12 else hour - 12)
        }) {
            Text(amPm, style = MaterialTheme.typography.titleMedium)
        }
    }
}

@Composable
private fun NumberStepper(
    label: String,
    value: Int,
    display: String = value.toString(),
    range: IntRange,
    onDecrease: () -> Unit,
    onIncrease: () -> Unit
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(label, style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f))
        Row(verticalAlignment = Alignment.CenterVertically) {
            FilledTonalButton(
                onClick = onDecrease,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(36.dp)
            ) { Text("−", style = MaterialTheme.typography.titleLarge) }
            Text(
                text = display,
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 10.dp)
            )
            FilledTonalButton(
                onClick = onIncrease,
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier.size(36.dp)
            ) { Text("+", style = MaterialTheme.typography.titleLarge) }
        }
    }
}
