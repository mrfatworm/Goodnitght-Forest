/*
 * Copyright 2024 The Goodnight Forest Open Source Project by mrfatworm
 * License: CC BY-NC-SA 4.0
 */

package com.mrfatworm.goodnightforest.ui.navigaiton

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

class GnfNavActions(private val navController: NavHostController) {

    fun navigationToTopAndSave(destination: Screen) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().route?: "Home") {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }

    fun navigationToTop(destination: Screen) {
        navController.navigate(destination.route) {
            popUpTo(navController.graph.findStartDestination().route?: "Home") {
                inclusive = true
            }
        }
    }

//    fun navigationAndClearBackStack(destination: Screen) {
//        navController.navigate(destination.route) {
//            popUpTo(0)
//        }
//    }
}