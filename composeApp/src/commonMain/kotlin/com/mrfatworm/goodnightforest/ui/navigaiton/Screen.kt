/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.navigaiton

import androidx.navigation.NamedNavArgument
import goodnitght_forest.composeapp.generated.resources.Res
import goodnitght_forest.composeapp.generated.resources.home
import goodnitght_forest.composeapp.generated.resources.ic_health_room
import goodnitght_forest.composeapp.generated.resources.ic_health_room_filled
import goodnitght_forest.composeapp.generated.resources.ic_home
import goodnitght_forest.composeapp.generated.resources.ic_home_filled
import goodnitght_forest.composeapp.generated.resources.ic_profile
import goodnitght_forest.composeapp.generated.resources.ic_profile_filled
import goodnitght_forest.composeapp.generated.resources.ic_report
import goodnitght_forest.composeapp.generated.resources.ic_report_filled
import goodnitght_forest.composeapp.generated.resources.profile
import goodnitght_forest.composeapp.generated.resources.sleep_health_room
import goodnitght_forest.composeapp.generated.resources.sleep_report
import org.jetbrains.compose.resources.DrawableResource
import org.jetbrains.compose.resources.StringResource

sealed class Screen(
    val route: String,
    val textRes: StringResource? = null,
    val iconDefaultRes: DrawableResource? = null,
    val iconSelectedRes: DrawableResource? = null,
    val navArgs: List<NamedNavArgument> = emptyList()
) {
    data object SignIn : Screen("sign_in")
    data object MainFlow : Screen("main_flow")
    data object Home : Screen("home", Res.string.home, Res.drawable.ic_home, Res.drawable.ic_home_filled)
    data object SleepReport : Screen("report", Res.string.sleep_report, Res.drawable.ic_report, Res.drawable.ic_report_filled)
    data object HealthRoom : Screen("health_room", Res.string.sleep_health_room, Res.drawable.ic_health_room, Res.drawable.ic_health_room_filled)
    data object Profile : Screen("profile", Res.string.profile, Res.drawable.ic_profile, Res.drawable.ic_profile_filled)
}

val BottomScreens = listOf(
    Screen.Home, Screen.SleepReport, Screen.HealthRoom, Screen.Profile
)