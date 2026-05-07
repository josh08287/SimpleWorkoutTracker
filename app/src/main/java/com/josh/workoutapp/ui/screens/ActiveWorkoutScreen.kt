package com.josh.workoutapp.ui.screens

import android.app.Application
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.expandVertically
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.SwapHoriz
import androidx.compose.material.icons.filled.Timer
import androidx.compose.material.icons.outlined.Circle
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.foundation.clickable
import com.josh.workoutapp.data.CatalogExercise
import com.josh.workoutapp.data.Exercise
import com.josh.workoutapp.data.ExerciseDatabase
import com.josh.workoutapp.data.MuscleGroup
import com.josh.workoutapp.data.TrackingType
import com.josh.workoutapp.data.WarmupExercise
import com.josh.workoutapp.ui.ExerciseUiState
import com.josh.workoutapp.ui.SetUiState
import com.josh.workoutapp.ui.WarmupUiState
import com.josh.workoutapp.ui.WorkoutViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ActiveWorkoutScreen(
    dayId: Int,
    onBack: () -> Unit,
    vm: WorkoutViewModel = viewModel(
        factory = WorkoutViewModel.Factory(
            LocalContext.current.applicationContext as Application,
            dayId
        )
    )
) {
    val state by vm.uiState.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text(state.day.name, fontWeight = FontWeight.Bold)
                        Text(
                            if (state.workoutStarted) formatTime(state.totalSeconds) else state.day.dayLabel,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.primary
                        )
                    }
                },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                actions = {
                    if (state.isRestTimerActive) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier.padding(end = 16.dp)
                        ) {
                            Icon(
                                Icons.Default.Timer,
                                contentDescription = null,
                                tint = MaterialTheme.colorScheme.primary,
                                modifier = Modifier.size(18.dp)
                            )
                            Spacer(Modifier.width(4.dp))
                            Text(
                                text = "${state.restSecondsLeft}s",
                                style = MaterialTheme.typography.labelLarge,
                                color = MaterialTheme.colorScheme.primary,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surface
                )
            )
        }
    ) { padding ->

        if (state.isLoading) {
            Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }

        if (!state.workoutStarted) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding),
                contentAlignment = Alignment.Center
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        state.day.name,
                        style = MaterialTheme.typography.headlineMedium,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        state.day.focus,
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.secondary
                    )
                    Spacer(Modifier.height(32.dp))
                    Button(
                        onClick = { vm.startWorkout() },
                        modifier = Modifier
                            .fillMaxWidth(0.7f)
                            .height(56.dp),
                        shape = MaterialTheme.shapes.large
                    ) {
                        Icon(Icons.Default.PlayArrow, contentDescription = null)
                        Spacer(Modifier.width(8.dp))
                        Text("START WORKOUT", fontWeight = FontWeight.Bold)
                    }
                }
            }
            return@Scaffold
        }

        LazyColumn(
            contentPadding = PaddingValues(start = 16.dp, end = 16.dp, top = 12.dp, bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            // Progress header
            item {
                val completed = state.exerciseStates.count { es -> es.sets.all { it.completed } }
                val total = state.exerciseStates.size
                Column(modifier = Modifier.padding(bottom = 4.dp)) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            "$completed / $total exercises complete",
                            style = MaterialTheme.typography.labelMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
                        )
                        Text(
                            state.day.focus,
                            style = MaterialTheme.typography.labelSmall,
                            color = MaterialTheme.colorScheme.secondary
                        )
                    }
                    Spacer(Modifier.height(6.dp))
                    LinearProgressIndicator(
                        progress = { if (total == 0) 0f else completed.toFloat() / total },
                        modifier = Modifier.fillMaxWidth(),
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }

            // Warm-up section (only if this day has warm-ups)
            if (state.warmupStates.isNotEmpty()) {
                item {
                    WarmupSectionHeader(
                        duration = state.day.warmupDuration,
                        expanded = state.warmupExpanded,
                        checkedCount = state.warmupStates.count { it.checked },
                        totalCount = state.warmupStates.size,
                        onToggle = { vm.toggleWarmupSection() }
                    )
                }
                item {
                    AnimatedVisibility(
                        visible = state.warmupExpanded,
                        enter = expandVertically(),
                        exit = shrinkVertically()
                    ) {
                        Card(
                            modifier = Modifier.fillMaxWidth(),
                            colors = CardDefaults.cardColors(
                                containerColor = MaterialTheme.colorScheme.surfaceVariant
                            ),
                            elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
                        ) {
                            Column(
                                modifier = Modifier.padding(vertical = 6.dp),
                                verticalArrangement = Arrangement.spacedBy(2.dp)
                            ) {
                                state.warmupStates.forEach { ws ->
                                    WarmupItem(
                                        warmupUiState = ws,
                                        onCheck = { vm.checkWarmup(ws.warmup.id) }
                                    )
                                }
                            }
                        }
                    }
                }
            }

            // Exercise cards
            items(state.exerciseStates, key = { it.exercise.id }) { exerciseState ->
                ExerciseCard(
                    exerciseState = exerciseState,
                    onToggleExpand = { vm.toggleExpanded(exerciseState.exercise.id) },
                    onWeightChange = { setIndex, weight ->
                        vm.updateWeight(exerciseState.exercise.id, setIndex, weight)
                    },
                    onCompleteSet = { setIndex ->
                        vm.completeSet(exerciseState.exercise.id, setIndex)
                    },
                    onUncompleteSet = { setIndex ->
                        vm.uncompleteSet(exerciseState.exercise.id, setIndex)
                    },
                    onSkip = { vm.skipExercise(exerciseState.exercise.id) },
                    onSwap = { newExercise ->
                        vm.swapExercise(exerciseState.exercise.id, newExercise)
                    }
                )
            }

            // Finish button
            item {
                Spacer(Modifier.height(16.dp))
                Button(
                    onClick = { vm.finishWorkout(onBack) },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary
                    )
                ) {
                    Text("Finish Workout")
                }
            }
        }
    }
}

@Composable
private fun WarmupSectionHeader(
    duration: String,
    expanded: Boolean,
    checkedCount: Int,
    totalCount: Int,
    onToggle: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 2.dp, vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                "Warm-Up  ·  $duration",
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                "$checkedCount / $totalCount done",
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.55f)
            )
        }
        IconButton(onClick = onToggle, modifier = Modifier.size(32.dp)) {
            Icon(
                imageVector = if (expanded) Icons.Default.ExpandLess else Icons.Default.ExpandMore,
                contentDescription = if (expanded) "Collapse warm-up" else "Expand warm-up",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
            )
        }
    }
}

@Composable
private fun WarmupItem(
    warmupUiState: WarmupUiState,
    onCheck: () -> Unit
) {
    val warmup = warmupUiState.warmup
    var showInfo by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(
                if (warmupUiState.checked) MaterialTheme.colorScheme.primary.copy(alpha = 0.10f)
                else Color.Transparent
            )
            .padding(horizontal = 14.dp, vertical = 6.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = warmup.name,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.Medium,
                color = if (warmupUiState.checked)
                    MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                else
                    MaterialTheme.colorScheme.onSurface
            )
            Text(
                text = warmup.repsDisplay,
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
            )
        }
        // Info button
        IconButton(onClick = { showInfo = true }, modifier = Modifier.size(32.dp)) {
            Icon(
                Icons.Default.Info,
                contentDescription = "Exercise info",
                tint = MaterialTheme.colorScheme.secondary,
                modifier = Modifier.size(18.dp)
            )
        }
        // Check button
        IconButton(onClick = onCheck, modifier = Modifier.size(36.dp)) {
            Icon(
                imageVector = if (warmupUiState.checked) Icons.Filled.CheckCircle
                              else Icons.Outlined.Circle,
                contentDescription = if (warmupUiState.checked) "Uncheck" else "Done",
                tint = if (warmupUiState.checked) MaterialTheme.colorScheme.primary
                       else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.35f),
                modifier = Modifier.size(24.dp)
            )
        }
    }

    if (showInfo) {
        ExerciseInfoSheet(
            name = warmup.name,
            fullDescription = warmup.fullDescription,
            onDismiss = { showInfo = false }
        )
    }
}

@Composable
private fun ExerciseCard(
    exerciseState: ExerciseUiState,
    onToggleExpand: () -> Unit,
    onWeightChange: (Int, String) -> Unit,
    onCompleteSet: (Int) -> Unit,
    onUncompleteSet: (Int) -> Unit,
    onSkip: () -> Unit,
    onSwap: (Exercise) -> Unit
) {
    val exercise = exerciseState.exercise
    val allSetsComplete = exerciseState.sets.isNotEmpty() && exerciseState.sets.all { it.completed }
    var showInfo by remember { mutableStateOf(false) }
    var showSwap by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = if (allSetsComplete)
                MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
            else
                MaterialTheme.colorScheme.surface
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column {
            // ── Header row ────────────────────────────────────────────────
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 14.dp, vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // Completion indicator
                Icon(
                    imageVector = if (allSetsComplete) Icons.Filled.CheckCircle
                                  else Icons.Outlined.Circle,
                    contentDescription = null,
                    tint = if (allSetsComplete) MaterialTheme.colorScheme.primary
                           else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.3f),
                    modifier = Modifier.size(20.dp)
                )
                Spacer(Modifier.width(10.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(
                        text = exercise.name,
                        style = MaterialTheme.typography.titleSmall,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        text = "${exercise.sets} sets × ${exercise.repsDisplay}  ·  rest ${exercise.restSeconds}s",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                    )
                }
                // Info button
                IconButton(
                    onClick = { showInfo = true },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        Icons.Default.Info,
                        contentDescription = "Exercise info",
                        tint = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.size(18.dp)
                    )
                }
                // Swap button
                IconButton(
                    onClick = { showSwap = true },
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        Icons.Default.SwapHoriz,
                        contentDescription = "Swap exercise",
                        tint = MaterialTheme.colorScheme.tertiary,
                        modifier = Modifier.size(18.dp)
                    )
                }
                // Expand toggle
                IconButton(
                    onClick = onToggleExpand,
                    modifier = Modifier.size(32.dp)
                ) {
                    Icon(
                        imageVector = if (exerciseState.isExpanded) Icons.Default.ExpandLess
                                      else Icons.Default.ExpandMore,
                        contentDescription = if (exerciseState.isExpanded) "Collapse" else "Expand"
                    )
                }
            }

            // ── Expanded sets ─────────────────────────────────────────────
            AnimatedVisibility(
                visible = exerciseState.isExpanded,
                enter = expandVertically(),
                exit = shrinkVertically()
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                        .padding(horizontal = 14.dp, vertical = 10.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    // Gym note
                    Text(
                        text = exercise.notes,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f),
                        modifier = Modifier.padding(bottom = 4.dp)
                    )

                    // Weight suggestion chip
                    exerciseState.suggestedWeight?.let { weight ->
                        val displayWeight = if (weight == weight.toLong().toFloat())
                            weight.toLong().toString() else weight.toString()
                        SuggestionChip(
                            onClick = {},
                            label = {
                                Text(
                                    "Last session: ${displayWeight} lbs",
                                    style = MaterialTheme.typography.labelSmall
                                )
                            },
                            colors = SuggestionChipDefaults.suggestionChipColors(
                                containerColor = MaterialTheme.colorScheme.primary.copy(alpha = 0.15f)
                            )
                        )
                    } ?: SuggestionChip(
                        onClick = {},
                        label = {
                            Text(
                                "No history — start at RPE 6",
                                style = MaterialTheme.typography.labelSmall
                            )
                        },
                        colors = SuggestionChipDefaults.suggestionChipColors(
                            containerColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.2f)
                        )
                    )

                    HorizontalDivider(color = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f))

                    // Column headers
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            "SET", style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.width(36.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                        if (exercise.trackingType == TrackingType.WEIGHT_REPS) {
                            Text(
                                "WEIGHT (lbs)",
                                style = MaterialTheme.typography.labelSmall,
                                modifier = Modifier.weight(1f),
                                color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                            )
                        } else {
                            Spacer(Modifier.weight(1f))
                        }
                        Text(
                            exercise.repsDisplay.uppercase(),
                            style = MaterialTheme.typography.labelSmall,
                            modifier = Modifier.width(80.dp),
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f)
                        )
                        Spacer(Modifier.width(44.dp))
                    }

                    // Set rows
                    exerciseState.sets.forEachIndexed { idx, setUiState ->
                        SetRow(
                            setNumber = idx + 1,
                            setUiState = setUiState,
                            repsDisplay = exercise.repsDisplay,
                            trackingType = exercise.trackingType,
                            isLast = idx == exerciseState.sets.lastIndex,
                            onWeightChange = { onWeightChange(idx, it) },
                            onComplete = { onCompleteSet(idx) },
                            onUncomplete = { onUncompleteSet(idx) }
                        )
                    }

                    if (!allSetsComplete) {
                        TextButton(
                            onClick = onSkip,
                            modifier = Modifier.align(Alignment.End)
                        ) {
                            Text("Skip Exercise (Mark Done)")
                        }
                    }
                }
            }
        }
    }

    if (showInfo) {
        ExerciseInfoSheet(
            name = exercise.name,
            fullDescription = exercise.fullDescription,
            onDismiss = { showInfo = false }
        )
    }

    if (showSwap) {
        SwapExerciseSheet(
            onSelect = { newExercise ->
                onSwap(newExercise)
                showSwap = false
            },
            onDismiss = { showSwap = false }
        )
    }
}

@Composable
private fun SetRow(
    setNumber: Int,
    setUiState: SetUiState,
    repsDisplay: String,
    trackingType: TrackingType,
    isLast: Boolean,
    onWeightChange: (String) -> Unit,
    onComplete: () -> Unit,
    onUncomplete: () -> Unit
) {
    val focusManager = LocalFocusManager.current
    val completedBg = if (setUiState.completed)
        MaterialTheme.colorScheme.primary.copy(alpha = 0.12f)
    else
        Color.Transparent

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .background(completedBg, shape = MaterialTheme.shapes.small)
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Set number
        Text(
            text = "$setNumber",
            style = MaterialTheme.typography.titleSmall,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.width(36.dp),
            color = if (setUiState.completed) MaterialTheme.colorScheme.primary
                    else MaterialTheme.colorScheme.onSurface
        )

        // Weight input (only for WEIGHT_REPS exercises)
        if (trackingType == TrackingType.WEIGHT_REPS) {
            OutlinedTextField(
                value = setUiState.weightInput,
                onValueChange = { onWeightChange(it) },
                placeholder = { Text("lbs", style = MaterialTheme.typography.bodySmall) },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Decimal,
                    imeAction = if (isLast) ImeAction.Done else ImeAction.Next
                ),
                keyboardActions = KeyboardActions(
                    onNext = { focusManager.moveFocus(FocusDirection.Down) },
                    onDone = { focusManager.clearFocus() }
                ),
                singleLine = true,
                enabled = !setUiState.completed,
                modifier = Modifier
                    .weight(1f)
                    .height(52.dp)
                    .padding(end = 8.dp),
                textStyle = MaterialTheme.typography.bodyMedium,
                colors = OutlinedTextFieldDefaults.colors(
                    disabledTextColor = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    disabledBorderColor = MaterialTheme.colorScheme.outline.copy(alpha = 0.3f)
                )
            )
        } else {
            Spacer(Modifier.weight(1f))
        }

        // Reps display
        Text(
            text = repsDisplay,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(80.dp),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
        )

        // Check / uncheck button
        IconButton(onClick = { if (setUiState.completed) onUncomplete() else onComplete() }) {
            Icon(
                imageVector = if (setUiState.completed) Icons.Filled.CheckCircle
                              else Icons.Outlined.Circle,
                contentDescription = if (setUiState.completed) "Uncheck set" else "Complete set",
                tint = if (setUiState.completed) MaterialTheme.colorScheme.primary
                       else MaterialTheme.colorScheme.onSurface.copy(alpha = 0.4f),
                modifier = Modifier.size(28.dp)
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ExerciseInfoSheet(
    name: String,
    fullDescription: String,
    onDismiss: () -> Unit
) {
    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                name,
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold
            )
            Spacer(Modifier.height(16.dp))

            // Scrollable description with styled section headers
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
                    .verticalScroll(rememberScrollState())
            ) {
                DescriptionContent(fullDescription)
                Spacer(Modifier.height(16.dp))
            }

            Spacer(Modifier.height(12.dp))
            Button(
                onClick = onDismiss,
                modifier = Modifier.fillMaxWidth()
            ) { Text("Got it") }
            Spacer(Modifier.height(16.dp))
        }
    }
}

/**
 * Renders a full-description string with styled section headers.
 * Lines that are entirely uppercase are rendered as section headers
 * in the primary color; everything else is body text.
 */
@Composable
private fun DescriptionContent(description: String) {
    val lines = description.lines()
    Column(verticalArrangement = Arrangement.spacedBy(2.dp)) {
        lines.forEach { line ->
            when {
                line.isBlank() -> {
                    Spacer(Modifier.height(6.dp))
                }
                line == line.uppercase() && line.any { it.isLetter() } -> {
                    // Section header — all-caps line
                    Text(
                        text = line,
                        style = MaterialTheme.typography.labelLarge,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
                else -> {
                    Text(
                        text = line,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.87f)
                    )
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SwapExerciseSheet(
    onSelect: (Exercise) -> Unit,
    onDismiss: () -> Unit
) {
    var query by remember { mutableStateOf("") }
    var selectedGroup by remember { mutableStateOf<MuscleGroup?>(null) }

    val filtered = remember(query, selectedGroup) {
        ExerciseDatabase.all.filter { catalog ->
            val matchesGroup = selectedGroup == null || catalog.muscleGroup == selectedGroup
            val matchesQuery = query.isBlank() ||
                catalog.exercise.name.contains(query, ignoreCase = true)
            matchesGroup && matchesQuery
        }
    }

    ModalBottomSheet(onDismissRequest = onDismiss) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .navigationBarsPadding()
        ) {
            Text(
                "Swap Exercise",
                style = MaterialTheme.typography.titleLarge,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 24.dp, vertical = 4.dp)
            )

            // Search field
            OutlinedTextField(
                value = query,
                onValueChange = { query = it },
                placeholder = { Text("Search exercises…") },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            // Muscle group filter chips
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .horizontalScroll(rememberScrollState())
                    .padding(horizontal = 16.dp, vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                FilterChip(
                    selected = selectedGroup == null,
                    onClick = { selectedGroup = null },
                    label = { Text("All") }
                )
                MuscleGroup.entries.forEach { group ->
                    FilterChip(
                        selected = selectedGroup == group,
                        onClick = { selectedGroup = if (selectedGroup == group) null else group },
                        label = { Text(group.displayName) }
                    )
                }
            }

            HorizontalDivider(modifier = Modifier.padding(vertical = 4.dp))

            // Exercise list
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(max = 480.dp),
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(6.dp)
            ) {
                items(filtered, key = { it.exercise.id }) { catalog ->
                    SwapExerciseItem(catalog = catalog, onSelect = { onSelect(catalog.exercise) })
                }
                if (filtered.isEmpty()) {
                    item {
                        Text(
                            "No exercises found",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.5f),
                            modifier = Modifier.padding(vertical = 24.dp)
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun SwapExerciseItem(
    catalog: CatalogExercise,
    onSelect: () -> Unit
) {
    val ex = catalog.exercise
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onSelect() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 1.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 14.dp, vertical = 10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(modifier = Modifier.weight(1f)) {
                Text(
                    text = ex.name,
                    style = MaterialTheme.typography.bodyMedium,
                    fontWeight = FontWeight.SemiBold
                )
                Text(
                    text = "${ex.sets} sets × ${ex.repsDisplay}  ·  ${catalog.muscleGroup.displayName}",
                    style = MaterialTheme.typography.labelSmall,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f)
                )
            }
            Icon(
                Icons.Default.SwapHoriz,
                contentDescription = "Select",
                tint = MaterialTheme.colorScheme.tertiary,
                modifier = Modifier.size(20.dp)
            )
        }
    }
}

private fun formatTime(totalSeconds: Long): String {
    val hours = totalSeconds / 3600
    val minutes = (totalSeconds % 3600) / 60
    val seconds = totalSeconds % 60
    return if (hours > 0) {
        "%02d:%02d:%02d".format(hours, minutes, seconds)
    } else {
        "%02d:%02d".format(minutes, seconds)
    }
}
