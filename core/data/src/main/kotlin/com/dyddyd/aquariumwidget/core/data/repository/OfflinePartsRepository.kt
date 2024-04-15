package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.PartsDao
import com.dyddyd.aquariumwidget.core.database.model.Parts
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflinePartsRepository @Inject constructor(
    private val partsDao: PartsDao,
): PartsRepository {
    override suspend fun collectPart(userId: Int, partId: Int) {
        partsDao.collectParts(userId, partId)
    }

    override fun getAllParts(): Flow<List<Parts>> =
        partsDao.getAllParts()

    override fun getAllCollectedParts(userId: Int): Flow<List<Parts>> =
        partsDao.getAllCollectedParts(userId)
}