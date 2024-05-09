package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.model.data.Fish
import kotlinx.coroutines.flow.Flow

interface FishRepository {

    suspend fun catchFish(userId: Int, fishId: Int, rodId: Int)

    fun getAllFish(): Flow<List<Fish>>

    fun getAllCollectFish(): Flow<List<Fish>>

    suspend fun addFishToAquarium(userId: Int, aquariumId: Int, fishId: Int)

    suspend fun removeFishFromAquarium(userId: Int, aquariumId: Int, fishId: Int)

    fun getAllFishInAquarium(userId: Int, aquariumId: Int): Flow<List<Fish>>

    fun getCollectedFish(userId: Int, fishId: Int): Flow<List<Fish>>

    fun getAllCollectedFishByRarity(userId: Int, rarity: String): Flow<List<Fish>>

    fun getAllCollectedFishWithoutDuplication(userId: Int): Flow<List<Fish>>
}