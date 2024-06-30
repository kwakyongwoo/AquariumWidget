package com.dydyd.aquariumwidget.feature.fishing

import com.dyddyd.aquariumwidget.core.model.data.Habitat
import com.dyddyd.aquariumwidget.core.model.data.Rod

sealed interface FishingUiState {

    data object Loading : FishingUiState

    data object Error : FishingUiState

    data class Success(
        val habitat: Habitat,
        val rod: Rod,
        val chance: Int
    ) : FishingUiState
}