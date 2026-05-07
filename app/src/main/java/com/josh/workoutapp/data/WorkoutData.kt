package com.josh.workoutapp.data

enum class TrackingType {
    WEIGHT_REPS,  // enter lbs + check off
    BODYWEIGHT,   // no weight — just check off
    TIME_BASED    // no weight — just check off
}

data class WarmupExercise(
    val id: String,
    val name: String,
    val repsDisplay: String,
    val notes: String,
    val fullDescription: String
)

data class Exercise(
    val id: String,
    val name: String,
    val sets: Int,
    val repsDisplay: String,
    val restSeconds: Int,
    val trackingType: TrackingType,
    val notes: String,
    val fullDescription: String
)

data class WorkoutDay(
    val id: Int,
    val name: String,
    val dayLabel: String,
    val focus: String,
    val warmupDuration: String,
    val warmupExercises: List<WarmupExercise>,
    val exercises: List<Exercise>
)

object WorkoutData {

    val days: List<WorkoutDay> = listOf(

        // ─────────────────────────────────────────────────────────────────
        // DAY 1  —  Push + Pull (Upper Body Balance)
        // ─────────────────────────────────────────────────────────────────
        WorkoutDay(
            id = 1,
            name = "Push + Pull",
            dayLabel = "Tuesday",
            focus = "Chest · shoulders · lats · mid-back · rear delts",
            warmupDuration = "10 min",
            warmupExercises = listOf(
                WarmupExercise(
                    id = "d1_w1",
                    name = "Light Cardio",
                    repsDisplay = "2 min",
                    notes = "Bike or treadmill walk. Easy pace to raise heart rate.",
                    fullDescription = """
EQUIPMENT
Bike or treadmill

PURPOSE
Raise core temperature and heart rate before loading the upper back. Cold muscles are less pliable and more injury-prone. Two minutes is enough to increase blood flow to the shoulders, traps, and rear delts before the heavier work.

HOW TO PERFORM
Choose any low-intensity cardio — bike, treadmill walk, rowing machine at light resistance. Keep the pace fully conversational. This is not a workout, it is a warm-up.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d1_w2",
                    name = "Band Pull-Apart",
                    repsDisplay = "10 reps",
                    notes = "Light band. Arms straight. Squeeze shoulder blades at full stretch.",
                    fullDescription = """
EQUIPMENT
Light resistance band

MUSCLES
Rear deltoids, rhomboids, mid-trapezius

HOW TO PERFORM
1. Hold a resistance band in both hands at shoulder width, arms extended straight in front of you at shoulder height, palms facing down.
2. Keeping your arms straight (a very slight bend in the elbows is okay), pull the band apart by driving your hands out to your sides.
3. Squeeze your shoulder blades together at full stretch — the band should touch or nearly touch your chest.
4. Slowly return to the start position under control. Do not let the band snap back.

KEY CUES
"Proud chest." Keep your chin neutral (don't jut it forward). Keep your rib cage down — do not arch your lower back to compensate.

COMMON MISTAKES
Bending the elbows too much (turns it into a bicep curl), shrugging the shoulders up toward the ears, rushing the return.

WHY IT'S HERE
The rear delts and mid-traps are chronically weak in people with upper-spine scoliosis and forward-rounded posture. This movement fires those muscles before every upper-back session, so the heavier exercises get better muscle recruitment from the start.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d1_w3",
                    name = "Prone Cobra",
                    repsDisplay = "10 reps (hold 2 sec)",
                    notes = "Lie face-down. Lift sternum — not chin. Rotate thumbs up.",
                    fullDescription = """
EQUIPMENT
None (floor or mat)

MUSCLES
Lower trapezius, thoracic erectors, rear delts, glutes

HOW TO PERFORM
1. Lie face-down on the floor with your arms at your sides, palms facing down.
2. Gently squeeze your glutes and lift your chest off the floor — this is a small movement, not a full back extension.
3. At the same time, rotate your hands so your thumbs point toward the ceiling and your palms face outward.
4. Pull your shoulder blades back and down (away from your ears) as you hold the top position for 2 full seconds.
5. Lower under control and repeat.

KEY CUES
Think about lifting your sternum, not your chin. The goal is thoracic extension, not neck extension. Keep your neck in a neutral position throughout.

COMMON MISTAKES
Cranking the neck up instead of extending through the mid-back. Forgetting to rotate the thumbs — the rotation is what activates the lower traps. Holding your breath.

WHY IT'S HERE
Directly targets the lower trapezius and thoracic extensors — the exact muscles that scoliosis and desk posture weaken. This also teaches you to extend through the thoracic spine, which is a critical motor pattern for maintaining good golf posture through 18 holes.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d1_w4",
                    name = "Cat-Cow",
                    repsDisplay = "10 reps",
                    notes = "All fours. Move slowly with your breath through the whole spine.",
                    fullDescription = """
EQUIPMENT
None (floor or mat)

MUSCLES
Spinal erectors, multifidus, core stabilizers

HOW TO PERFORM
1. Start on all fours — hands under shoulders, knees under hips, neutral spine.
2. COW: Inhale and let your belly drop toward the floor, lifting your chest and tailbone simultaneously. Your spine should arch downward.
3. CAT: Exhale and round your entire spine upward toward the ceiling, tucking your chin to your chest and your pelvis under. Think of a scared cat.
4. Move slowly and with your breath — one full breath per direction.

KEY CUES
The movement should travel through your entire spine, not just your lower back. Try to feel each vertebra move sequentially from neck to tailbone.

COMMON MISTAKES
Moving only at the lower back while the thoracic spine stays stiff — this is common with scoliosis. Consciously try to get movement through the upper and mid back.

WHY IT'S HERE
Warms up spinal mobility before loading. Given the C/T scoliosis, this helps restore segmental movement in the stiff areas of the thoracic spine and signals the stabilizing muscles to activate before heavier work begins.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d1_w5",
                    name = "Wall Slides",
                    repsDisplay = "10 reps",
                    notes = "Back flat against wall. Slide arms up and down — keep contact.",
                    fullDescription = """
EQUIPMENT
Smooth wall

MUSCLES
Lower trapezius, serratus anterior, rotator cuff

HOW TO PERFORM
1. Stand with your back flat against a wall, feet about 6 inches from the base of the wall.
2. Place your arms against the wall in a "goalpost" position: elbows at shoulder height, bent to 90 degrees, wrists flat against the wall.
3. Keeping your elbows, wrists, and the back of your hands all in contact with the wall, slowly slide your arms upward to a Y shape overhead.
4. Lower back down to the goalpost position under control.

KEY CUES
Your lower back should stay flat against the wall throughout — if it arches, you've lost shoulder mobility. Move slowly. If you can't keep all points of contact with the wall, only go as high as you can with good form.

COMMON MISTAKES
Letting the elbows or wrists peel away from the wall (usually due to tight lats or pec minor), shrugging at the top, rushing through the movement.

WHY IT'S HERE
Trains proper shoulder blade mechanics — specifically the upward rotation and depression of the scapula that prevents the rounded-shoulder pattern associated with C/T scoliosis. This is a direct corrective warm-up for the postural dysfunction the whole day is targeting.
                    """.trimIndent()
                )
            ),
            exercises = listOf(
                Exercise(
                    id = "d1_e1",
                    name = "Incline Dumbbell Press",
                    sets = 4, repsDisplay = "8 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "30–45° incline. Full range — touch chest lightly at bottom. Control the descent.",
                    fullDescription = """
EQUIPMENT
Adjustable bench set to 30–45°, two dumbbells

MUSCLES
Primary: Upper pectoralis major, anterior deltoid
Secondary: Triceps, serratus anterior

HOW TO PERFORM
1. Set the bench to 30–45 degrees. Sit with the dumbbells resting on your thighs, then kick them up to shoulder level as you lean back onto the pad.
2. Position the dumbbells at chest level, elbows angled about 45–60 degrees from your torso (not flared straight out to the sides). Palms face forward.
3. Press the dumbbells up and slightly inward until your arms are fully extended and the dumbbells are nearly touching at the top.
4. Lower under control — take 2 full seconds on the descent — until the dumbbells are at chest level and you feel a deep stretch in the pec.

KEY CUES
Keep your shoulder blades squeezed back into the pad throughout. Elbows at 45–60 degrees — not flared wide, which stresses the shoulder joint. The incline angle protects the shoulder compared to flat pressing and is more comfortable given the thoracic scoliosis.

COMMON MISTAKES
Flaring the elbows out to 90 degrees (increases shoulder impingement risk), bouncing the dumbbells off the chest, letting the shoulder blades protract (losing the scapular base), rushing the descent.

WHY IT'S HERE
Adds the horizontal pushing movement that was absent from the original program. Incline is preferred over flat because it stresses the shoulder joint less and provides better long-term shoulder health. Dumbbell pressing also allows each arm to find its natural path, accommodating any asymmetry from the scoliosis.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d1_e2",
                    name = "Seated Cable Row",
                    sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Neutral grip (V-bar). Retract scapula — don't shrug.",
                    fullDescription = """
EQUIPMENT
Cable machine, V-bar or neutral-grip attachment

MUSCLES
Mid-trapezius, rhomboids, lats, rear deltoids, biceps

HOW TO PERFORM
1. Sit at a low cable pulley row station. Plant your feet firmly on the foot pads or floor, knees slightly bent.
2. Grab the neutral-grip (palms facing each other) V-bar handle with both hands. Sit tall — spine neutral, chest up. This is your starting position.
3. Begin the pull by squeezing your shoulder blades back and together first, then drive your elbows straight back along your sides.
4. Pull the handle to your lower sternum/upper abdomen. At the top, your chest should be slightly forward and your shoulder blades should be fully retracted.
5. Slowly extend your arms back to the start. Allow your shoulder blades to protract slightly at the end — full stretch — before beginning the next rep.

KEY CUES
"Row with your elbows, not your hands." Lead with the shoulder blades. Do not lean back excessively to pull more weight — this turns it into a lower-back exercise and removes tension from the mid-back.

COMMON MISTAKES
Shrugging the shoulders up as you pull (traps take over), jerking the torso backward, not achieving full shoulder blade retraction at the top, not allowing full arm extension at the bottom.

WHY IT'S HERE
The mid-traps and rhomboids are the postural muscles that pull your spine into alignment against the scoliotic curve. The neutral grip reduces stress on the shoulder joint versus an overhand grip. This is the primary mid-back builder of the session.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d1_e3",
                    name = "Lat Pulldown",
                    sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Wide overhand grip. Pull to upper chest — never behind the neck.",
                    fullDescription = """
EQUIPMENT
Lat pulldown machine, wide bar

MUSCLES
Latissimus dorsi, teres major, biceps, rear delts

HOW TO PERFORM
1. Sit at the lat pulldown station. Adjust the thigh pads so your legs are locked in place under them.
2. Grip the bar slightly wider than shoulder width with an overhand (pronated) grip. Lean back slightly — maybe 10–15 degrees — this is your set position for the whole exercise.
3. Begin by depressing your shoulder blades downward (think "put your shoulder blades in your back pockets"), then drive your elbows down and slightly back toward your hips.
4. Pull the bar to your upper chest — aim for chin/upper chest contact. At the bottom, your elbows should be pointing down toward the floor at a slightly forward angle.
5. Slowly let the bar rise back to the top, allowing your shoulder blades to rise and your arms to fully extend. You should feel a deep stretch in your lats at the top.

KEY CUES
"Elbows to your back pockets." Initiate with the shoulder blades — do not pull with your arms first. Keep the slight lean throughout; don't rock.

COMMON MISTAKES
Pulling the bar behind the neck (stresses the cervical spine — never do this), using momentum and rocking, losing the stretch at the top by releasing tension early, shrugging at the top.

WHY IT'S HERE
Lats are the largest muscles of the back and a primary driver of the downswing. Strong lats help stabilize and decompress the spine. Wide-grip pulldowns also stretch the thoracic region of the spine with every rep, providing a decompressive benefit for the scoliosis.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d1_e_facepull",
                    name = "Face Pull",
                    sets = 3, repsDisplay = "15 reps", restSeconds = 60,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Cable at face height, rope attachment. Elbows HIGH throughout.",
                    fullDescription = """
EQUIPMENT
Cable machine set at approximately face/eye height, rope attachment

MUSCLES
Rear deltoids, external rotators of the shoulder, mid-trapezius, rhomboids

HOW TO PERFORM
1. Set the cable pulley at approximately face/eye height. Attach the rope.
2. Grab both ends of the rope with an overhand grip (thumbs pointing toward you). Take a few steps back so there is tension in the cable. Stand tall or take a split stance for stability.
3. Pull the rope toward your face, keeping your elbows high — at or above shoulder height — throughout the movement.
4. As you pull, separate your hands so the rope splits at your face — your hands should finish on either side of your head with your palms facing forward and thumbs pointing behind you (external rotation).
5. Pause at the top and squeeze, then slowly return to the start.

KEY CUES
"Elbows stay high." The external rotation at the end (hands splitting apart) is the most important part — do not skip it. Use light weight. This is a corrective exercise, not a strength test.

COMMON MISTAKES
Letting the elbows drop below shoulder height (takes the rear delts out of the movement), using too much weight and losing the external rotation component, pulling to the neck or chin instead of the face.

WHY IT'S HERE
This is arguably the single best exercise for correcting forward head posture and rounded upper back associated with C/T scoliosis. It directly trains the muscles responsible for keeping the humeral head seated properly in the shoulder socket — essential for long-term shoulder health in a golfer who swings a club hundreds of times per week.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d1_e4",
                    name = "Seated DB Shoulder Press",
                    sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Seated — lower spinal load than standing. Stop just below full lockout to keep tension.",
                    fullDescription = """
EQUIPMENT
Adjustable bench set upright (90°), two dumbbells

MUSCLES
Primary: Anterior and medial deltoids
Secondary: Triceps, upper trapezius, serratus anterior

HOW TO PERFORM
1. Sit on an upright bench (back fully supported). Hold a dumbbell in each hand at shoulder height, palms facing forward, elbows bent roughly 90 degrees. This is your start position.
2. Press both dumbbells up and slightly inward until your arms are nearly straight (stop just short of full lockout — keep tension on the delts).
3. Lower under control back to the starting position. Your elbows should return to roughly 90 degrees or slightly below.

KEY CUES
Keep your core braced and lower back against the pad — do not arch the lumbar spine to get the weight overhead. The seated position significantly reduces spinal compressive load compared to standing pressing, which matters for the thoracic curve.

COMMON MISTAKES
Arching the lower back excessively to compensate for limited shoulder mobility, pressing dumbbells forward instead of vertically overhead, locking out completely (reduces tension and compresses the joint).

WHY IT'S HERE
Shoulder pressing adds the vertical push pattern that was missing from the original program. Seated dumbbell pressing is preferred over barbell overhead pressing because each arm can follow its natural arc, accommodating any asymmetry from the scoliosis, with lower spinal load.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d1_e5",
                    name = "Tricep Pushdown",
                    sets = 3, repsDisplay = "12 reps", restSeconds = 60,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Rope or straight bar. Elbows pinned to sides. Full extension at bottom.",
                    fullDescription = """
EQUIPMENT
Cable machine set at high position, rope or straight bar attachment

MUSCLES
Triceps brachii (all three heads)

HOW TO PERFORM
1. Set the cable pulley to the highest position. Attach a rope or straight bar. Stand facing the machine and grip the attachment with both hands, palms facing down (bar) or facing each other (rope).
2. Tuck your elbows into your sides and hold them there throughout the entire movement — they should not move forward or back.
3. Push the attachment down until your elbows are fully extended. If using the rope, spread the ends apart slightly at the bottom for a full contraction.
4. Slowly let the weight return to the start — your forearms should rise until your elbows are at approximately 90 degrees or slightly above.

KEY CUES
"Elbows stay glued to your sides." If your elbows start to travel forward and up to initiate the rep, you are using too much weight. The movement is entirely at the elbow joint — your upper arms don't move.

COMMON MISTAKES
Letting elbows flare out or travel forward, using body lean to push the weight down, not achieving full extension at the bottom.

WHY IT'S HERE
Balances the large amount of pulling work in this session. Strong triceps are also important for maintaining club control through impact and for deceleration — a chronically weak arm that fatigues on the back nine is a power leak. This is a low-injury-risk exercise well-suited for getting back into training.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d1_e6",
                    name = "Seal Row",
                    sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Chest flat on elevated bench. Let arms hang full dead-hang between reps.",
                    fullDescription = """
EQUIPMENT
Elevated flat bench (on two plyo boxes or a high bench), two dumbbells or a barbell

MUSCLES
Primary: Mid-trapezius, rhomboids, rear deltoids
Secondary: Lats, biceps

HOW TO PERFORM
1. Set a flat bench on two sturdy surfaces (plyo boxes, steps) high enough that dumbbells or a barbell can hang freely below without touching the floor. Lie face-down with your chest on the pad and feet on the bench — your torso is fully supported.
2. Let both arms hang straight down from the bench, holding dumbbells (or grip a barbell underneath). This is a full dead-hang start — no pre-loaded tension.
3. Row both dumbbells up simultaneously by driving your elbows back and squeezing your shoulder blades together. Pull until your upper arms are roughly parallel to the floor or slightly above.
4. Lower under complete control back to the dead-hang. Pause at the bottom before the next rep — do not use the stretch reflex.

KEY CUES
The chest support is the point. Your torso does not move at all — this isolates the back muscles completely and removes any lower-back loading. The dead-hang at the bottom ensures full range of motion and prevents cheating. Retract and depress the shoulder blades as you pull, not just pull with the arms.

COMMON MISTAKES
Not letting the arms fully extend at the bottom (shortens the range and removes the stretch), letting the chest peel off the pad, using momentum by bouncing out of the bottom.

WHY IT'S HERE
The seal row provides the same mid-back stimulus as a chest-supported T-bar row but with full shoulder blade range of motion — the dead-hang bottom position gets more scapular protraction and a deeper stretch than any padded machine row. For scoliosis, the prone position with chest support means zero spinal shear or compressive force while still loading the postural muscles that counter the curve. The bilateral dumbbell version also lets each shoulder move on its own arc, accommodating asymmetry.
                    """.trimIndent()
                )
            )
        ),

        // ─────────────────────────────────────────────────────────────────
        // DAY 2  —  Lower Body, Hip Hinge & Core
        // ─────────────────────────────────────────────────────────────────
        WorkoutDay(
            id = 2,
            name = "Lower Body, Hinge & Core",
            dayLabel = "Wednesday",
            focus = "Quads · glutes · hamstrings · anti-rotation core",
            warmupDuration = "10 min",
            warmupExercises = listOf(
                WarmupExercise(
                    id = "d2_w1",
                    name = "Light Cardio",
                    repsDisplay = "5 min",
                    notes = "Bike or treadmill walk. Raise heart rate before loading the hips.",
                    fullDescription = """
EQUIPMENT
Bike or treadmill

PURPOSE
Warm up the hips, glutes, and hamstrings before heavy hinge work. Five minutes of light cardio raises core temperature, increases synovial fluid in the hip joints, and prepares the posterior chain for loading.

HOW TO PERFORM
Any light cardio — bike, treadmill walk, or even a brisk walk around the gym floor. Conversational pace only. Do not push the intensity here.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d2_w2",
                    name = "Glute Bridge",
                    repsDisplay = "10 reps",
                    notes = "Drive through heels. Squeeze glutes hard at the top. Ribs down.",
                    fullDescription = """
EQUIPMENT
None (floor)

MUSCLES
Glutes, hamstrings, lower back extensors

HOW TO PERFORM
1. Lie on your back with knees bent, feet flat on the floor hip-width apart, arms at your sides.
2. Squeeze your glutes and drive your hips up toward the ceiling until your hips, knees, and shoulders form a straight line.
3. Hold for 1–2 seconds at the top, squeezing hard, then lower under control.

KEY CUES
Drive through your heels, not your toes. Squeeze the glutes — do not just push through the lower back. Keep your ribs down at the top (do not hyperextend the lumbar spine).

WHY IT'S HERE
Activates the glutes before the heavier work of the day. The RDL and goblet squat both depend on strong glute activation — this warm-up primes them so they fire correctly under load rather than letting the lower back compensate.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d2_w3",
                    name = "Hip Circle",
                    repsDisplay = "10 ea. direction",
                    notes = "Stand on one leg. Draw large circles with the lifted knee.",
                    fullDescription = """
EQUIPMENT
None (wall optional for balance)

MUSCLES
Hip flexors, glutes, hip external and internal rotators

HOW TO PERFORM
Stand on one leg (use a wall for balance if needed). Draw large circles with your lifted knee — forward, out to the side, back, and in. Complete 10 circles in one direction, then 10 in reverse. Switch legs.

KEY CUES
Make the circles as large as your mobility allows. Move slowly and deliberately — this is a joint mobility drill, not a speed drill. Keep the standing leg slightly bent.

WHY IT'S HERE
Warms up the full circumference of the hip capsule. Golfers and baseball players depend heavily on hip mobility — restricted hip rotation forces compensation in the lumbar spine and thoracic spine, both already compromised by the scoliosis.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d2_w4",
                    name = "Leg Swing — Front to Back",
                    repsDisplay = "10 ea. leg",
                    notes = "Hold wall for balance. Pendulum swing — let gravity do the work.",
                    fullDescription = """
EQUIPMENT
Wall or rack for balance

MUSCLES
Hip flexors, hamstrings, glutes

HOW TO PERFORM
Stand next to a wall with one hand for balance. Swing one leg forward and back in a controlled pendulum motion — let gravity do most of the work, gradually increasing range over 10 reps. Keep the swinging leg relatively relaxed. Switch legs.

KEY CUES
Do not force the range — let the momentum naturally increase it. Keep your torso upright throughout. The goal is passive mobilization of the hip flexors and hamstrings.

WHY IT'S HERE
Dynamically stretches the hip flexors and hamstrings in the sagittal plane — the same plane that the RDL and goblet squat load. This primes the hip for the hinge pattern before you add weight to it.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d2_w5",
                    name = "Leg Swing — Side to Side",
                    repsDisplay = "10 ea. leg",
                    notes = "Face wall, both hands for support. Swing leg across body and out.",
                    fullDescription = """
EQUIPMENT
Wall for balance

MUSCLES
Hip abductors, adductors, hip internal and external rotators

HOW TO PERFORM
Face the wall and place both hands on it for balance. Swing one leg across your body (adduction) and then out to the side (abduction) in a pendulum motion. Gradually increase the range over 10 reps. Switch legs.

KEY CUES
Keep the torso square to the wall — do not let your hips tilt sideways to increase range. The movement should come entirely from the hip joint.

WHY IT'S HERE
Opens the hip in the frontal plane, which is critical for lateral weight transfer during the golf swing and for the glute med work coming up in the Lateral Band Walk. Cold hip abductors and adductors are a common source of early fatigue in golfers.
                    """.trimIndent()
                )
            ),
            exercises = listOf(
                Exercise(
                    id = "d2_e0",
                    name = "Leg Press",
                    sets = 4, repsDisplay = "10 reps", restSeconds = 120,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Feet shoulder-width at mid-platform. Full depth without lower back leaving pad.",
                    fullDescription = """
EQUIPMENT
Leg press machine

MUSCLES
Primary: Quadriceps
Secondary: Glutes, hamstrings, adductors

HOW TO PERFORM
1. Sit in the leg press machine with your back flat against the pad. Place your feet shoulder-width apart in the middle of the platform — not too high (reduces quad involvement) and not too low (stresses the knees).
2. Release the safety handles and lower the platform by bending your knees until your knees are at 90 degrees or slightly deeper. Your lower back should stay flat against the pad throughout.
3. Press the platform back up by driving through the whole foot, extending the knees and hips until your legs are nearly straight (leave a slight bend — do not lock out the knees).
4. Control the descent — do not let the weight drop.

KEY CUES
Keep your lower back pressed flat into the seat pad. If your lower back rounds and lifts at the bottom, you have gone too deep — reduce the range. Feet straight or slightly turned out (5–15 degrees). Do not let your knees collapse inward during the press.

COMMON MISTAKES
Letting the lower back peel off the pad at the bottom (spinal flexion under load — dangerous), using a partial range, locking out the knees at the top, feet too narrow or too low on the platform.

WHY IT'S HERE
The leg press provides heavy quad loading with zero spinal compressive force — making it the ideal quad exercise for someone with C/T scoliosis. Barbell back squats load the spine axially; the leg press delivers equivalent quad stimulus without that tradeoff. Strong quads are critical for the explosive lower body drive in the golf swing.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e1",
                    name = "Romanian Deadlift (RDL)",
                    sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Hips back, soft knee. Bar stays close to legs the entire way.",
                    fullDescription = """
EQUIPMENT
Barbell or dumbbells

MUSCLES
Hamstrings, glutes, lower back erectors, core

HOW TO PERFORM
1. Stand with feet hip-width apart, holding a barbell in front of your thighs with an overhand grip (or dumbbells at your sides). Shoulders back and down, chest up.
2. Begin the movement by pushing your hips backward — think "close a car door with your butt." Keep the bar (or dumbbells) sliding close to your legs throughout.
3. Maintain a slight bend in your knees as you hinge — this is not a squat. Your back should stay flat (neutral spine) the entire time.
4. Lower until you feel a strong stretch in your hamstrings — typically when the bar reaches mid-shin level. Your torso should be nearly parallel to the floor at the bottom.
5. Drive your hips forward (back to standing) by squeezing your glutes. Stand tall at the top.

KEY CUES
"Hips back, not chest down." The bar path should be almost touching your shins and quads the entire way. If the bar drifts away from your body, you are bending at the spine rather than hinging at the hip.

COMMON MISTAKES
Rounding the lower back (most common — a sign the weight is too heavy or the hinge pattern is not yet grooved), bending the knees too much (turns it into a squat), letting the bar swing away from the body.

WHY IT'S HERE
The RDL is the foundational movement of the golf swing. Every time you set your address position, take the club back, and drive through impact, you are expressing hip hinge strength. Strong hamstrings and glutes from the RDL = more power and more consistency in your swing. It is the most important lower-body exercise in this program.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e2",
                    name = "Goblet Squat",
                    sets = 3, repsDisplay = "10 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Hold DB vertically at chest. Heels flat, chest tall, elbows inside knees.",
                    fullDescription = """
EQUIPMENT
Dumbbell or kettlebell

MUSCLES
Quads, glutes, core, upper back (isometric hold)

HOW TO PERFORM
1. Hold a dumbbell vertically against your chest with both hands, cupping the top end of the dumbbell (like holding a goblet). Feet shoulder-width apart, toes pointed out 10–15 degrees.
2. Keeping the dumbbell tight to your chest and your elbows pointing down (not flaring out), sit your hips back and down into a squat.
3. Descend until your elbows just touch the inside of your knees — roughly parallel or just below. Your chest should remain tall and upright throughout.
4. Drive through your heels to stand back up. Squeeze your glutes at the top.

KEY CUES
"Chest up, elbows inside the knees." The weight in front of you acts as a counterbalance — use it to sit deeper than you normally could. Keep your heels flat on the floor the whole time.

COMMON MISTAKES
Letting the chest fall forward (the dumbbell should prevent this), heels rising off the floor (tight ankles — try elevating heels on plates), knees caving inward.

WHY IT'S HERE
Goblet squats build quad and glute strength in a spinal-friendly way — the anterior loading is easier on the C/T spine than a barbell back squat. The upright torso position also builds the hip mobility and ankle dorsiflexion you need to maintain a balanced athletic stance over the golf ball.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e3",
                    name = "Single-Leg Glute Bridge",
                    sets = 3, repsDisplay = "12 ea.", restSeconds = 60,
                    trackingType = TrackingType.BODYWEIGHT,
                    notes = "Lie on back. Extend one leg. Drive through grounded heel — hips LEVEL.",
                    fullDescription = """
EQUIPMENT
None (floor)

MUSCLES
Glutes (unilateral), hamstrings, core (anti-rotation)

HOW TO PERFORM
1. Lie on your back, knees bent, feet flat on the floor. Extend one leg straight so it is parallel to the thigh of the bent leg.
2. Press through the heel of the grounded foot and drive your hips up, keeping the extended leg in line with your body. Your hips should stay level — do not let one side drop.
3. Squeeze the glute of the working leg hard at the top for 1–2 seconds, then lower with control.
4. Complete all reps on one side before switching.

KEY CUES
Hips stay square — resist the urge to twist. If your hips drop on the unsupported side, your glute med is weak; this will show up in your golf stance. Keep the non-working leg extended and in line (not raised toward the ceiling).

COMMON MISTAKES
Letting the hips rotate or one side sag, driving through the toes instead of the heel, hyperextending the lower back at the top.

WHY IT'S HERE
With scoliosis, it's common to have glute strength asymmetry — the muscles on the concave side of the curve often work harder to compensate for structural imbalance. Single-leg bridges expose and correct this imbalance directly.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e4",
                    name = "Lateral Band Walk",
                    sets = 3, repsDisplay = "15 ea. direction", restSeconds = 45,
                    trackingType = TrackingType.BODYWEIGHT,
                    notes = "Band above knees. Quarter-squat throughout — stay low. Toes forward.",
                    fullDescription = """
EQUIPMENT
Resistance band (loop or tied)

MUSCLES
Glute medius, glute minimus, hip external rotators, TFL

HOW TO PERFORM
1. Place a resistance band just above your knees (not at the ankles — too much ankle torque). Stand with feet hip-width apart and lower into a quarter-squat position — slight bend in the knees, hips back slightly.
2. Keeping your toes pointing forward and your hips level, step laterally with your right foot about 12 inches to the right. Then bring your left foot 12 inches to the right (maintaining the original spacing).
3. Take the prescribed number of steps in one direction, then walk back the other way. Stay low in the quarter-squat throughout.

KEY CUES
Do not let the knees cave inward — the band will want to pull them together. Keep constant tension in the band (feet never closer than hip-width). Keep your torso upright, not leaning side to side.

COMMON MISTAKES
Standing up out of the squat position between steps, letting the feet come together and releasing band tension, walking like a duck with toes pointing outward instead of forward.

WHY IT'S HERE
Glute med weakness causes the hips to sway laterally during the golf swing — this kills power and causes compensatory movements up the chain into the already-compromised C/T spine. Strong glute meds = stable pelvic platform = better weight transfer through impact.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e5",
                    name = "Pallof Press",
                    sets = 3, repsDisplay = "12 ea. side", restSeconds = 60,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Cable at chest height. Resist ALL rotation — your body should not twist.",
                    fullDescription = """
EQUIPMENT
Cable machine or resistance band anchored at chest height

MUSCLES
Core (transverse abdominis, obliques), anti-rotation stabilizers

HOW TO PERFORM
1. Set a cable pulley or anchor a band at chest height. Stand perpendicular to the anchor point.
2. Hold the handle with both hands at your sternum. Step out until there is significant tension. Stand with feet shoulder-width apart.
3. Press your hands straight out in front of you, fully extending your arms. Hold for 1–2 seconds — the cable will be trying to rotate your torso toward the machine; resist it completely.
4. Pull your hands back to your chest under control. That is one rep.
5. Complete all reps, then turn around and repeat with the cable coming from the opposite side.

KEY CUES
Your body should not rotate or twist at all during the press — this is the entire point. If you are rotating, the weight is too heavy or you are standing too far from the anchor. Breathe out as you press.

COMMON MISTAKES
Allowing torso rotation (the exercise becomes useless), not maintaining equal stance width, stepping too far from the machine (turns it into a stretch rather than a stability drill).

WHY IT'S HERE
The Pallof press trains anti-rotation — the ability to resist unwanted spinal twisting. For scoliosis, the spine is already in a compromised rotated position; teaching the core muscles to resist further rotation is directly therapeutic. For golf, this same anti-rotation stiffness is what allows you to store and release rotational energy efficiently through the swing.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e6",
                    name = "Dead Bug",
                    sets = 3, repsDisplay = "8 ea. side", restSeconds = 45,
                    trackingType = TrackingType.BODYWEIGHT,
                    notes = "Lower back PRESSED to floor the ENTIRE time. Shorten range if back arches.",
                    fullDescription = """
EQUIPMENT
None (floor)

MUSCLES
Transverse abdominis, deep core stabilizers, hip flexors

HOW TO PERFORM
1. Lie on your back with your lower back pressed firmly into the floor — there should be no gap between your spine and the floor.
2. Raise both arms straight up toward the ceiling (perpendicular to the floor) and raise both legs to a 90/90 position: hips at 90 degrees, knees at 90 degrees.
3. Slowly lower your right arm overhead toward the floor while simultaneously straightening and lowering your left leg toward the floor — opposite arm and leg move together.
4. Lower until your arm is about 1 inch off the floor and your heel is about 1 inch off the floor — without your lower back leaving the floor.
5. Return both limbs to the start position, then repeat on the other side (left arm, right leg).

KEY CUES
The lower back must stay pressed to the floor for the entire set — this is non-negotiable. The moment your back arches away from the floor, the exercise stops. If you cannot keep your back down, shorten the range of motion — only lower the limbs halfway.

COMMON MISTAKES
Letting the lower back arch off the floor (most common), moving too fast, holding your breath (exhale as you lower the limbs).

WHY IT'S HERE
The dead bug specifically trains the deep spinal stabilizers (multifidus, transverse abdominis) that support the individual vertebrae — the exact muscles that are underactive in scoliosis. It also trains contralateral coordination, which mirrors the rotational demands of the golf swing.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d2_e7",
                    name = "Farmer's Carry",
                    sets = 3, repsDisplay = "40 yds", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Heavy DBs, one per hand. Walk tall — shoulders packed down and back.",
                    fullDescription = """
EQUIPMENT
Two dumbbells or kettlebells (one in each hand)

MUSCLES
Forearms and grip, upper traps, core stabilizers, glutes, entire posterior chain

HOW TO PERFORM
1. Stand holding a heavy dumbbell in each hand, arms at your sides. Shoulders pulled back and down — do not let them shrug or round forward.
2. Walk forward for the prescribed distance (40 yards), maintaining perfect posture: chin level, chest up, core braced, shoulders packed.
3. Your steps should be deliberate and controlled — no waddling or leaning to either side.

KEY CUES
"Walk tall like you own the room." The weight will try to pull your shoulders forward and down — resist this completely. If one shoulder drops more than the other, reduce the weight. Enter weight per dumbbell (each hand).

COMMON MISTAKES
Shrugging the shoulders to hold the weight (traps do all the work), letting the torso tilt to one side, looking down at the floor (flexes the cervical spine).

WHY IT'S HERE
Farmer carries are one of the best full-body exercises for spinal stability and total-body tension. For scoliosis, the bilateral loading and postural demand train the spine to resist lateral flexion — the exact curve you are working against. It also builds the grip and forearm strength that translates directly to club control on the course.
                    """.trimIndent()
                ),
            )
        ),

        // ─────────────────────────────────────────────────────────────────
        // DAY 3  —  Golf Power & Rotational Training
        // ─────────────────────────────────────────────────────────────────
        WorkoutDay(
            id = 3,
            name = "Golf Power & Rotation",
            dayLabel = "Thursday",
            focus = "Rotational power · hip-shoulder separation · explosive hip drive",
            warmupDuration = "12 min",
            warmupExercises = listOf(
                WarmupExercise(
                    id = "d3_w1",
                    name = "Light Cardio",
                    repsDisplay = "5 min",
                    notes = "Bike. Elevate heart rate and warm up the hips before rotational work.",
                    fullDescription = """
EQUIPMENT
Stationary bike

PURPOSE
Warm the posterior chain and hip musculature before explosive rotational work. This session includes med ball slams and KB swings — loading a cold hip complex with maximal effort is a common cause of strain. Five minutes on the bike prepares you for it.

HOW TO PERFORM
Moderate pace on the stationary bike. Conversational effort only. Use the last 30 seconds to gradually increase resistance or cadence slightly to raise the heart rate.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d3_w2",
                    name = "Hip 90/90 Stretch",
                    repsDisplay = "30 sec ea. side",
                    notes = "Both legs at 90°. Sit tall. Lean over front shin for deeper stretch.",
                    fullDescription = """
EQUIPMENT
None (floor)

MUSCLES
Hip external and internal rotators, hip capsule

HOW TO PERFORM
1. Sit on the floor and position one leg in front of you with the knee and hip both bent to 90 degrees. Position the other leg behind you also bent to 90 degrees (making an "S" shape from above).
2. Sit tall and breathe into the stretch — avoid the urge to lean away from the tight side.
3. After 30 seconds, gently lean your torso toward the front shin for a deeper external rotation stretch.
4. Switch sides.

KEY CUES
Sit upright on your sit bones — do not collapse to one side. The stretch should be felt in the outer hip, not the knee. If the knee feels strain, support it with a folded towel.

WHY IT'S HERE
This is the most important hip mobility drill for golfers. Restricted hip rotation forces the lower back and thoracic spine to compensate during the backswing and follow-through — directly stressing the already-compromised scoliotic segments. Doing this before the rotational power work allows you to access full hip range safely.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d3_w3",
                    name = "Thoracic Rotation",
                    repsDisplay = "10 reps ea. side",
                    notes = "All fours. One hand behind head. Rotate elbow toward floor then ceiling.",
                    fullDescription = """
EQUIPMENT
None (floor)

MUSCLES
Thoracic rotators, obliques

HOW TO PERFORM (QUADRUPED)
1. Start on all fours. Place one hand behind your head, elbow pointing out.
2. Rotate your elbow toward the opposite arm (closing), then rotate it as far open as you can toward the ceiling.
3. Follow your elbow with your eyes — your head should turn with it. Aim for maximal range. Repeat, then switch sides.

KEY CUES
The rotation happens at the thoracic spine — your hips should stay still. Follow your elbow with your eyes to ensure the neck and thoracic spine rotate together. Pause at the end range and breathe before returning.

WHY IT'S HERE
This directly mobilizes the thoracic rotation that your golf swing depends on. Going into rotational power training with a stiff T-spine forces the lumbar spine to rotate instead — a primary cause of lower back pain in golfers and a dangerous load pattern given the scoliosis.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d3_w4",
                    name = "Band Wood Chop (Light — Warm-Up Only)",
                    repsDisplay = "10 ea. side",
                    notes = "Very light band. Groove the rotation pattern before adding cable weight.",
                    fullDescription = """
EQUIPMENT
Light resistance band anchored at shoulder height

PURPOSE
Groove the rotational movement pattern of the cable wood chops before loading it. Using a light band allows you to feel the correct sequencing (hips first, arms follow) without the distraction of heavy resistance.

HOW TO PERFORM
Anchor a light band at shoulder height. Stand sideways to the anchor. Using only enough resistance to feel the band, practice the high-to-low diagonal pull across the body. Focus entirely on initiating with the hips — the arms are passengers. 10 reps each direction.

KEY CUES
This is a warm-up — go slow and deliberate. Feel the hips rotate first. Feel the obliques engage. This primes the neuromuscular pattern so the heavier cable work is immediately more efficient.
                    """.trimIndent()
                ),
                WarmupExercise(
                    id = "d3_w5",
                    name = "Shadow Golf Swing (Slow Motion)",
                    repsDisplay = "5 ea. side",
                    notes = "Full swing motion at 20% speed. Feel the sequencing: hips → core → arms.",
                    fullDescription = """
EQUIPMENT
None (or use a golf club if available)

PURPOSE
Rehearse the full kinetic sequence of the golf swing at slow speed before the explosive session. This wires in the correct movement pattern and ensures the nervous system is prepared for the power work ahead.

HOW TO PERFORM
Take your normal golf address position. Move through the full backswing and downswing in slow motion — about 20% of your normal swing speed. Pause at the top of the backswing, then feel the hip lead the downswing, followed by the torso, then the arms. Do not rush. 5 reps each side (trail and lead leg forward).

KEY CUES
Focus on the sequencing: hips initiate the downswing, core follows, arms and hands come last. This is the exact pattern you are training in the cable chops, med ball slams, and landmine press today. The slow-motion swing makes it conscious before making it explosive.
                    """.trimIndent()
                )
            ),
            exercises = listOf(
                Exercise(
                    id = "d3_e1",
                    name = "Med Ball Rotational Slam",
                    sets = 3, repsDisplay = "8 ea. side", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Start at 10 lb ball. Explosive — power from hip, arms are passive.",
                    fullDescription = """
EQUIPMENT
Medicine ball / slam ball (10–15 lbs to start)

MUSCLES
Core rotators, obliques, hips, lats, shoulders — total power chain

HOW TO PERFORM (WALL VERSION)
1. Stand sideways to a solid wall (or rebounder), 3–4 feet away. Hold the med ball at hip level on the side away from the wall.
2. Rotate aggressively toward the wall, driving the ball explosively into the wall with a full hip and core rotation.
3. Catch the rebound (or let it drop and reset). The power should come from your hips — your arms just guide the ball.

HOW TO PERFORM (FLOOR SLAM VERSION)
1. Stand with feet shoulder-width apart holding the ball at your left hip.
2. Rotate explosively, slamming the ball into the floor to your right side. Let it bounce and catch it, or reset.
3. Alternate sides each rep.

KEY CUES
Generate power from the ground up — push off the back foot, rotate the hip, then let the core and arms follow. This movement is almost identical to a golf swing in its kinetic sequence. Enter ball weight in lbs.

COMMON MISTAKES
Using only the arms and shoulders with no hip rotation (produces weak throws and misses the golf-transfer benefit), not catching and controlling the rebound (safety and reflexive strength).

WHY IT'S HERE
This is the most direct power transfer exercise to the golf swing in the entire program. It trains the same explosive hip-core-shoulder sequence at near-maximal speed — exactly what produces driver swing speed at the tee. At 116 mph, you already have this pattern. This maintains and builds it.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e2",
                    name = "Cable Wood Chop — High to Low",
                    sets = 3, repsDisplay = "10 ea. side", restSeconds = 75,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Cable high. Diagonal pull down across body — hips initiate, arms follow.",
                    fullDescription = """
EQUIPMENT
Cable machine, single handle, pulley set high (above shoulder height)

MUSCLES
Obliques, lats, glutes, hip external rotators — the downswing muscle chain

HOW TO PERFORM
1. Set the cable pulley high (above shoulder height). Attach a single handle. Stand sideways to the machine, feet shoulder-width apart.
2. Hold the handle with both hands, arms extended toward the high pulley. This is your start.
3. In one fluid motion, pull the handle diagonally across your body — down and across toward your opposite hip. Your torso should rotate and your hips should turn to face the direction of the chop.
4. Control the return — do not let the cable yank you back. Reset and repeat. Switch sides and repeat all sets.

KEY CUES
The movement starts with the hip and pelvis rotating, and the arms follow. Do not muscle it with just your arms and shoulders. This mimics the downswing — the high-to-low diagonal is the exact plane of the golf club from the top of the backswing through impact.

COMMON MISTAKES
Using only the arms, not rotating the hips, stepping the feet during the movement (you lose the rotational training stimulus).

WHY IT'S HERE
Directly trains the downswing power pattern with resistance. The high-to-low plane maps exactly onto the club path from the top of the backswing through impact. Unlike the med ball slam, this is a controlled eccentric return — training both the power and the deceleration of the downswing.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e3",
                    name = "Cable Wood Chop — Low to High",
                    sets = 3, repsDisplay = "10 ea. side", restSeconds = 75,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Cable low. Diagonal pull up across body — mimic the follow-through.",
                    fullDescription = """
EQUIPMENT
Cable machine, single handle, pulley set low (at ankle height)

MUSCLES
Obliques, hip flexors, upper back, shoulders — the follow-through muscle chain

HOW TO PERFORM
1. Set the cable pulley low (at ankle height). Stand sideways to the machine, feet shoulder-width apart.
2. Hold the handle with both hands down at the low pulley side. Arms extended toward the floor.
3. Pull the handle diagonally upward across your body — up and across toward your opposite shoulder. Your torso rotates, hips turn, arms finish high.
4. Control the return slowly. Complete all reps, switch sides.

KEY CUES
Same hip-first initiation as the High-to-Low chop. The low-to-high pattern mirrors the follow-through of the golf swing — training the deceleration musculature that protects the shoulder and spine after impact.

WHY IT'S HERE
Trains the follow-through muscle chain. Many golfers have a strong downswing but lack the eccentric strength to control the follow-through safely — this is a primary cause of back and shoulder strain in golfers. This exercise directly addresses that weakness.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e4",
                    name = "Kettlebell Swing",
                    sets = 3, repsDisplay = "12 reps", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Hip hinge + explosive hip snap. NOT a squat. Arms are just ropes.",
                    fullDescription = """
EQUIPMENT
Kettlebell (start with 25–35 lbs for assessment)

MUSCLES
Glutes, hamstrings, hip extensors, core, upper back — explosive hip hinge

HOW TO PERFORM
1. Stand with feet slightly wider than hip-width. Place the kettlebell on the floor about a foot in front of you.
2. Hinge at the hips (like an RDL) to grab the handle with both hands. Before you swing, set your back flat, chest up, hips back.
3. Hike the kettlebell back between your legs like hiking a football — keep it high between your inner thighs.
4. Explosively drive your hips forward by squeezing your glutes and extending your hips. This hip snap — not your arms or shoulders — drives the bell forward and up.
5. Let the bell float to about chest height (or shoulder height for a full Russian swing). Your arms are just ropes attached to the bell.
6. As the bell descends, push your hips back to catch it and transition smoothly into the next rep.

KEY CUES
"Hike it like a football, snap the hips." The swing is a hip hinge exercise — NOT a squat and front raise. Your arms stay relaxed; the glutes do the work. At the top, your body should be in a straight line: ankles, knees, hips, shoulders all stacked.

COMMON MISTAKES
Squatting instead of hinging (the bell drops between your knees rather than between your inner thighs), using the shoulders to raise the bell, letting the lower back round at the bottom, jerking up with the arms.

WHY IT'S HERE
The KB swing is a perfect power tool for golfers — it trains the same explosive hip extension that drives rotational power in the swing. It also conditions the posterior chain significantly and has real cardiovascular demand that builds the golf fitness you need to finish strong on 18.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e5",
                    name = "Rotational Dumbbell Press",
                    sets = 3, repsDisplay = "10 ea. side", restSeconds = 75,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Standing. Drive press from trail hip through lead shoulder.",
                    fullDescription = """
EQUIPMENT
One dumbbell, or cable machine with single handle

MUSCLES
Chest, shoulders, obliques, hip external rotators — rotational press chain

HOW TO PERFORM
1. Stand holding one dumbbell in your right hand at shoulder height, elbow bent. Feet shoulder-width apart.
2. Rotate your hips and torso slightly to the right (load the trail side), then explosively rotate left while pressing the dumbbell forward and slightly across your body at the same time.
3. Your trail hip (right) drives the rotation; your lead shoulder and the dumbbell follow.
4. Return to start under control. Complete all reps, switch hands.

KEY CUES
The press finishes slightly across the midline — mimicking the through-swing path. The power initiates from the hip, not the shoulder. This is a golf-specific movement pattern, not a traditional chest press.

WHY IT'S HERE
This trains the integrated push-rotate pattern that extends from address through impact. It connects hip rotation to the lead arm extension — the precise sequence that generates club speed at the bottom of the swing arc. It also builds the pressing strength that resists the deceleration forces at impact.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e6",
                    name = "Landmine Rotational Press",
                    sets = 3, repsDisplay = "8 ea. side", restSeconds = 90,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Bar in landmine or corner. Arc from hip to overhead — lead with hips.",
                    fullDescription = """
EQUIPMENT
Barbell in a landmine attachment (or wedge one end securely in a corner)

MUSCLES
Obliques, shoulders, chest, core, hips — rotational pressing chain

HOW TO PERFORM
1. Set a barbell in a landmine attachment (or wedge one end securely in a corner).
2. Stand perpendicular to the bar at the loaded end. Hold the end of the bar with both hands (or with the outside hand for a single-arm version).
3. Start with the bar near your outside hip, knees slightly bent, hips loaded (rotated away from the bar).
4. Drive the bar in an arc across your body and up — rotating your hips toward the bar as you press it away from you and upward.
5. Finish with your arms extended overhead and to your opposite side. Return under control.

KEY CUES
The arc of the bar closely mimics the golf swing plane. Lead with the hips, finish with the arms. Keep the core braced throughout — do not let the lower back extend excessively as the bar goes overhead. Enter weight added to the bar (not including bar weight).

COMMON MISTAKES
Pressing with only the arms without hip rotation (loses all the golf-transfer benefit), hyperextending the lower back at the finish.

WHY IT'S HERE
The landmine attachment forces the bar to move along an arc rather than a straight line — that arc closely approximates the club path of a golf swing. This is one of the most direct strength-to-swing-speed transfer exercises available. The fixed pivot point also constrains the movement into a safer path than a free-weight rotational press.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e7",
                    name = "Single-Leg RDL",
                    sets = 3, repsDisplay = "8 ea. side", restSeconds = 60,
                    trackingType = TrackingType.WEIGHT_REPS,
                    notes = "Light weight. Balance is the point — hips square, go slow.",
                    fullDescription = """
EQUIPMENT
Light dumbbells or bodyweight

MUSCLES
Glutes, hamstrings, core stabilizers — golf stance stability

HOW TO PERFORM
1. Stand on your left leg, knee slightly soft (never fully locked). Hold a light dumbbell in your right hand (or no weight for balance practice).
2. Hinge forward at the hip, letting your right leg extend behind you as a counterbalance. Your torso and back leg should form a straight line from head to heel as you lower.
3. Lower until you feel a strong hamstring stretch — your torso should be roughly parallel to the floor at the bottom.
4. Drive through the standing heel to return to upright. Complete all reps, switch legs.

KEY CUES
Keep your hips square — do not let the lifted hip rotate open. Think of having headlights on your hips pointing straight down at the floor throughout. The balance challenge is the point — go slow. Enter weight per dumbbell.

COMMON MISTAKES
Letting the hips rotate open (most common), looking up (extends the neck, which destabilizes the movement), rushing through and losing balance.

WHY IT'S HERE
Every golfer must maintain balance on one leg during the swing — particularly at impact and follow-through. This exercise directly trains that balance and the hip stability required to hold the follow-through position without lateral sway.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d3_e8",
                    name = "Copenhagen Side Plank",
                    sets = 2, repsDisplay = "20 sec ea.", restSeconds = 45,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Top foot on bench. Hold side plank — inner thigh does the work.",
                    fullDescription = """
EQUIPMENT
Flat bench or box

MUSCLES
Hip adductors (inner thigh), core, obliques

HOW TO PERFORM
1. Set up in a side plank position, but instead of your feet stacked on the floor, rest your top foot on a bench — your inner thigh and the top of the bench are the contact point.
2. Lift your hips off the floor into a full side plank. Your body should form a straight diagonal line.
3. Hold for the prescribed time. The inner thigh of the top leg is doing significant work to hold the position.
4. Switch sides.

KEY CUES
Keep your hips square — do not rotate forward or back. Keep the bottom leg either hovering (harder) or resting lightly on the floor (easier). If this variation is too hard, rest the bottom knee on the floor instead.

COMMON MISTAKES
Letting the hips sag or pike, rotating the torso.

WHY IT'S HERE
Hip adductor weakness causes the trail knee to blow outward during the backswing and the lead leg to buckle during the downswing — both kill power and efficiency. Strong adductors also contribute to pelvic stability with the scoliosis, preventing lateral pelvic tilt during loaded movements.
                    """.trimIndent()
                )
            )
        ),

        // ─────────────────────────────────────────────────────────────────
        // DAY 4  —  Conditioning & Mobility
        // ─────────────────────────────────────────────────────────────────
        WorkoutDay(
            id = 4,
            name = "Conditioning & Mobility",
            dayLabel = "Friday or Saturday",
            focus = "Cardiovascular base · thoracic mobility · hip flexibility",
            warmupDuration = "",
            warmupExercises = emptyList(), // Day 4 IS the recovery day — no separate warm-up
            exercises = listOf(
                Exercise(
                    id = "d4_e1",
                    name = "Cardio Block",
                    sets = 1, repsDisplay = "25–30 min", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Choose: incline treadmill walk, elliptical intervals, rower, or brisk walk.",
                    fullDescription = """
EQUIPMENT
Treadmill, elliptical, rowing machine, or outdoor space

OPTIONS
• Incline treadmill walk: 3.5 mph at 8–10% grade — best simulates carrying a bag on the course
• Elliptical intervals: 3 min easy / 1 min hard × 6 rounds
• Rower: 20 min steady state at conversational pace
• Outdoor walk: 45–60 min brisk walk

TARGET HEART RATE
Aim for 60–70% of max HR — approximately 111–129 bpm for age 37. As fitness improves in weeks 4–8, push the hard intervals to 70–80% HR.

CONVERSATIONAL PACE RULE
You should be able to speak in full sentences without gasping. If you can't, slow down.

WHY IT'S HERE
You currently get winded walking 18 holes. Building the cardiovascular base on this day directly addresses that. The incline treadmill is the highest-fidelity simulation of walking a hilly course with a bag — same postural demand, same metabolic cost.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e2",
                    name = "Foam Roll — Thoracic Spine",
                    sets = 1, repsDisplay = "60–90 sec", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Roller perpendicular to mid-back. Hips UP. Pause on stiff spots.",
                    fullDescription = """
EQUIPMENT
Foam roller

TARGET
Thoracic vertebrae (T1–T12), thoracic erectors

HOW TO PERFORM
Place the foam roller perpendicular to your spine at your mid-back (T-spine level — not the lower back). Support your head with both hands. Bridge your hips up slightly and slowly roll up and down through your mid and upper back. When you hit a stiff or tender segment, pause on it and breathe — let gravity extend you over the roller for 5–10 seconds.

KEY CUES
Keep your hips up — do not roll through the lower back (too much lumbar mobility is not the goal). Focus on the area between your shoulder blades and up toward the base of the neck.

WHY IT'S HERE
Thoracic stiffness is the single biggest limiter of both scoliosis management and golf swing rotation. A stiff T-spine forces the lower back and cervical spine to compensate for every rotation you attempt — both problematic given the S-curve. This is the most important mobility tool in the entire program.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e3",
                    name = "Thoracic Extension over Roller",
                    sets = 2, repsDisplay = "60 sec", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Roller behind mid-back. Lower hips to floor. Drape back over roller.",
                    fullDescription = """
EQUIPMENT
Foam roller

TARGET
Thoracic extensors, anterior chest and rib cage

HOW TO PERFORM
Place the foam roller behind your mid-back (same position as the rolling exercise), but this time lower your hips to the floor and allow your upper body to extend backward over the roller — like draping your spine over it. Place your hands behind your head to support your neck. Breathe deeply in this position — with each exhale, let yourself sink a little further into extension. After 30 seconds, shift the roller slightly higher or lower and repeat.

KEY CUES
This is a passive stretch — gravity does the work. Do not force it. With each exhale, let your weight sink you deeper into extension. The thoracic spine should extend, not the lumbar.

WHY IT'S HERE
Direct passive extension of the thoracic spine counteracts the flexed, forward posture associated with C/T scoliosis and desk work. Even 2–3 minutes per week of this makes a measurable difference in extension mobility over months. It also opens the anterior chest and rib cage, improving breathing mechanics and shoulder range of motion.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e4",
                    name = "90/90 Hip Stretch",
                    sets = 2, repsDisplay = "60 sec ea.", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Both legs at 90°. Sit tall. Lean over front shin for deeper stretch.",
                    fullDescription = """
EQUIPMENT
None (floor)

TARGET
Hip external and internal rotators, hip capsule, piriformis

HOW TO PERFORM
Sit on the floor with both legs bent to 90 degrees — one in front (external rotation) and one behind (internal rotation). Sit upright on your sit bones. Hold this position and breathe, letting your hip settle into the stretch. After 45 seconds, lean forward over the front shin for a deeper external rotation stretch. Switch sides.

KEY CUES
Sit upright on your sit bones — do not collapse to one side. The stretch should be felt in the outer hip and glute, not in the knee. If the knee feels strain, support it with a folded towel. Do both sides.

WHY IT'S HERE
This is the most important hip mobility drill for golfers. Restricted hip internal rotation (extremely common in active people) forces the lower back and T-spine to compensate during the backswing and follow-through — directly stressing the already-compromised scoliotic segments. Regular 90/90 work directly prevents this compensation.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e5",
                    name = "Half-Kneeling Hip Flexor Stretch",
                    sets = 2, repsDisplay = "45 sec ea.", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Back knee down, front foot forward. Tuck pelvis — do NOT arch the back.",
                    fullDescription = """
EQUIPMENT
None (floor or thin pad for the knee)

TARGET
Hip flexors (psoas, iliacus, rectus femoris)

HOW TO PERFORM
Take a half-kneeling position — right knee down, left foot forward. Square your hips. Gently push your hips forward until you feel a stretch in the front of the right hip and thigh. Do not arch your lower back — tuck your pelvis slightly under (posterior pelvic tilt) to increase the stretch. Hold 45 seconds per side.

KEY CUES
The posterior pelvic tilt (tucking the pelvis under) is the key — without it, you are arching your lower back instead of stretching the hip flexor. The stretch should be felt in the front of the hip, not the lower back.

WHY IT'S HERE
Tight hip flexors tilt the pelvis anteriorly (forward), which increases lumbar extension and load — particularly problematic for an S-curve scoliosis in the C/T region, where compensation often travels down the kinetic chain. Tight hip flexors also restrict the hip extension at the top of the backswing, limiting rotation.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e6",
                    name = "Thread-the-Needle",
                    sets = 2, repsDisplay = "10 reps ea.", restSeconds = 0,
                    trackingType = TrackingType.BODYWEIGHT,
                    notes = "All fours. Slide one arm under body along the floor. Follow with eyes.",
                    fullDescription = """
EQUIPMENT
None (floor)

TARGET
Thoracic rotators, posterior shoulder, obliques

HOW TO PERFORM
Start on all fours. Slide your right arm under your body and along the floor to the left, letting your right shoulder and ear touch the floor as you rotate through the thoracic spine. Hold 2–3 seconds, return, and repeat. Do all reps on one side, then switch.

KEY CUES
Follow your arm with your eyes and head — thoracic rotation should happen, not just shoulder movement. Aim for maximal range. Pause at the end range and breathe before returning.

WHY IT'S HERE
Directly mobilizes thoracic rotation in a loaded (gravity-assisted) and controlled position. Essential for maintaining the thoracic ROM that keeps your golf swing rotation coming from the right place — the T-spine — rather than the lumbar spine or SI joint.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e7",
                    name = "Lat Stretch",
                    sets = 2, repsDisplay = "30 sec ea.", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Grip rack at hip height. Sit hips back and down. Rotate hips away.",
                    fullDescription = """
EQUIPMENT
Doorframe, squat rack upright, or cable tower

TARGET
Latissimus dorsi, thoracolumbar fascia

HOW TO PERFORM
Grab an upright with one hand at about hip height. Walk your feet back and squat your hips back and down, letting your arm stretch overhead and your spine lengthen. Rotate your hips slightly away from the arm being stretched to increase the lat bias. Hold 30 seconds each side.

KEY CUES
Allow the arm to stretch fully overhead as your hips sink back. The rotation of the hips away from the stretched side is what isolates the lat — without it, you get a general spine stretch but less lat lengthening.

WHY IT'S HERE
Tight lats internally rotate the shoulder and compress the thoracic spine — both accelerate scoliotic postural patterns and restrict the top-of-backswing position. This stretch directly addresses thoracic decompression and lead shoulder mobility going into the backswing.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e8",
                    name = "Banded Shoulder External Rotation",
                    sets = 2, repsDisplay = "15 ea.", restSeconds = 0,
                    trackingType = TrackingType.BODYWEIGHT,
                    notes = "Elbows pinned to sides. Rotate forearms outward. Light burn in back of shoulder.",
                    fullDescription = """
EQUIPMENT
Light resistance band

TARGET
Infraspinatus, teres minor (posterior rotator cuff)

HOW TO PERFORM
Hold a resistance band in both hands with elbows bent to 90 degrees and tucked at your sides. Pull the band apart by rotating your hands outward — your forearms rotate away from each other while your elbows stay pinned to your sides. Return slowly. This should feel like a low-load burn in the back of the shoulder.

KEY CUES
Elbows stay tucked at your sides — do not let them flare. Rotate the forearms only — the upper arm should not move. You should feel this specifically in the back of the shoulder, between the shoulder blade and the upper arm.

WHY IT'S HERE
External rotation strength protects the rotator cuff from the repetitive stress of the golf swing and is commonly weak in people with forward-rounded posture from upper-spine scoliosis. This is a maintenance exercise for the shoulder health that lets you keep swinging for decades.
                    """.trimIndent()
                ),
                Exercise(
                    id = "d4_e9",
                    name = "Child's Pose — Lateral Reach",
                    sets = 2, repsDisplay = "30 sec ea. side", restSeconds = 0,
                    trackingType = TrackingType.TIME_BASED,
                    notes = "Standard child's pose, then walk arms to each side. Pull opposite hip back.",
                    fullDescription = """
EQUIPMENT
None (floor)

TARGET
Lats, thoracic spine, hip flexors

HOW TO PERFORM
Begin in a standard child's pose — hips back toward heels, arms extended forward on the floor. Once settled, walk both arms to the right, pulling your left hip further back to deepen the left lat stretch. Hold 30 seconds, then walk your arms to the left and repeat.

KEY CUES
As you walk your arms to one side, actively pull the opposite hip back toward the floor. This creates a diagonal traction line through the lat and thoracic spine on that side.

WHY IT'S HERE
Combines lat decompression, thoracic opening, and hip flexor release in one position — efficient for a conditioning/mobility day and excellent for spinal recovery after the power and strength sessions earlier in the week. A great way to finish the week.
                    """.trimIndent()
                )
            )
        )
    )

    fun dayById(id: Int): WorkoutDay? = days.firstOrNull { it.id == id }
}
