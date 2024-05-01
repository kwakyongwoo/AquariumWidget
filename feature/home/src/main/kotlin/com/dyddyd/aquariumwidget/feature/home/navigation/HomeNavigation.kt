package com.dyddyd.aquariumwidget.feature.home.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dyddyd.aquariumwidget.feature.home.HomeRoute
import com.dyddyd.aquariumwidget.feature.home.HomeScreen

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome() = navigate(HOME_ROUTE)

fun NavGraphBuilder.homeScreen() {
    composable(route = HOME_ROUTE) {
        HomeRoute()
    }
}