/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.companion.data

import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.banner_lumina
import org.jetbrains.compose.resources.DrawableResource


data class CompanionCard(
    val imageRes: DrawableResource,
    val name: String,
    val tag: String,
    val time: Int,
    val desc: String,
)

val companionLumina = CompanionCard(
    Res.drawable.banner_lumina,
    "露米娜",
    "冥想夥伴",
    35,
    "露米娜是一位引導冥想的獨角獸導師，用光輝與智慧帶領大家進入平靜和諧的境界"
)
