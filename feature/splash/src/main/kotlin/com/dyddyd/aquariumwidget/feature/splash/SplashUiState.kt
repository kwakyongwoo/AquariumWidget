package com.dyddyd.aquariumwidget.feature.splash

sealed interface SplashUiState {

    data object Loading : SplashUiState

    data object LoadFailed : SplashUiState

    data object Success : SplashUiState
}