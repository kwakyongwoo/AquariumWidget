package com.dydyd.aquariumwidget.feature.fishing.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.dydyd.aquariumwidget.feature.fishing.FishingRoute

const val FISHING_ROUTE = "fishing_route"

fun NavController.navigateToFishing() = navigate(FISHING_ROUTE)

fun NavGraphBuilder.fishingScreen() {
    composable(route = FISHING_ROUTE) {
        FishingRoute()
    }
}