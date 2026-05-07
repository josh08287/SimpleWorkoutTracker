package com.josh.workoutapp.data

enum class MuscleGroup(val displayName: String) {
    CHEST("Chest"),
    BACK("Back"),
    SHOULDERS("Shoulders"),
    ARMS("Arms"),
    LEGS("Legs"),
    CORE("Core"),
    CARDIO("Cardio"),
    MOBILITY("Mobility")
}

data class CatalogExercise(
    val exercise: Exercise,
    val muscleGroup: MuscleGroup
)

object ExerciseDatabase {

    val all: List<CatalogExercise> = listOf(

        // ── CHEST ──────────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_bench_press",
                name = "Bench Press",
                sets = 4, repsDisplay = "8 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Flat barbell. Grip just outside shoulder width.",
                fullDescription = """
EQUIPMENT
Barbell, flat bench

MUSCLES
Primary: Pectoralis major. Secondary: front delts, triceps.

HOW TO PERFORM
1. Eyes under the bar, feet flat on floor.
2. Grip just outside shoulder width.
3. Lower bar to mid-chest under control (2–3 s).
4. Press up and slightly back to lockout.

KEY CUES
Upper back tight into bench. Elbows ~45° from torso. Drive feet into floor.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_incline_db_press",
                name = "Incline Dumbbell Press",
                sets = 3, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bench at 30–45°. Hits upper chest and front delts.",
                fullDescription = """
EQUIPMENT
Dumbbells, adjustable bench (30–45°)

MUSCLES
Primary: Upper pectoralis major. Secondary: front delts, triceps.

HOW TO PERFORM
1. Set bench to 30–45°. Sit with dumbbells on thighs.
2. Kick weights up as you lean back.
3. Lower dumbbells to chest level, elbows at ~60° from torso.
4. Press up and together to full extension.

KEY CUES
Don't let elbows flare wide. Squeeze chest at top. Control the descent.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_cable_fly",
                name = "Cable Fly",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "High or low cable. Great chest isolation and constant tension.",
                fullDescription = """
EQUIPMENT
Cable machine, D-handles

MUSCLES
Primary: Pectoralis major (stretch + squeeze). Secondary: front delts.

HOW TO PERFORM
1. Set cables at chest height (or high for lower chest, low for upper chest).
2. Stand in split stance in center of cables.
3. Bring handles together in a wide arc, slight elbow bend throughout.
4. Control the return — feel the stretch across chest.

KEY CUES
Imagine hugging a barrel. Keep shoulder blades retracted. Don't let elbows drop below shoulder.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_dip",
                name = "Chest Dip",
                sets = 3, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Lean forward to bias chest. Stay upright for more tricep.",
                fullDescription = """
EQUIPMENT
Parallel bars or dip station

MUSCLES
Primary: Pectoralis major (lower). Secondary: triceps, front delts.

HOW TO PERFORM
1. Support yourself on bars with elbows straight.
2. Lean torso forward ~30° to bias chest.
3. Lower until upper arms are parallel to floor.
4. Press back up to full extension.

KEY CUES
Control the descent. Leaning forward = more chest. Elbows slightly flared out. Add weight with dip belt when bodyweight is easy.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_push_up",
                name = "Push-Up",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Classic. Add a band or weight plate for extra resistance.",
                fullDescription = """
EQUIPMENT
None (bodyweight)

MUSCLES
Primary: Pectoralis major. Secondary: triceps, front delts, core.

HOW TO PERFORM
1. Hands just outside shoulder width, body in a straight line.
2. Lower chest to 1 inch from floor under control.
3. Press up to full arm extension.
4. Keep hips in line with shoulders throughout.

KEY CUES
Don't let hips sag or pike. Elbows at ~45° from torso. Elevate feet or add plate on back to progress.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        // ── BACK ───────────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_lat_pulldown",
                name = "Lat Pulldown",
                sets = 4, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Wide overhand grip. Pull to upper chest, not behind neck.",
                fullDescription = """
EQUIPMENT
Cable machine, lat pulldown bar

MUSCLES
Primary: Latissimus dorsi. Secondary: biceps, rear delts, mid-traps.

HOW TO PERFORM
1. Grip bar wider than shoulders with overhand grip.
2. Lean back slightly (~15°) and pull bar to upper chest.
3. Squeeze lats at bottom — elbows driving down and back.
4. Control the bar back up through full range of motion.

KEY CUES
Lead with elbows, not hands. Don't shrug. Keep chest tall. Full stretch at top.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_seated_cable_row",
                name = "Seated Cable Row",
                sets = 3, repsDisplay = "12 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Keep chest up. Row to belly button, not chest.",
                fullDescription = """
EQUIPMENT
Cable machine, close-grip V-bar or neutral handle

MUSCLES
Primary: Mid-trapezius, rhomboids. Secondary: lats, biceps, rear delts.

HOW TO PERFORM
1. Sit tall with knees slightly bent, feet on foot plate.
2. Reach forward for the handle — feel the stretch in your back.
3. Row handle to belly button, driving elbows behind torso.
4. Squeeze shoulder blades together at the end range.

KEY CUES
Don't use momentum — no swinging. Chest stays proud. Pinch shoulder blades at contraction.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_barbell_row",
                name = "Barbell Row",
                sets = 4, repsDisplay = "8 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Hinged at hips, torso 45°. Pull to lower chest.",
                fullDescription = """
EQUIPMENT
Barbell

MUSCLES
Primary: Lats, mid-back. Secondary: biceps, rear delts, spinal erectors.

HOW TO PERFORM
1. Stand with bar over mid-foot. Hinge to ~45°, back flat.
2. Grip bar just outside legs (overhand or underhand).
3. Pull bar to lower chest/belly button — elbows close to body.
4. Lower under control. Don't let bar drop.

KEY CUES
Keep back flat — no rounding. Pull elbows back, not up. Brace core throughout.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_pull_up",
                name = "Pull-Up",
                sets = 3, repsDisplay = "8 reps", restSeconds = 90,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Full dead hang to chin over bar. Use band for assistance if needed.",
                fullDescription = """
EQUIPMENT
Pull-up bar

MUSCLES
Primary: Latissimus dorsi. Secondary: biceps, rear delts, core.

HOW TO PERFORM
1. Hang from bar, overhand grip slightly wider than shoulders.
2. Depress shoulder blades (pack them down).
3. Pull chest toward bar — lead with elbows driving down.
4. Lower to full dead hang.

KEY CUES
No kipping. Full range of motion. Cross feet to limit swing. Add weight with dip belt when 10+ reps feels easy.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_face_pull",
                name = "Face Pull",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "High cable, rope handle. Pull to ears — external rotation.",
                fullDescription = """
EQUIPMENT
Cable machine, rope attachment (set high)

MUSCLES
Primary: Rear delts, external rotators. Secondary: mid-traps, rhomboids.

HOW TO PERFORM
1. Set cable at head height with rope handle.
2. Stand or kneel, grip rope with thumbs up.
3. Pull rope to face — hands separate, elbows flare out at ear level.
4. Pause at peak contraction, return with control.

KEY CUES
Think "show your biceps" at the top. Keep elbows up, not dropping. Light weight, high reps.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_single_arm_row",
                name = "Single-Arm Dumbbell Row",
                sets = 3, repsDisplay = "10 reps each", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Support on bench. Row elbow back and up. Great for lat thickness.",
                fullDescription = """
EQUIPMENT
Dumbbell, flat bench

MUSCLES
Primary: Latissimus dorsi. Secondary: biceps, rear delts, rhomboids.

HOW TO PERFORM
1. Place hand and same-side knee on bench. Back flat, parallel to floor.
2. Hold dumbbell in free hand, let it hang.
3. Row elbow up and back — keep it close to torso.
4. Lower with control to full stretch.

KEY CUES
Don't rotate your torso. Pull with your elbow, not your hand. Full ROM — let lat stretch at bottom.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        // ── SHOULDERS ──────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_ohp",
                name = "Overhead Press",
                sets = 4, repsDisplay = "8 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Barbell or dumbbells. Press overhead, keep core tight.",
                fullDescription = """
EQUIPMENT
Barbell or dumbbells

MUSCLES
Primary: Front and mid delts. Secondary: triceps, upper traps, core.

HOW TO PERFORM
1. Stand or sit. Grip bar just outside shoulder width.
2. Bar starts at collarbone level.
3. Press bar straight up, not forward.
4. Lower under control to starting position.

KEY CUES
Squeeze glutes. Don't arch low back — brace abs. Lock out overhead, shrug slightly at top. Head travels back then forward around bar.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        CatalogExercise(
            Exercise(
                id = "db_lateral_raise",
                name = "Lateral Raise",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Light weight, strict form. Raise to shoulder height.",
                fullDescription = """
EQUIPMENT
Dumbbells or cable machine

MUSCLES
Primary: Medial (side) deltoid. Secondary: supraspinatus.

HOW TO PERFORM
1. Stand with dumbbells at sides, slight bend in elbows.
2. Raise arms out to the side to shoulder height.
3. Lead with elbows, not hands (pinkies slightly high).
4. Lower slowly — 2–3 seconds down.

KEY CUES
Don't shrug at top. Keep a slight lean forward to maximize medial delt. Slow eccentrics matter more than how heavy you go.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        CatalogExercise(
            Exercise(
                id = "db_arnold_press",
                name = "Arnold Press",
                sets = 3, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Rotating press. Hits all three deltoid heads.",
                fullDescription = """
EQUIPMENT
Dumbbells, bench with back support

MUSCLES
Primary: All three deltoid heads. Secondary: triceps.

HOW TO PERFORM
1. Hold dumbbells at shoulder height, palms facing you (like top of a curl).
2. As you press up, rotate palms forward.
3. At the top, palms face forward, arms fully extended.
4. Reverse the rotation as you lower.

KEY CUES
Smooth rotation throughout the range. Don't rush — control the tempo. Full ROM.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        CatalogExercise(
            Exercise(
                id = "db_rear_delt_fly",
                name = "Rear Delt Fly",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bent-over or on incline bench. Critical for shoulder health.",
                fullDescription = """
EQUIPMENT
Dumbbells or cable machine (set low)

MUSCLES
Primary: Posterior deltoid. Secondary: rhomboids, mid-traps.

HOW TO PERFORM
1. Hinge forward 45–90°, chest parallel to floor, dumbbells hanging.
2. Raise dumbbells out to sides with a slight elbow bend.
3. Squeeze rear delts at top — arms in line with shoulders.
4. Lower with control.

KEY CUES
Don't use momentum. Elbows slightly bent, not locked. Imagine showing your armpits. Goes with face pulls for shoulder health.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        // ── ARMS ───────────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_barbell_curl",
                name = "Barbell Curl",
                sets = 3, repsDisplay = "10 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Supinated grip. Keep elbows pinned at sides.",
                fullDescription = """
EQUIPMENT
Barbell or EZ-bar

MUSCLES
Primary: Biceps brachii. Secondary: brachialis, forearms.

HOW TO PERFORM
1. Stand with bar at hip level, underhand grip shoulder-width.
2. Keep elbows pinned — curl bar toward upper chest.
3. Squeeze biceps at top.
4. Lower slowly — 2 seconds down.

KEY CUES
Don't swing. Elbows stay still — they're the hinge. Full extension at bottom. EZ-bar reduces wrist strain.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_hammer_curl",
                name = "Hammer Curl",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Neutral grip. Builds brachialis and forearm thickness.",
                fullDescription = """
EQUIPMENT
Dumbbells

MUSCLES
Primary: Brachialis, brachioradialis. Secondary: biceps.

HOW TO PERFORM
1. Hold dumbbells at sides, palms facing inward (neutral grip).
2. Curl both (or alternating) straight up — thumbs toward ceiling throughout.
3. Don't rotate wrist.
4. Lower under control.

KEY CUES
Keep elbows at sides. Neutral grip throughout — no supination. Great for arm thickness and grip strength.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_tricep_pushdown",
                name = "Tricep Pushdown",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "High cable. Use rope or straight bar. Elbows stay at sides.",
                fullDescription = """
EQUIPMENT
Cable machine, rope or straight bar attachment (set high)

MUSCLES
Primary: Triceps brachii (all three heads). Secondary: anconeus.

HOW TO PERFORM
1. Stand close to cable machine. Grip rope/bar at chest height.
2. Pin elbows at sides.
3. Push handle down to full extension — triceps fully contracted.
4. Let hands come back up slowly to 90°.

KEY CUES
Elbows don't move — only forearms. With rope: flare hands apart at bottom for better contraction. Lean forward slightly.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_skull_crusher",
                name = "Skull Crusher",
                sets = 3, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Barbell or EZ-bar lying down. Targets long head of triceps.",
                fullDescription = """
EQUIPMENT
EZ-bar or barbell, flat bench

MUSCLES
Primary: Triceps brachii (long head emphasis). Secondary: anconeus.

HOW TO PERFORM
1. Lie on bench. Hold EZ-bar over chest, arms extended.
2. Hinge only at elbows — lower bar toward forehead (or behind head for long head).
3. Elbows stay in line with shoulders — don't flare out.
4. Press back to full extension.

KEY CUES
Upper arms stay still. Go slow — this is a stretch movement for the tricep. Light weight before adding load.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_overhead_tricep_ext",
                name = "Overhead Tricep Extension",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Dumbbell or rope. Hits long head in a stretch position.",
                fullDescription = """
EQUIPMENT
Dumbbell (two hands) or cable machine, rope attachment (set low)

MUSCLES
Primary: Triceps brachii (long head). Secondary: anconeus.

HOW TO PERFORM
1. Hold dumbbell overhead with both hands, or grip rope behind head.
2. Elbows point toward ceiling, upper arms stay still.
3. Lower weight behind head until elbows at 90° or less.
4. Extend fully, squeeze at top.

KEY CUES
Keep elbows close together — don't let them flare. The overhead stretch maximizes long head involvement.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        // ── LEGS ───────────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_back_squat",
                name = "Back Squat",
                sets = 4, repsDisplay = "8 reps", restSeconds = 120,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bar on upper traps. Squat to parallel or below.",
                fullDescription = """
EQUIPMENT
Barbell, squat rack

MUSCLES
Primary: Quadriceps, glutes. Secondary: hamstrings, spinal erectors, core.

HOW TO PERFORM
1. Bar sits on upper traps (high bar) or mid-traps (low bar).
2. Step back, feet shoulder-width, toes slightly out.
3. Squat down — hips and knees simultaneously, chest up, knees track toes.
4. Drive through full foot on the way up.

KEY CUES
Brace hard before descent. Knees don't cave in. "Spread the floor" with feet. Drive hips through at lockout.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_rdl",
                name = "Romanian Deadlift",
                sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Hinge movement. Hamstrings and glutes. Keep bar close.",
                fullDescription = """
EQUIPMENT
Barbell or dumbbells

MUSCLES
Primary: Hamstrings, glutes. Secondary: spinal erectors, grip.

HOW TO PERFORM
1. Stand with bar at hip level, overhand grip shoulder-width.
2. Hinge at hips — push them back as bar slides down legs.
3. Lower until you feel hamstring stretch (mid-shin for most).
4. Drive hips forward to return — squeeze glutes at top.

KEY CUES
Bar stays in contact with legs throughout. Soft knee bend — this is a hip hinge, not a squat. Back stays neutral (don't round).
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_leg_press",
                name = "Leg Press",
                sets = 4, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Feet shoulder-width. Lower to 90°. Don't lock out fully.",
                fullDescription = """
EQUIPMENT
Leg press machine

MUSCLES
Primary: Quadriceps, glutes. Secondary: hamstrings.

HOW TO PERFORM
1. Sit in machine, feet shoulder-width at middle of platform.
2. Release safety handles.
3. Lower platform until knees at 90° — back stays on pad.
4. Press through heels to full extension (don't lock out knees).

KEY CUES
Higher feet = more glutes. Lower feet = more quads. Never let lower back peel off pad. Re-rack safeties before unloading.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_bulgarian_split_squat",
                name = "Bulgarian Split Squat",
                sets = 3, repsDisplay = "10 reps each", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Rear foot elevated. Single-leg quad and glute burner.",
                fullDescription = """
EQUIPMENT
Bench or box, dumbbells or barbell

MUSCLES
Primary: Quads, glutes. Secondary: hamstrings, hip flexors, core.

HOW TO PERFORM
1. Stand 2 feet in front of bench. Place rear foot on bench, laces down.
2. Lower front knee toward floor — knee tracks over foot.
3. Back knee drops toward (not touching) floor.
4. Drive through front heel to stand.

KEY CUES
Front shin stays relatively vertical. Torso stays upright. Hip flexor stretch in rear leg is normal. Use dumbbells for balance before adding barbell.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_goblet_squat",
                name = "Goblet Squat",
                sets = 3, repsDisplay = "12 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Dumbbell or kettlebell at chest. Great form teacher.",
                fullDescription = """
EQUIPMENT
Dumbbell or kettlebell

MUSCLES
Primary: Quads, glutes. Secondary: core, upper back.

HOW TO PERFORM
1. Hold weight at chest (goblet position), feet shoulder-width, toes out.
2. Squat deep — elbows push knees out at bottom.
3. Keep chest tall, heels on floor.
4. Drive to standing, squeezing glutes at top.

KEY CUES
Elbows pushing knees out cues correct knee tracking. Great mobility drill. Can go deep — depth is the point here.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_hip_thrust",
                name = "Hip Thrust",
                sets = 3, repsDisplay = "12 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Upper back on bench. Drive hips up. Best glute isolation.",
                fullDescription = """
EQUIPMENT
Barbell, flat bench, pad (for comfort)

MUSCLES
Primary: Glutes. Secondary: hamstrings, core.

HOW TO PERFORM
1. Sit on floor with upper back against bench edge, bar on hips.
2. Feet flat, shoulder-width, knees at ~90° when hips are high.
3. Drive hips up until body forms a straight line from shoulders to knees.
4. Squeeze glutes hard at top, hold 1 second.

KEY CUES
Don't hyperextend lower back — the glutes do the work. Chin tucks — look straight, not up. Feet placement affects feel.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_leg_curl",
                name = "Leg Curl",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Lying or seated machine. Isolates hamstrings.",
                fullDescription = """
EQUIPMENT
Leg curl machine (lying or seated)

MUSCLES
Primary: Hamstrings (biceps femoris, semimembranosus, semitendinosus).

HOW TO PERFORM
1. Lie face down or sit depending on machine.
2. Pad rests just above ankles.
3. Curl heels toward glutes through full range.
4. Lower slowly — 2–3 seconds.

KEY CUES
Keep hips pressed into pad (lying) to avoid low back involvement. Full extension between reps. Slow eccentric for max hypertrophy.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        // ── CORE ───────────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_plank",
                name = "Plank",
                sets = 3, repsDisplay = "45 sec", restSeconds = 60,
                trackingType = TrackingType.TIME_BASED,
                notes = "Forearms or hands. Rigid body from head to heels.",
                fullDescription = """
EQUIPMENT
None

MUSCLES
Primary: Transverse abdominis, rectus abdominis. Secondary: glutes, shoulders, lats.

HOW TO PERFORM
1. Forearms (or hands) on floor, body in a straight line.
2. Engage abs — imagine bracing for a punch.
3. Squeeze glutes, don't let hips sag or pike.
4. Hold for the prescribed time. Breathe.

KEY CUES
Head neutral — gaze at floor. If hips drop, stop and rest. Progress by adding time, not allowing form to break.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_dead_bug",
                name = "Dead Bug",
                sets = 3, repsDisplay = "10 reps each side", restSeconds = 60,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Low back pressed to floor. Opposite arm and leg extend.",
                fullDescription = """
EQUIPMENT
None

MUSCLES
Primary: Transverse abdominis. Secondary: hip flexors, spinal stabilizers.

HOW TO PERFORM
1. Lie on back, arms straight up toward ceiling, hips and knees at 90°.
2. Press low back into floor — maintain this throughout.
3. Extend opposite arm and leg toward floor simultaneously.
4. Return to start. Alternate sides.

KEY CUES
Low back must stay pressed down — if it lifts, your range is too big. Move slowly and deliberately. Breathe out on extension.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_pallof_press",
                name = "Pallof Press",
                sets = 3, repsDisplay = "12 reps each side", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Anti-rotation cable exercise. Resist twisting — don't let cable pull you.",
                fullDescription = """
EQUIPMENT
Cable machine, D-handle (set at chest height)

MUSCLES
Primary: Obliques, transverse abdominis. Secondary: glutes, lats.

HOW TO PERFORM
1. Stand sideways to cable. Grip handle at chest, elbows in.
2. Step away until there's tension. Stand in athletic stance.
3. Press handle straight out in front of chest — hold 1–2 sec.
4. Return to chest. Don't rotate.

KEY CUES
Fight the rotation — that's the whole point. Feet shoulder-width, knees slightly bent. Keep hips square throughout.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_cable_woodchop",
                name = "Cable Wood Chop",
                sets = 3, repsDisplay = "12 reps each side", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "High to low or low to high. Rotational power — great for golf.",
                fullDescription = """
EQUIPMENT
Cable machine, D-handle or rope

MUSCLES
Primary: Obliques. Secondary: glutes, shoulders, lats.

HOW TO PERFORM
1. Set cable high (high-to-low chop) or low (low-to-high).
2. Stand sideways, grip handle with both hands.
3. Rotate through torso — arms are guides, not primary movers.
4. Hips rotate, core drives. Return under control.

KEY CUES
Rotate from the hips and thoracic spine — don't just move arms. This trains the exact pattern used in a golf swing. Weight through heels.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_russian_twist",
                name = "Russian Twist",
                sets = 3, repsDisplay = "20 reps", restSeconds = 60,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Feet off floor. Hold weight for added resistance.",
                fullDescription = """
EQUIPMENT
None or medicine ball/dumbbell

MUSCLES
Primary: Obliques. Secondary: hip flexors, rectus abdominis.

HOW TO PERFORM
1. Sit with knees bent, feet off floor (or on floor for easier).
2. Lean back slightly — body at ~45°.
3. Rotate torso side to side, touching floor or weight each side.
4. Keep breathing — don't hold breath.

KEY CUES
Rotate from thoracic spine, not just arms. Add a medicine ball to increase load. Feet elevated = harder.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_hanging_knee_raise",
                name = "Hanging Knee Raise",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Hang from bar. Bring knees to chest. Progress to straight legs.",
                fullDescription = """
EQUIPMENT
Pull-up bar

MUSCLES
Primary: Hip flexors, lower rectus abdominis. Secondary: obliques, forearms.

HOW TO PERFORM
1. Dead hang from pull-up bar.
2. Brace abs — bring knees up to chest.
3. Lower with control — don't swing.
4. Progress to straight-leg raises for more challenge.

KEY CUES
Control the swing. Tuck pelvis at the top for more ab involvement. Don't use momentum.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        // ── CARDIO ─────────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_row_machine",
                name = "Rowing Machine",
                sets = 1, repsDisplay = "10 min", restSeconds = 0,
                trackingType = TrackingType.TIME_BASED,
                notes = "Full-body cardio. Great warm-up or conditioning finisher.",
                fullDescription = """
EQUIPMENT
Rowing ergometer (Concept 2 or similar)

MUSCLES
Primary: Back, legs, core. Secondary: arms, shoulders.

HOW TO PERFORM
1. Feet strapped in, shins vertical, grip handle.
2. Drive with legs first, then lean back, then pull handle to lower chest.
3. Return: arms extend first, then torso forward, then knees bend.

KEY CUES
Legs → back → arms (drive). Arms → back → legs (return). Don't rush the recovery. Keep damper around 4–6 for most people.
                """.trimIndent()
            ),
            MuscleGroup.CARDIO
        ),

        CatalogExercise(
            Exercise(
                id = "db_jump_rope",
                name = "Jump Rope",
                sets = 3, repsDisplay = "2 min", restSeconds = 60,
                trackingType = TrackingType.TIME_BASED,
                notes = "Steady pace or intervals. Low-impact on joints compared to running.",
                fullDescription = """
EQUIPMENT
Jump rope

MUSCLES
Primary: Calves, coordination. Secondary: shoulders, core.

HOW TO PERFORM
1. Hold handles at hip level, rope behind you.
2. Swing rope overhead and jump with both feet.
3. Stay on the balls of your feet — minimal ground contact.
4. Keep elbows close to body, wrists do the work.

KEY CUES
Small, quick jumps. Focus on rhythm. Start at 30-sec on / 30-sec off if beginner.
                """.trimIndent()
            ),
            MuscleGroup.CARDIO
        ),

        CatalogExercise(
            Exercise(
                id = "db_sled_push",
                name = "Sled Push",
                sets = 4, repsDisplay = "20 yards", restSeconds = 90,
                trackingType = TrackingType.TIME_BASED,
                notes = "Load the sled. Drive hard. Great for lower-body power and conditioning.",
                fullDescription = """
EQUIPMENT
Prowler sled, open space

MUSCLES
Primary: Quads, glutes. Secondary: calves, core, shoulders.

HOW TO PERFORM
1. Grip handles at hip level or chest level.
2. Lean forward aggressively — low angle body position.
3. Drive hard through the ground — short, powerful steps.
4. Keep hips low throughout.

KEY CUES
More forward lean = less weight needed. Stay low. Push hard on every step. Great finisher or conditioning work.
                """.trimIndent()
            ),
            MuscleGroup.CARDIO
        ),

        // ── MOBILITY ───────────────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_thoracic_rotation",
                name = "Thoracic Rotation (Seated)",
                sets = 2, repsDisplay = "10 reps each side", restSeconds = 30,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Sit cross-legged. Rotate thoracic spine. Key for golf swing.",
                fullDescription = """
EQUIPMENT
None

MUSCLES
Primary: Thoracic spine rotators. Secondary: obliques.

HOW TO PERFORM
1. Sit cross-legged or in a chair, hands behind head.
2. Keep hips square — rotate only the thoracic spine.
3. Rotate to one side as far as comfortable.
4. Return and repeat to other side.

KEY CUES
Hips must stay still — this isolates the thoracic spine. If hips rotate, you're substituting. This is critical for golf shoulder turn.
                """.trimIndent()
            ),
            MuscleGroup.MOBILITY
        ),

        CatalogExercise(
            Exercise(
                id = "db_hip_flexor_stretch",
                name = "Hip Flexor Stretch (Kneeling)",
                sets = 2, repsDisplay = "45 sec each side", restSeconds = 30,
                trackingType = TrackingType.TIME_BASED,
                notes = "Rear knee on floor. Drive hips forward. Essential for golfers.",
                fullDescription = """
EQUIPMENT
Mat or soft surface

MUSCLES
Primary: Iliopsoas, rectus femoris. Secondary: quads.

HOW TO PERFORM
1. Kneel with one knee on floor, other foot forward (lunge position).
2. Keep torso upright.
3. Gently drive hips forward until you feel a stretch in the rear hip.
4. Hold. Don't let low back arch excessively.

KEY CUES
Posterior pelvic tilt (tuck tailbone) to increase the hip flexor stretch. Can add slight lateral reach away from rear leg for deeper stretch.
                """.trimIndent()
            ),
            MuscleGroup.MOBILITY
        ),

        CatalogExercise(
            Exercise(
                id = "db_worlds_greatest_stretch",
                name = "World's Greatest Stretch",
                sets = 2, repsDisplay = "5 reps each side", restSeconds = 30,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Multi-joint mobility. Hips, thoracic spine, hamstrings all in one.",
                fullDescription = """
EQUIPMENT
None

MUSCLES
Primary: Hip flexors, thoracic spine, hamstrings. Secondary: glutes, adductors.

HOW TO PERFORM
1. Start in a deep lunge — front foot flat, rear knee on floor.
2. Place same-side hand inside foot, other hand behind head.
3. Rotate open toward the front leg — elbow toward sky.
4. Return, switch legs.

KEY CUES
Keep front knee tracking over foot. Rotate from the thoracic spine, not just the arm. Breathe out on rotation. Great daily habit for golfers.
                """.trimIndent()
            ),
            MuscleGroup.MOBILITY
        ),

        CatalogExercise(
            Exercise(
                id = "db_band_pull_apart",
                name = "Band Pull-Apart",
                sets = 3, repsDisplay = "20 reps", restSeconds = 30,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Light resistance band. Shoulder health and rear delt activation.",
                fullDescription = """
EQUIPMENT
Light resistance band

MUSCLES
Primary: Rear delts, rhomboids, mid-traps. Secondary: external rotators.

HOW TO PERFORM
1. Hold band at shoulder width, arms extended in front at shoulder height.
2. Pull band apart — both hands move out to the sides simultaneously.
3. Bring band to chest level as it fully stretches.
4. Return to start with control.

KEY CUES
Keep arms straight (slight elbow bend). Squeeze shoulder blades at end range. Don't let shoulders shrug. Great daily warm-up for shoulder health.
                """.trimIndent()
            ),
            MuscleGroup.MOBILITY
        ),

        // ── CHEST (additional) ─────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_db_bench_press",
                name = "Dumbbell Bench Press",
                sets = 4, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Greater range of motion than barbell. Each side works independently.",
                fullDescription = """
EQUIPMENT
Dumbbells, flat bench

MUSCLES
Primary: Pectoralis major. Secondary: front delts, triceps.

HOW TO PERFORM
1. Sit on bench edge with dumbbells on thighs. Kick them up as you lie back.
2. Dumbbells at chest level, palms forward, elbows at ~45° from torso.
3. Press up until arms are fully extended — dumbbells nearly touch at top.
4. Lower under control, feel the chest stretch at the bottom.

KEY CUES
Neutral grip (palms facing each other) is easier on shoulders. Let the dumbbells travel slightly toward each other at the top. Control the descent.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_decline_bench_press",
                name = "Decline Bench Press",
                sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Feet anchored, head lower than hips. Hits lower chest.",
                fullDescription = """
EQUIPMENT
Barbell or dumbbells, decline bench

MUSCLES
Primary: Lower pectoralis major. Secondary: triceps, front delts.

HOW TO PERFORM
1. Anchor feet and lie back on the decline bench.
2. Grip barbell just outside shoulder width.
3. Lower bar to lower chest (below nipple line).
4. Press back to full extension.

KEY CUES
The decline angle reduces shoulder stress for some people. Bar path is more vertical than flat bench. Spot or use a spotter — getting out from under is harder.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_pec_deck",
                name = "Pec Deck Machine",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Machine fly. Great isolation — no balance required.",
                fullDescription = """
EQUIPMENT
Pec deck / chest fly machine

MUSCLES
Primary: Pectoralis major (inner). Secondary: front delts.

HOW TO PERFORM
1. Adjust seat so handles are at chest height.
2. Place forearms on pads (or grip handles), elbows slightly bent.
3. Bring arms together in a wide arc — squeeze chest at center.
4. Return with control — feel the stretch but don't let weight slam.

KEY CUES
Don't let your elbows go behind your torso at the stretch — shoulder risk. Squeeze and hold 1 second at peak contraction. Great finisher after pressing movements.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        // ── BACK (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_deadlift",
                name = "Deadlift",
                sets = 4, repsDisplay = "5 reps", restSeconds = 180,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "The king of lifts. Full-body compound. Pull from the floor.",
                fullDescription = """
EQUIPMENT
Barbell, plates

MUSCLES
Primary: Hamstrings, glutes, spinal erectors. Secondary: traps, lats, core, grip.

HOW TO PERFORM
1. Bar over mid-foot. Hinge to grip — hands just outside legs (overhand or mixed grip).
2. Shins touch bar. Back flat, chest up, lats engaged ("protect your armpits").
3. Push the floor away — legs drive first, then hips come through.
4. At lockout: hips and knees straight, shoulders back. Lower with control.

KEY CUES
Don't jerk the bar — build tension before the pull. Bar stays in contact with legs the whole way. Hinge, don't squat. Brace your core like a pressurized cylinder.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_tbar_row",
                name = "T-Bar Row",
                sets = 4, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Landmine or T-bar machine. Heavy mid-back compound.",
                fullDescription = """
EQUIPMENT
T-bar row machine or landmine attachment with V-handle

MUSCLES
Primary: Mid-back (rhomboids, mid-traps). Secondary: lats, biceps, rear delts.

HOW TO PERFORM
1. Straddle the bar, hinge to ~45°, chest against pad (if machine) or free-standing.
2. Grip handles with both hands.
3. Row to lower chest — drive elbows back and up.
4. Squeeze shoulder blades together at the top. Lower with control.

KEY CUES
Keep chest up and back flat. Don't let the weight pull you into rounding. Elbows stay close to torso. Great for building mid-back thickness.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_straight_arm_pulldown",
                name = "Straight-Arm Cable Pulldown",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "High cable, straight bar or rope. Pure lat isolation.",
                fullDescription = """
EQUIPMENT
Cable machine, straight bar or rope (set high)

MUSCLES
Primary: Latissimus dorsi. Secondary: teres major, long head of triceps.

HOW TO PERFORM
1. Stand facing cable with bar at eye level. Grip bar wider than shoulders.
2. Slight forward lean, arms nearly straight throughout (soft elbow bend).
3. Pull bar down to hips in a wide arc — keep arms straight.
4. Hold at the bottom, squeeze lats, return slowly.

KEY CUES
This is a lat isolation — don't bend the elbows. Feel the lats stretching at the top. Great pre-exhaust before rows or as a lat finisher.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_chest_supported_row",
                name = "Chest-Supported Row",
                sets = 3, repsDisplay = "12 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Incline bench, dumbbells. Chest support removes low back from the equation.",
                fullDescription = """
EQUIPMENT
Incline bench (set to 30–45°), dumbbells

MUSCLES
Primary: Mid-traps, rhomboids. Secondary: rear delts, biceps.

HOW TO PERFORM
1. Set incline bench to ~45°. Lie chest-down, dumbbells hanging below.
2. Row dumbbells up — drive elbows back and out (wide row = more traps, close = more lats).
3. Squeeze shoulder blades together at the top.
4. Lower fully — let lats stretch.

KEY CUES
Because you're supported, there's no cheating with momentum. Focus purely on the back contraction. Go heavier than you think — it's very stable.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        // ── SHOULDERS (additional) ─────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_upright_row",
                name = "Upright Row",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Barbell or dumbbells. Hits side delts and traps. Use a shoulder-width grip.",
                fullDescription = """
EQUIPMENT
Barbell, dumbbells, or cable machine

MUSCLES
Primary: Medial delts, upper traps. Secondary: biceps, forearms.

HOW TO PERFORM
1. Hold bar with an overhand grip, shoulder-width (not narrower).
2. Pull bar straight up along torso — elbows lead and rise to ear level.
3. Bar reaches upper chest / chin level.
4. Lower with control.

KEY CUES
Shoulder-width grip reduces impingement risk. Elbows stay higher than hands. If you feel shoulder pinching, widen your grip or switch to dumbbells/cables.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        CatalogExercise(
            Exercise(
                id = "db_cable_lateral_raise",
                name = "Cable Lateral Raise",
                sets = 3, repsDisplay = "15 reps each side", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Single-arm cable. Constant tension through full ROM — better than dumbbells.",
                fullDescription = """
EQUIPMENT
Cable machine, D-handle (set low)

MUSCLES
Primary: Medial deltoid. Secondary: supraspinatus.

HOW TO PERFORM
1. Stand sideways to cable machine. Grip handle with far hand (cable crosses in front).
2. Raise arm out to the side to shoulder height, slight elbow bend.
3. Lead with elbow — pinky slightly higher than thumb.
4. Lower slowly — the cable keeps tension the whole way down.

KEY CUES
The cable keeps tension at the bottom (unlike dumbbells). This is why it's superior for side delt development. Don't shrug. Lean slightly away for a better stretch.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        CatalogExercise(
            Exercise(
                id = "db_machine_shoulder_press",
                name = "Machine Shoulder Press",
                sets = 3, repsDisplay = "12 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Plate-loaded or selectorized. Stable pressing — great for beginners or high volume.",
                fullDescription = """
EQUIPMENT
Shoulder press machine

MUSCLES
Primary: Front and medial delts. Secondary: triceps, upper traps.

HOW TO PERFORM
1. Adjust seat so handles are at shoulder level.
2. Press handles straight up to full extension.
3. Lower with control — don't bounce at the bottom.
4. Keep back flat against the pad.

KEY CUES
Machine removes stabilization demand — useful for high-rep sets when fatigued or when recovering from shoulder issues. Go through full ROM.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        // ── ARMS (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_preacher_curl",
                name = "Preacher Curl",
                sets = 3, repsDisplay = "10 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "EZ-bar or dumbbell on preacher bench. Eliminates cheating — pure bicep.",
                fullDescription = """
EQUIPMENT
Preacher bench, EZ-bar or dumbbell

MUSCLES
Primary: Biceps brachii (short head emphasis). Secondary: brachialis.

HOW TO PERFORM
1. Rest upper arms flat on the preacher pad — chest against the top.
2. Curl bar up toward your face — full contraction at top.
3. Lower slowly to full extension — don't let arms hang at 90°, go all the way down.
4. Pause at the stretch.

KEY CUES
The pad prevents body English — you can't swing. Don't lock out aggressively at the bottom. Full ROM is critical — the stretch position is where gains happen.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_concentration_curl",
                name = "Concentration Curl",
                sets = 3, repsDisplay = "12 reps each side", restSeconds = 45,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Seated, elbow braced on inner thigh. Peak contraction focus.",
                fullDescription = """
EQUIPMENT
Dumbbell, bench

MUSCLES
Primary: Biceps brachii (peak). Secondary: brachialis.

HOW TO PERFORM
1. Sit on bench, lean forward. Rest working arm's elbow on inner thigh.
2. Curl dumbbell up — fully supinate wrist at the top (pinky rotates toward ceiling).
3. Squeeze hard at peak contraction.
4. Lower with control to full extension.

KEY CUES
Elbow stays pinned on thigh throughout. The supination (rotation) at the top is key for bicep peak. No swinging — all isolation.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_cable_curl",
                name = "Cable Curl",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Low cable, straight bar or EZ-bar. Constant tension the whole rep.",
                fullDescription = """
EQUIPMENT
Cable machine, straight bar or EZ-bar attachment (set low)

MUSCLES
Primary: Biceps brachii. Secondary: brachialis, forearms.

HOW TO PERFORM
1. Stand close to cable, grip bar with underhand grip, elbows at sides.
2. Curl bar toward upper chest — keep elbows pinned.
3. Squeeze at top, then lower all the way back down.
4. The cable keeps tension even at the bottom — don't rush.

KEY CUES
Unlike dumbbells, cables maintain tension in the fully stretched position. Step back from the cable slightly to keep tension at the bottom. Elbows stay at your sides.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_close_grip_bench",
                name = "Close-Grip Bench Press",
                sets = 3, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Barbell, hands shoulder-width. Shifts emphasis from chest to triceps.",
                fullDescription = """
EQUIPMENT
Barbell, flat bench

MUSCLES
Primary: Triceps brachii. Secondary: pectoralis major, front delts.

HOW TO PERFORM
1. Grip bar shoulder-width (NOT ultra-narrow — that strains wrists).
2. Lower bar to lower chest — elbows tuck close to body.
3. Press up and slightly forward to lockout.
4. Elbows stay in throughout — don't let them flare.

KEY CUES
Shoulder-width grip (not hands touching) is the sweet spot for wrist comfort and tricep activation. Tuck elbows to 45°. Great heavy tricep compound movement.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_tricep_kickback",
                name = "Tricep Kickback",
                sets = 3, repsDisplay = "15 reps each side", restSeconds = 45,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Dumbbell or cable. Hinge forward. Extend arm fully behind you.",
                fullDescription = """
EQUIPMENT
Dumbbell or cable machine (low pulley)

MUSCLES
Primary: Triceps brachii (lateral head). Secondary: anconeus.

HOW TO PERFORM
1. Hinge forward ~45°, upper arm pinned parallel to floor alongside torso.
2. Extend forearm back to full lockout — tricep fully contracted.
3. Hold 1 second. Return with control — don't let elbow drop.
4. Upper arm stays still the entire time.

KEY CUES
Light weight, strict form — the range of motion is small. Upper arm parallel to floor is the key setup cue. Great for tricep detail and definition work.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        // ── LEGS (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_front_squat",
                name = "Front Squat",
                sets = 4, repsDisplay = "6 reps", restSeconds = 120,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bar on front delts. More upright torso — heavy quad emphasis.",
                fullDescription = """
EQUIPMENT
Barbell, squat rack

MUSCLES
Primary: Quadriceps. Secondary: glutes, core, upper back.

HOW TO PERFORM
1. Bar rests on front delts (clean grip or cross-arm grip). Elbows stay HIGH.
2. Squat deep — torso stays very upright due to bar position.
3. Knees track over toes, drive out of the hole.
4. Stand to full lockout.

KEY CUES
Elbows dropping = bar rolls forward = failed lift. Upper back must be rigid. More quad than back squat. If wrists are tight, use cross-arm grip. Fantastic for athletic development.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_sumo_deadlift",
                name = "Sumo Deadlift",
                sets = 4, repsDisplay = "6 reps", restSeconds = 120,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Wide stance, toes out. More hip and inner thigh than conventional.",
                fullDescription = """
EQUIPMENT
Barbell, plates

MUSCLES
Primary: Glutes, hip adductors, quads. Secondary: hamstrings, spinal erectors.

HOW TO PERFORM
1. Wide stance (1.5–2× shoulder width), toes pointed 30–45° out.
2. Grip bar inside legs, arms straight down.
3. Hips drop low, chest up, shins nearly vertical.
4. Drive hips through — push the floor apart with your feet.

KEY CUES
"Push the floor apart" activates the adductors. Hips and bar rise together. Great alternative if conventional hurts your back. Shorter range of motion = good for heavy loads.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_leg_extension",
                name = "Leg Extension",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Machine. Pure quad isolation. Use as a finisher or warm-up.",
                fullDescription = """
EQUIPMENT
Leg extension machine

MUSCLES
Primary: Quadriceps (all four heads). Secondary: none.

HOW TO PERFORM
1. Adjust pad to rest just above ankles. Back flat against seat.
2. Extend legs to full lockout — squeeze quads hard at the top.
3. Hold 1 second at peak.
4. Lower slowly — 2–3 seconds — don't let weight drop.

KEY CUES
Slow eccentric for maximum quad stimulus. Full extension and full flexion each rep. Don't use too much weight — it's an isolation exercise. Can be done unilaterally.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_standing_calf_raise",
                name = "Standing Calf Raise",
                sets = 4, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "On a step for full ROM. Slow and controlled — calves respond to time under tension.",
                fullDescription = """
EQUIPMENT
Calf raise machine or step/platform + dumbbells

MUSCLES
Primary: Gastrocnemius. Secondary: soleus.

HOW TO PERFORM
1. Stand with balls of feet on the edge of a step, heels hanging off.
2. Lower heels as far as comfortable — deep stretch.
3. Rise as high as possible onto tiptoes.
4. Hold peak contraction 1 second. Lower slowly.

KEY CUES
Full ROM every rep — heel below platform at the bottom. Calves need high reps and slow tempo. Going fast with heavy weight is less effective than slow, full-range reps.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_walking_lunge",
                name = "Walking Lunge",
                sets = 3, repsDisplay = "12 reps each leg", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bodyweight or dumbbells. Builds quads, glutes, and single-leg stability.",
                fullDescription = """
EQUIPMENT
Bodyweight or dumbbells

MUSCLES
Primary: Quads, glutes. Secondary: hamstrings, core, hip flexors.

HOW TO PERFORM
1. Stand tall with dumbbells at sides.
2. Step forward — lower rear knee toward floor (don't touch).
3. Front shin stays vertical, front knee tracks over foot.
4. Drive through front heel — bring rear foot forward to the next step.

KEY CUES
Keep torso upright — don't lean forward. Long stride = more glutes. Short stride = more quads. Great for building unilateral leg strength and coordination.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_step_up",
                name = "Step-Up",
                sets = 3, repsDisplay = "12 reps each leg", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Box or bench. Dumbbells. Single-leg compound for quads and glutes.",
                fullDescription = """
EQUIPMENT
Box or bench (knee height), dumbbells

MUSCLES
Primary: Quads, glutes. Secondary: hamstrings, core.

HOW TO PERFORM
1. Stand facing box with dumbbells at sides.
2. Step one foot onto box — drive through that heel to step up fully.
3. Stand tall at the top — don't push off the trailing leg.
4. Step back down with control. Repeat same side or alternate.

KEY CUES
The working leg does all the effort — trailing leg just balances. Higher box = more hip involvement. Control the descent. Great functional strength builder.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        // ── CORE (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_ab_wheel_rollout",
                name = "Ab Wheel Rollout",
                sets = 3, repsDisplay = "10 reps", restSeconds = 75,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "On knees or toes. One of the most effective core exercises.",
                fullDescription = """
EQUIPMENT
Ab wheel (or barbell with plates)

MUSCLES
Primary: Rectus abdominis, transverse abdominis. Secondary: lats, shoulders, hip flexors.

HOW TO PERFORM
1. Kneel on a mat, hands on ab wheel directly under shoulders.
2. Roll forward slowly — hips extend, body goes parallel to floor (or as far as control allows).
3. Pull back using abs and lats — don't collapse.
4. Return to start without resting.

KEY CUES
Start with partial range — going too far too soon causes back injury. Keep core braced the entire time. "Hollow body" position. Progress to standing rollouts once kneeling is mastered.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_cable_crunch",
                name = "Cable Crunch",
                sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "High cable, rope. Kneel and crunch down — weighted ab work.",
                fullDescription = """
EQUIPMENT
Cable machine, rope attachment (set high)

MUSCLES
Primary: Rectus abdominis. Secondary: obliques.

HOW TO PERFORM
1. Kneel facing cable machine with rope behind your head.
2. Hips stay still — crunch torso down, rounding your spine.
3. Aim to bring elbows toward knees.
4. Hold contraction, return slowly — don't let hips go back and forth.

KEY CUES
Motion comes from the abs, not the hips. Hips stay fixed — the torso crunches. This is one of the few ways to load abs with real weight. Great for building ab thickness.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_bicycle_crunch",
                name = "Bicycle Crunch",
                sets = 3, repsDisplay = "20 reps", restSeconds = 45,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Hands behind head. Opposite elbow to knee. Targets obliques.",
                fullDescription = """
EQUIPMENT
None

MUSCLES
Primary: Obliques, rectus abdominis. Secondary: hip flexors.

HOW TO PERFORM
1. Lie on back, hands lightly behind head (don't pull neck), legs lifted.
2. Crunch right elbow toward left knee while extending right leg.
3. Switch: left elbow toward right knee, extend left leg.
4. Slow and controlled — feel the oblique contract each time.

KEY CUES
Don't pull your neck — hands just support your head. The rotation happens at the thoracic spine, not just the arms. Slow down — most people do these too fast to feel anything.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        // ── CARDIO (additional) ────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_treadmill",
                name = "Treadmill Run",
                sets = 1, repsDisplay = "20 min", restSeconds = 0,
                trackingType = TrackingType.TIME_BASED,
                notes = "Steady-state or intervals. Adjust incline to increase difficulty without speed.",
                fullDescription = """
EQUIPMENT
Treadmill

MUSCLES
Primary: Quads, hamstrings, calves, glutes. Secondary: core.

HOW TO PERFORM
1. Start with a 2-min walk warm-up.
2. Increase to your target pace.
3. For intervals: alternate 1 min hard / 1 min easy.
4. Cool down with a 2-min walk at the end.

KEY CUES
1% incline simulates outdoor running (accounts for lack of wind resistance). Don't hold the handrails — it defeats the purpose. Running at incline is easier on knees than high-speed flat running.
                """.trimIndent()
            ),
            MuscleGroup.CARDIO
        ),

        CatalogExercise(
            Exercise(
                id = "db_stationary_bike",
                name = "Stationary Bike",
                sets = 1, repsDisplay = "20 min", restSeconds = 0,
                trackingType = TrackingType.TIME_BASED,
                notes = "Low-impact cardio. Great warm-up or standalone conditioning.",
                fullDescription = """
EQUIPMENT
Stationary bike (upright or recumbent)

MUSCLES
Primary: Quads, hamstrings, glutes. Secondary: calves.

HOW TO PERFORM
1. Adjust seat so knee has a slight bend at the bottom of the pedal stroke.
2. Pedal at a steady cadence (60–80 RPM for moderate, 90+ for cardio).
3. For intervals: 20 sec max effort / 40 sec easy.
4. Keep upper body relaxed — don't grip handles too hard.

KEY CUES
Seat height is key — too low causes knee pain. Push and pull through the pedal stroke. Great low-impact option for recovery days or post-leg day cardio.
                """.trimIndent()
            ),
            MuscleGroup.CARDIO
        ),

        CatalogExercise(
            Exercise(
                id = "db_battle_ropes",
                name = "Battle Ropes",
                sets = 4, repsDisplay = "30 sec", restSeconds = 60,
                trackingType = TrackingType.TIME_BASED,
                notes = "Alternating waves or slams. High-intensity full-body conditioning.",
                fullDescription = """
EQUIPMENT
Battle ropes, anchor point

MUSCLES
Primary: Shoulders, arms, core. Secondary: legs, back.

HOW TO PERFORM
1. Stand in athletic stance, knees slightly bent, hips hinged slightly.
2. Alternate arms — create waves that travel to the anchor.
3. Keep waves consistent — don't let them die out.
4. For slams: raise both arms overhead and drive ropes into floor simultaneously.

KEY CUES
Drive from the hips and core — don't just use arms. Consistent effort is the goal, not max speed at the start. Rest is just as important as work for conditioning.
                """.trimIndent()
            ),
            MuscleGroup.CARDIO
        ),

        // ── CHEST (additional) ─────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_db_fly",
                name = "Dumbbell Fly",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Flat bench. Wide arc — stretch the chest. Light weight, feel the muscle.",
                fullDescription = """
EQUIPMENT
Dumbbells, flat bench

MUSCLES
Primary: Pectoralis major (stretch emphasis). Secondary: front delts.

HOW TO PERFORM
1. Lie flat, dumbbells over chest, slight bend in elbows (keep it throughout).
2. Lower arms out to sides in a wide arc — feel a deep chest stretch.
3. Stop when elbows are at shoulder level (don't go lower).
4. Squeeze chest to bring dumbbells back up — same wide arc, not a press.

KEY CUES
This is a stretch movement — keep it light. Elbows stay at the same angle the whole time. Don't turn it into a press. The goal is the pec stretch and squeeze, not moving heavy weight.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        CatalogExercise(
            Exercise(
                id = "db_incline_fly",
                name = "Incline Dumbbell Fly",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bench at 30–45°. Same as flat fly but targets upper chest.",
                fullDescription = """
EQUIPMENT
Dumbbells, incline bench (30–45°)

MUSCLES
Primary: Upper pectoralis major. Secondary: front delts.

HOW TO PERFORM
1. Set bench to 30–45°. Hold dumbbells over upper chest, slight elbow bend.
2. Lower arms in a wide arc until elbows reach shoulder level.
3. Feel the stretch across the upper chest.
4. Bring dumbbells back together in the same arc — don't press.

KEY CUES
Elbow angle stays constant — this is a fly, not a press. Light weight and full ROM beats heavy and partial. Upper chest stretch is the priority.
                """.trimIndent()
            ),
            MuscleGroup.CHEST
        ),

        // ── BACK (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_dumbbell_pullover",
                name = "Dumbbell Pullover",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Across a bench. Trains lats and chest in a long range of motion.",
                fullDescription = """
EQUIPMENT
Single dumbbell, flat bench

MUSCLES
Primary: Latissimus dorsi, pectoralis major (sternal). Secondary: triceps (long head), serratus.

HOW TO PERFORM
1. Lie across the bench (shoulders on pad, hips low, feet flat).
2. Hold one dumbbell with both hands over your chest, arms slightly bent.
3. Lower the dumbbell in an arc behind your head — feel the lat stretch.
4. Pull it back over your chest in the same arc.

KEY CUES
Hips drop during the movement — this increases the lat stretch. Keep a consistent elbow angle. This is one of the only exercises that directly trains the serratus anterior.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_good_morning",
                name = "Good Morning",
                sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Bar on upper back. Hip hinge. Builds hamstrings and spinal erectors.",
                fullDescription = """
EQUIPMENT
Barbell, squat rack

MUSCLES
Primary: Hamstrings, spinal erectors. Secondary: glutes, core.

HOW TO PERFORM
1. Bar on upper traps (like back squat). Stand shoulder-width.
2. Soft bend in knees. Hinge at hips — push them back as you lean forward.
3. Lower until torso is roughly parallel to floor (or as far as hamstring flexibility allows).
4. Drive hips forward to return to standing.

KEY CUES
Back stays flat — this is a hinge, not a squat or a round-back movement. Start very light until the movement pattern is comfortable. Excellent for posterior chain development and injury prevention.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        CatalogExercise(
            Exercise(
                id = "db_machine_row",
                name = "Machine Row",
                sets = 3, repsDisplay = "12 reps", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Chest-pad machine. Removes low back — focus purely on back muscles.",
                fullDescription = """
EQUIPMENT
Seated row machine (chest pad supported)

MUSCLES
Primary: Mid-traps, rhomboids, lats. Secondary: biceps, rear delts.

HOW TO PERFORM
1. Adjust chest pad and seat. Chest stays on the pad throughout.
2. Grip handles (wide = more traps, narrow = more lats).
3. Pull handles toward torso — drive elbows back.
4. Squeeze shoulder blades together. Return with control.

KEY CUES
The chest pad prevents momentum — you can't use your body to help. Great for high volume back work without fatiguing the lower back. Focus on the mind-muscle connection.
                """.trimIndent()
            ),
            MuscleGroup.BACK
        ),

        // ── SHOULDERS (additional) ─────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_barbell_shrug",
                name = "Barbell Shrug",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Heavy barbell. Straight up-and-down — no rolling the shoulders.",
                fullDescription = """
EQUIPMENT
Barbell (or dumbbells)

MUSCLES
Primary: Upper trapezius. Secondary: levator scapulae.

HOW TO PERFORM
1. Hold barbell at hip level with overhand grip, shoulder-width.
2. Shrug shoulders straight up — think "touch ears with shoulders."
3. Hold at the top for 1 second.
4. Lower with control.

KEY CUES
Don't roll the shoulders in a circle — straight up and down only. Rolling can irritate the AC joint. Go heavy — traps respond well to load. Straps help if grip is the limiting factor.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        CatalogExercise(
            Exercise(
                id = "db_front_raise",
                name = "Front Raise",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Dumbbell or plate. Targets front (anterior) deltoid.",
                fullDescription = """
EQUIPMENT
Dumbbells or weight plate

MUSCLES
Primary: Anterior (front) deltoid. Secondary: upper chest, serratus.

HOW TO PERFORM
1. Hold dumbbells at hip level, palms facing down (or inward for neutral).
2. Raise both arms to shoulder height in front — keep slight elbow bend.
3. Pause at the top.
4. Lower with control — 2–3 seconds.

KEY CUES
Don't swing — strict form only. Avoid going above shoulder height (no benefit, more shoulder stress). Front delts are often already well-developed from pressing — don't overdo these.
                """.trimIndent()
            ),
            MuscleGroup.SHOULDERS
        ),

        // ── ARMS (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_incline_db_curl",
                name = "Incline Dumbbell Curl",
                sets = 3, repsDisplay = "10 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Arms hang behind torso on incline bench. Maximum long-head stretch.",
                fullDescription = """
EQUIPMENT
Dumbbells, incline bench (45–60°)

MUSCLES
Primary: Biceps brachii (long head). Secondary: brachialis.

HOW TO PERFORM
1. Sit back on incline bench, arms hanging behind your body, dumbbells at sides.
2. Curl both dumbbells — the stretched start position is what makes this special.
3. Supinate fully at the top (pinkies rotate up).
4. Lower all the way — full hang.

KEY CUES
The incline puts the bicep in a fully stretched position — more long-head recruitment. Don't rush out of the bottom. One of the best exercises for bicep peak. Light weight goes a long way here.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        CatalogExercise(
            Exercise(
                id = "db_reverse_curl",
                name = "Reverse Curl",
                sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Overhand grip. Builds brachialis and forearms — often a weak point.",
                fullDescription = """
EQUIPMENT
Barbell or EZ-bar

MUSCLES
Primary: Brachialis, brachioradialis. Secondary: biceps (reduced).

HOW TO PERFORM
1. Hold bar with overhand (pronated) grip, shoulder-width.
2. Curl bar up — elbows stay at sides.
3. Don't let wrists break or roll.
4. Lower slowly.

KEY CUES
The overhand grip shifts emphasis from biceps to the brachialis and forearms. Great for filling in arm development and improving wrist/forearm strength. Use an EZ-bar to reduce wrist strain.
                """.trimIndent()
            ),
            MuscleGroup.ARMS
        ),

        // ── LEGS (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_hack_squat",
                name = "Hack Squat",
                sets = 4, repsDisplay = "10 reps", restSeconds = 90,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Machine. Feet forward on platform — deep quad stretch at bottom.",
                fullDescription = """
EQUIPMENT
Hack squat machine

MUSCLES
Primary: Quadriceps (vastus medialis emphasis). Secondary: glutes, hamstrings.

HOW TO PERFORM
1. Position shoulders and back against pads. Feet shoulder-width on platform.
2. Release safeties. Lower until hips are below knees (full depth).
3. Drive through heels to full lockout.
4. Re-rack before stepping off.

KEY CUES
Feet lower on the platform = more quad. Feet higher = more glutes. Go deep — hack squats shine when you hit full ROM. Great alternative when back squats aren't available or comfortable.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_seated_calf_raise",
                name = "Seated Calf Raise",
                sets = 4, repsDisplay = "20 reps", restSeconds = 45,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Seated machine or with plate on knees. Targets soleus (deeper calf).",
                fullDescription = """
EQUIPMENT
Seated calf raise machine or flat bench with dumbbell on knee

MUSCLES
Primary: Soleus. Secondary: gastrocnemius (reduced due to knee flexion).

HOW TO PERFORM
1. Sit with knees at 90°, pad resting on lower quads.
2. Lower heels as far as possible — deep stretch.
3. Rise onto tiptoes as high as possible.
4. Hold peak contraction 1 second. Lower slowly.

KEY CUES
When the knee is bent, the gastrocnemius (the visible calf muscle) is in a shortened position — so the soleus does most of the work. You need both seated AND standing to fully develop calves. High reps, slow tempo.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        CatalogExercise(
            Exercise(
                id = "db_bstance_rdl",
                name = "B-Stance Romanian Deadlift",
                sets = 3, repsDisplay = "10 reps each side", restSeconds = 75,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "One foot slightly back for balance only. 90% single-leg loading.",
                fullDescription = """
EQUIPMENT
Dumbbells or barbell

MUSCLES
Primary: Hamstrings, glutes (unilateral). Secondary: spinal erectors, core.

HOW TO PERFORM
1. Stand with dumbbells. Stagger one foot back — toes of rear foot inline with heel of front foot.
2. The rear foot is for balance only — nearly all load is on the front leg.
3. Hinge at the hip on the front leg, pushing it back. Bar slides down front leg.
4. Drive front hip forward to stand.

KEY CUES
Good middle ground between bilateral RDL and single-leg RDL. More core demand than bilateral. Easier to balance than full single-leg. Great for addressing left-right strength imbalances.
                """.trimIndent()
            ),
            MuscleGroup.LEGS
        ),

        // ── CORE (additional) ──────────────────────────────────────────────

        CatalogExercise(
            Exercise(
                id = "db_side_plank",
                name = "Side Plank",
                sets = 3, repsDisplay = "30 sec each side", restSeconds = 45,
                trackingType = TrackingType.TIME_BASED,
                notes = "Lateral core stability. Key for spinal health and rotational sport performance.",
                fullDescription = """
EQUIPMENT
None

MUSCLES
Primary: Obliques, quadratus lumborum. Secondary: glutes, shoulder stabilizers.

HOW TO PERFORM
1. Lie on side, forearm on floor perpendicular to body.
2. Stack feet, lift hips — body forms a straight diagonal line.
3. Hold without letting hips sag.
4. Progress by raising top leg or adding a dumbbell on hips.

KEY CUES
Don't let hips drop or rotate forward. Squeeze glutes. The quadratus lumborum (deep low back muscle) is heavily loaded — critical for scoliosis and low back stability.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_landmine_rotation",
                name = "Landmine Rotation",
                sets = 3, repsDisplay = "12 reps each side", restSeconds = 60,
                trackingType = TrackingType.WEIGHT_REPS,
                notes = "Anchored barbell arc. Rotational power — directly transfers to golf swing.",
                fullDescription = """
EQUIPMENT
Barbell with one end anchored in a landmine attachment (or corner)

MUSCLES
Primary: Obliques, thoracic rotators. Secondary: shoulders, lats, hips.

HOW TO PERFORM
1. Hold far end of barbell with both hands, arms extended.
2. Rotate the bar in a wide arc from one hip to the other, staying tall.
3. Keep arms extended — the rotation comes from the thoracic spine and hips.
4. Control the bar back. Switch directions each rep.

KEY CUES
This mimics the golf swing pattern directly. The weight provides resistance through the full arc. Don't let your arms bend to compensate — rotate through the torso. Start light.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        ),

        CatalogExercise(
            Exercise(
                id = "db_hanging_leg_raise",
                name = "Hanging Leg Raise",
                sets = 3, repsDisplay = "10 reps", restSeconds = 60,
                trackingType = TrackingType.BODYWEIGHT,
                notes = "Straight legs, controlled. Harder version of hanging knee raise.",
                fullDescription = """
EQUIPMENT
Pull-up bar

MUSCLES
Primary: Lower rectus abdominis, hip flexors. Secondary: obliques, grip.

HOW TO PERFORM
1. Dead hang from bar.
2. Keep legs straight — raise them to parallel with floor (or higher for advanced).
3. Don't swing or use momentum.
4. Lower with control — don't let legs drop.

KEY CUES
Keep the movement slow and controlled. Posterior pelvic tilt at the top increases ab involvement. If straight-leg is too hard, bend knees first. Grip strength is often the limiting factor — use straps if needed.
                """.trimIndent()
            ),
            MuscleGroup.CORE
        )
    )
}
