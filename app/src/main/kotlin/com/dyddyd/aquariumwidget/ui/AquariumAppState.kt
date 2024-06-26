package com.dyddyd.aquariumwidget.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.dyddyd.aquariumwidget.feature.home.navigation.HOME_ROUTE
import com.dyddyd.aquariumwidget.feature.splash.navigation.SPLASH_ROUTE
import com.dyddyd.aquariumwidget.navigation.TopLevelDestination.SPLASH
import com.dyddyd.aquariumwidget.navigation.TopLevelDestination.HOME
import com.dyddyd.aquariumwidget.navigation.TopLevelDestination
import kotlinx.coroutines.CoroutineScope

@Composable
fun rememberAquariumAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController(),
): AquariumAppState {
    return remember(
        navController,
        coroutineScope,
    ) {
        AquariumAppState(
            navController,
            coroutineScope,
        )
    }
}

@Stable
class AquariumAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {
    val currentDestination: NavDestination?
        @Composable get() = navController.currentBackStackEntryAsState().value?.destination

    val currentTopLevelDestination: TopLevelDestination?
        @Composable get() = when (currentDestination?.route) {
            SPLASH_ROUTE -> SPLASH
            HOME_ROUTE -> HOME
            else -> null
        }

    val topLevelDestinations: List<TopLevelDestination> = TopLevelDestination.entries
}