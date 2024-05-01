package com.dyddyd.aquariumwidget

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dyddyd.aquariumwidget.core.database.dao.FishDao
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestViewModel @Inject constructor(
    private val fishDao: FishDao
) : ViewModel() {

    fun getAllFish() = viewModelScope.launch {
        fishDao.getAllFish().first().forEach {
            println(it)
        }
    }
}