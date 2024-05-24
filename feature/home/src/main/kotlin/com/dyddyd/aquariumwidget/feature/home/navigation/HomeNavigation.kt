package com.dyddyd.aquariumwidget.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.dyddyd.aquariumwidget.feature.home.HomeRoute

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome() = navigate(HOME_ROUTE, navOptions {
    launchSingleTop = true
    anim {
        enter = 0
        exit = 0
        popEnter = 0
        popExit = 0
    }
})

fun NavGraphBuilder.homeScreen() {
    composable(route = HOME_ROUTE) {
        HomeRoute()
    }
}