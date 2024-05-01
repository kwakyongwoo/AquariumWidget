package com.dyddyd.aquariumwidget.feature.home

import androidx.lifecycle.ViewModel
import com.dyddyd.aquariumwidget.core.data.repository.AquariumRepository
import com.dyddyd.aquariumwidget.core.data.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val userRepository: UserRepository,
    private val aquariumRepository: AquariumRepository,
): ViewModel() {

}