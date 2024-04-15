package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.dao.AquariumDao
import com.dyddyd.aquariumwidget.core.database.model.Aquarium
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class OfflineAquariumRepository @Inject constructor(
    private val aquariumDao: AquariumDao,
): AquariumRepository {
    override fun getAllCollectedAquariums(userId: Int): Flow<List<Aquarium>> =
        aquariumDao.getAllCollectedAquariums(userId)

    override fun getMatchedAquarium(habitatId: Int): Flow<Aquarium?> =
        aquariumDao.getMatchedAquarium(habitatId)

}