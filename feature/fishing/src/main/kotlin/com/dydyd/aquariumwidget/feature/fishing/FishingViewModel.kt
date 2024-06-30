package com.dydyd.aquariumwidget.feature.fishing

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyddyd.aquariumwidget.core.data.repository.FishRepository
import com.dyddyd.aquariumwidget.core.data.repository.HabitatRepository
import com.dyddyd.aquariumwidget.core.data.repository.RodRepository
import com.dyddyd.aquariumwidget.core.data.repository.UserRepository
import com.dyddyd.aquariumwidget.core.model.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FishingViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val fishRepository: FishRepository,
    private val habitatRepository: HabitatRepository,
    private val rodRepository: RodRepository,
) : ViewModel() {

    private val userId: Flow<Int> = userRepository.getUserId()

    private val userInfo: Flow<User> = userId.flatMapLatest { userId ->
        userRepository.getUserInfo(userId)
    }

    val fishingUiState: StateFlow<FishingUiState> = userInfo.flatMapLatest { user ->
        combine(
            habitatRepository.getHabitatInfo(user.curHabitat),
            rodRepository.getMatchedRod(user.curHabitat)
        ) { habitat, rod ->
            if (rod == null) {
                FishingUiState.Error
            }
            else {
                FishingUiState.Success(
                    habitat = habitat,
                    rod = rod,
                    chance = user.chance
                )
            }
        }
    }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5_000),
            initialValue = FishingUiState.Loading,
        )

    fun decreaseChance() {
        viewModelScope.launch {
            userRepository.decreaseGameChanceCount(userId.first())
        }
    }

    fun resetChance() {
        viewModelScope.launch {
            userRepository.resetGameChanceCount(userId.first())
        }
    }
}