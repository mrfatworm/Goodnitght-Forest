/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.component.data

import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.bg_lumina
import org.jetbrains.compose.resources.DrawableResource


data class LessonPagerState(
    val lessonPagers: List<LessonPager>
)

data class LessonPager(
    val imageRes: DrawableResource, val title: String
)

val sampleLessonPager = LessonPagerState(
    listOf(
        LessonPager(
            Res.drawable.bg_lumina, "第1章-靜心初探"
        ),
        LessonPager(
            Res.drawable.bg_lumina, "第2章-呼吸與專注"
        ),
        LessonPager(
            Res.drawable.bg_lumina, "第3章-身心連結"
        ),
        LessonPager(
            Res.drawable.bg_lumina, "第4章-情緒管理"
        ),
        LessonPager(
            Res.drawable.bg_lumina, "第5章-深層放鬆"
        ),
    )
)