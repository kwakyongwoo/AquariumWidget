package com.dyddyd.aquariumwidget.feature.home.navigation

import androidx.compose.animation.core.tween
import androidx.compose.animation.slideOutHorizontally
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navOptions
import com.dyddyd.aquariumwidget.feature.home.HomeRoute

const val HOME_ROUTE = "home_route"

fun NavController.navigateToHome() = navigate(HOME_ROUTE, navOptions {
    launchSingleTop = true
})

fun NavGraphBuilder.homeScreen(
    onGoFishingClick: () -> Unit,
) {
    composable(
        route = HOME_ROUTE,
        exitTransition = {
            slideOutHorizontally(
                targetOffsetX = { 1000 },
                animationSpec = tween(400)
            )
        }
    ) {
        HomeRoute(onGoFishingClick = onGoFishingClick)
    }
}