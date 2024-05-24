package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.RodDao
import com.dyddyd.aquariumwidget.core.database.model.RodEntity
import com.dyddyd.aquariumwidget.core.database.model.asExternalModel
import com.dyddyd.aquariumwidget.core.model.data.Rod
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OfflineRodRepository @Inject constructor(
    private val rodDao: RodDao,
): RodRepository {
    override suspend fun collectRod(userId: Int, rodId: Int) {
        rodDao.collectRod(userId, rodId)
    }

    override fun getAllRods(): Flow<List<Rod>> =
        rodDao.getAllRods()
            .map { it.map(RodEntity::asExternalModel) }

    override fun getAllCollectedRods(userId: Int): Flow<List<Rod>> =
        rodDao.getAllCollectedRods(userId)
            .map { it.map(RodEntity::asExternalModel) }

    override fun getMatchedRod(habitatId: Int): Flow<Rod?> =
        rodDao.getMatchedRod(habitatId)
            .map { it?.asExternalModel() }
}