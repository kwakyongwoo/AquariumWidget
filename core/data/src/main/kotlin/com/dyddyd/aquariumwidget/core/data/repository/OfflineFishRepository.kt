package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.FishDao
import com.dyddyd.aquariumwidget.core.database.model.FishEntity
import com.dyddyd.aquariumwidget.core.database.model.asExternalModel
import com.dyddyd.aquariumwidget.core.model.data.Fish
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OfflineFishRepository @Inject constructor(
    private val fishDao: FishDao,
): FishRepository {
    override suspend fun catchFish(userId: Int, fishId: Int, rodId: Int) {
        fishDao.catchFish(userId, fishId, rodId)
    }

    override fun getAllFish(): Flow<List<Fish>> =
        fishDao.getAllFish()
            .map { it.map(FishEntity::asExternalModel) }

    override fun getAllCollectFish(): Flow<List<Fish>> =
        fishDao.getAllCollectFish()
            .map { it.map(FishEntity::asExternalModel) }

    override suspend fun addFishToAquarium(userId: Int, aquariumId: Int, fishId: Int) {
        fishDao.addFishToAquarium(userId, aquariumId, fishId)
    }

    override suspend fun removeFishFromAquarium(userId: Int, aquariumId: Int, fishId: Int) {
        fishDao.removeFishFromAquarium(userId, aquariumId, fishId)
    }

    override fun getAllFishInAquarium(userId: Int, aquariumId: Int): Flow<List<Fish>> =
        fishDao.getAllFishInAquarium(userId, aquariumId)
            .map { it.map(FishEntity::asExternalModel) }

    override fun getCollectedFish(userId: Int, fishId: Int): Flow<List<Fish>> =
        fishDao.getCollectedFish(userId, fishId)
            .map { it.map(FishEntity::asExternalModel) }

    override fun getAllCollectedFishByRarity(userId: Int, rarity: String): Flow<List<Fish>> =
        fishDao.getAllCollectedFishByRarity(userId, rarity)
            .map { it.map(FishEntity::asExternalModel) }

    override fun getAllCollectedFishWithoutDuplication(userId: Int): Flow<List<Fish>> =
        fishDao.getAllCollectedFishWithoutDuplication(userId)
            .map { it.map(FishEntity::asExternalModel) }

}