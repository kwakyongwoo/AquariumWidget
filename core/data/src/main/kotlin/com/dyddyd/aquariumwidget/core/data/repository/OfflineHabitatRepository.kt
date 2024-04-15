package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.HabitatDao
import com.dyddyd.aquariumwidget.core.database.model.Habitat
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflineHabitatRepository @Inject constructor(
    private val habitatDao: HabitatDao,
): HabitatRepository {
    override fun getAllCollectedHabitats(userId: Int): Flow<List<Habitat>> =
        habitatDao.getAllCollectedHabitats(userId)

    override fun getAllHabitats(): Flow<List<Habitat>> =
        habitatDao.getAllHabitats()

    override fun getHabitatInfo(habitatId: Int): Flow<Habitat> =
        habitatDao.getHabitatInfo(habitatId)
}