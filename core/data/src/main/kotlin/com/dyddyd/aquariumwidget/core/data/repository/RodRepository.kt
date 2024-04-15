package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.model.Rod
import kotlinx.coroutines.flow.Flow

interface RodRepository {

    suspend fun collectRod(userId: Int, rodId: Int)

    fun getAllRods(): Flow<List<Rod>>

    fun getAllCollectedRods(userId: Int): Flow<List<Rod>>

    fun getMatchedRod(habitatId: Int): Flow<Rod?>
}