package com.mrfatworm.goodnightforest

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.compose.rememberNavController
import com.mrfatworm.goodnightforest.ui.navigaiton.GnfNavActions
import com.mrfatworm.goodnightforest.ui.navigaiton.GnfNavGraph
import com.mrfatworm.goodnightforest.ui.theme.AppTheme

@Composable
internal fun App() = AppTheme {
    val navController = rememberNavController()
    val navActions = remember(GnfNavActions(navController)) {
        GnfNavActions(navController)
    }

    GnfNavGraph(navController = navController, navActions)

}
