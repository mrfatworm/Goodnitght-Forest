/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.navigaiton

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mrfatworm.goodnightforest.companion.CompanionBannerScreen
import com.mrfatworm.goodnightforest.sign.SignInScreen

@Composable
fun GnfNavGraph(
    navController: NavHostController, navActions: GnfNavActions
) {
    NavHost(navController = navController,
        startDestination = Screen.SignIn.route,
        enterTransition = {
            slideIntoContainer(
                AnimatedContentTransitionScope.SlideDirection.Start, tween(500)
            )
        },
        exitTransition = {
            slideOutOfContainer(
                AnimatedContentTransitionScope.SlideDirection.End, tween(500)
            )
        }) {
        composable(route = Screen.SignIn.route) {
            SignInScreen(onSignInClick = {
                navActions.navigationToTop(Screen.MainFlow)
            })
        }

        composable(route = Screen.MainFlow.route) {
            MainNavGraph(rootNavActions = navActions)
        }

        composable(route = Screen.CompanionBanner.route) {
            CompanionBannerScreen(onBackClick = navController::popBackStack)
        }
    }
}