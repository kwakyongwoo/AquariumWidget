package com.dyddyd.aquariumwidget.navigation

import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.dyddyd.aquariumwidget.feature.home.navigation.homeScreen
import com.dyddyd.aquariumwidget.feature.home.navigation.navigateToHome
import com.dyddyd.aquariumwidget.feature.splash.navigation.SPLASH_ROUTE
import com.dyddyd.aquariumwidget.feature.splash.navigation.splashScreen
import com.dyddyd.aquariumwidget.ui.AquariumAppState
import com.dydyd.aquariumwidget.feature.fishing.navigation.fishingScreen
import com.dydyd.aquariumwidget.feature.fishing.navigation.navigateToFishing

@Composable
fun AquariumNavHost(
    appState: AquariumAppState,
    modifier: Modifier = Modifier,
    startDestination: String = SPLASH_ROUTE,
) {
    val navController = appState.navController

    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
        enterTransition = { EnterTransition.None },
        exitTransition = { ExitTransition.None },
        popEnterTransition = { EnterTransition.None },
        popExitTransition = { ExitTransition.None },
    ) {
        splashScreen(navController::navigateToHome)
        homeScreen(navController::navigateToFishing)
        fishingScreen()
    }
}