package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.FishDao
import com.dyddyd.aquariumwidget.core.database.model.Fish
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflineFishRepository @Inject constructor(
    private val fishDao: FishDao,
): FishRepository {
    override suspend fun catchFish(userId: Int, fishId: Int, rodId: Int) {
        fishDao.catchFish(userId, fishId, rodId)
    }

    override fun getAllFish(): Flow<List<Fish>> =
        fishDao.getAllFish()

    override fun getAllCollectFish(): Flow<List<Fish>> =
        fishDao.getAllCollectFish()

    override suspend fun addFishToAquarium(userId: Int, aquariumId: Int, fishId: Int) {
        fishDao.addFishToAquarium(userId, aquariumId, fishId)
    }

    override suspend fun removeFishFromAquarium(userId: Int, aquariumId: Int, fishId: Int) {
        fishDao.removeFishFromAquarium(userId, aquariumId, fishId)
    }

    override fun getAllFishInAquarium(userId: Int, aquariumId: Int): Flow<List<Fish>> =
        fishDao.getAllFishInAquarium(userId, aquariumId)

    override fun getCollectedFish(userId: Int, fishId: Int): Flow<List<Fish>> =
        fishDao.getCollectedFish(userId, fishId)

    override fun getAllCollectedFishByRarity(userId: Int, rarity: String): Flow<List<Fish>> =
        fishDao.getAllCollectedFishByRarity(userId, rarity)

    override fun getAllCollectedFishWithoutDuplication(userId: Int): Flow<List<Fish>> =
        fishDao.getAllCollectedFishWithoutDuplication(userId)

}