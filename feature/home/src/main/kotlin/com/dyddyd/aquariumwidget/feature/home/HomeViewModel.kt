package com.dyddyd.aquariumwidget.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyddyd.aquariumwidget.core.data.repository.AquariumRepository
import com.dyddyd.aquariumwidget.core.data.repository.FishRepository
import com.dyddyd.aquariumwidget.core.data.repository.UserRepository
import com.dyddyd.aquariumwidget.core.model.data.User
import com.dyddyd.aquariumwidget.core.ui.FishUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val aquariumRepository: AquariumRepository,
    private val fishRepository: FishRepository,
) : ViewModel() {

    private val userId: Flow<Int> = userRepository.getUserId()

    private val userInfo: Flow<User> = userId.flatMapLatest { userId ->
        userRepository.getUserInfo(userId)
    }

    val fishUiState: StateFlow<FishUiState> =
        userInfo.flatMapLatest { user ->
            fishRepository.getAllFishInAquarium(user.userId, user.selectedAquariumThemeId ?: 1)
        }
            .map(FishUiState::Success)
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5_000),
                initialValue = FishUiState.Loading,
            )
}