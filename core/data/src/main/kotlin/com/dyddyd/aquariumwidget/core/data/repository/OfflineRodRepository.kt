package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.RodDao
import com.dyddyd.aquariumwidget.core.database.model.Rod
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflineRodRepository @Inject constructor(
    private val rodDao: RodDao,
): RodRepository {
    override suspend fun collectRod(userId: Int, rodId: Int) {
        rodDao.collectRod(userId, rodId)
    }

    override fun getAllRods(): Flow<List<Rod>> =
        rodDao.getAllRods()

    override fun getAllCollectedRods(userId: Int): Flow<List<Rod>> =
        rodDao.getAllCollectedRods(userId)

    override fun getMatchedRod(habitatId: Int): Flow<Rod?> =
        rodDao.getMatchedRod(habitatId)
}