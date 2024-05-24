package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.model.data.User
import kotlinx.coroutines.flow.Flow

// Room User Table Repository, not datastore
interface UserRepository {

    fun getUserId(): Flow<Int>

    fun getUserInfo(userId: Int): Flow<User>

    suspend fun decreaseGameChanceCount(userId: Int)

    suspend fun resetGameChanceCount(userId: Int)

    suspend fun changeAquariumTheme(userId: Int, aquariumId: Int)

    /**
     * check getMaxHabitat()
     * clearCurrentHabitat()
     */
    fun clearCurrentHabitat(userId: Int, habitatId: Int): Flow<Boolean>

    suspend fun updateLastPlayedDate(curDate: Int, userId: Int)
}