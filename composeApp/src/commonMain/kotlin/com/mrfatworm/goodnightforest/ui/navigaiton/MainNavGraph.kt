/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.navigaiton

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mrfatworm.goodnightforest.home.HomeScreen
import com.mrfatworm.goodnightforest.profile.ProfileScreen
import com.mrfatworm.goodnightforest.sleepreport.SleepReportScreen
import com.mrfatworm.goodnightforest.ui.component.GnfBottomNavigation
import com.mrfatworm.goodnightforest.healthroom.HealthRoomScreen as HealthRoomScreen1

@Composable
fun MainNavGraph(
    rootNavActions: GnfNavActions
) {
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedDestination = navBackStackEntry?.destination?.route ?: Screen.Home.route
    val navActions = remember(GnfNavActions(navController)) {
        GnfNavActions(navController)
    }

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        NavHost(
            navController = navController,
            route = Screen.MainFlow.route,
            startDestination = Screen.Home.route
        ) {
            composable(Screen.Home.route) {
                HomeScreen(onExploreCompanionClick = { rootNavActions.navigationTo(Screen.CompanionBanner) },
                    onSleepNowClick = { rootNavActions.navigationTo(Screen.SleepStandby) })
            }
            composable(Screen.SleepReport.route) {
                SleepReportScreen()
            }
            composable(Screen.HealthRoom.route) {
                HealthRoomScreen1()
            }
            composable(Screen.Profile.route) {
                ProfileScreen()
            }
        }
        GnfBottomNavigation(
            modifier = Modifier.align(Alignment.BottomCenter),
            selectedDestination = selectedDestination,
            navActions = navActions
        )
    }
}