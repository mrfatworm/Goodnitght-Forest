package com.mrfatworm.goodnightforest.ui.component.data

import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.de_stress_meditation
import goodnitght_forest.composeapp.generated.resources.ic_de_stress_meditation
import goodnitght_forest.composeapp.generated.resources.ic_relax_breath
import goodnitght_forest.composeapp.generated.resources.ic_relax_music
import goodnitght_forest.composeapp.generated.resources.ic_sleep_story
import goodnitght_forest.composeapp.generated.resources.ic_white_noise
import goodnitght_forest.composeapp.generated.resources.relax_breath
import goodnitght_forest.composeapp.generated.resources.relax_music
import goodnitght_forest.composeapp.generated.resources.sleep_story
import goodnitght_forest.composeapp.generated.resources.white_noise
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

data class LessonListItemState(
    val iconRes: DrawableResource, val textRes: StringResource
)

private val lessonRelaxMusic = LessonListItemState(Res.drawable.ic_relax_music, Res.string.relax_music)
private val lessonDeStressMeditation = LessonListItemState(Res.drawable.ic_de_stress_meditation, Res.string.de_stress_meditation)
private val lessonRelaxBreath = LessonListItemState(Res.drawable.ic_relax_breath, Res.string.relax_breath)
private val lessonSleepStory = LessonListItemState(Res.drawable.ic_sleep_story, Res.string.sleep_story)
private val lessonWhiteNoise = LessonListItemState(Res.drawable.ic_white_noise, Res.string.white_noise)

val lessonList = listOf(
    lessonRelaxMusic,
    lessonDeStressMeditation,
    lessonRelaxBreath,
    lessonSleepStory,
    lessonWhiteNoise
)