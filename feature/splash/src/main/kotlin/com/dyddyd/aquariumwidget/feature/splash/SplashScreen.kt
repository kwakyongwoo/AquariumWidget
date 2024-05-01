package com.dyddyd.aquariumwidget.feature.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
internal fun SplashRoute(
    navigateToHome: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: SplashViewModel = hiltViewModel(),
) {
    val splashUiState by viewModel.splashUiState.collectAsStateWithLifecycle()

    SplashScreen(
        modifier = modifier,
        splashUiState = splashUiState,
        navigateToHome = navigateToHome,
    )
}

@Composable
internal fun SplashScreen(
    modifier: Modifier = Modifier,
    splashUiState: SplashUiState,
    navigateToHome: () -> Unit,
) {

    when (splashUiState) {
        SplashUiState.Loading -> {
            Box(
                modifier = modifier
                    .fillMaxSize()
            ) {
                Image(
                    painter = painterResource(id = R.drawable.splash_background),
                    contentDescription = "Splash Screen",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize(),
                )
            }
        }
        SplashUiState.Success -> {
            navigateToHome()
        }
        SplashUiState.LoadFailed -> {

        }
    }

}