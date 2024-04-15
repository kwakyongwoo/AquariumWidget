package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.model.Parts
import kotlinx.coroutines.flow.Flow

interface PartsRepository {

    suspend fun collectPart(userId: Int, partId: Int)

    fun getAllParts(): Flow<List<Parts>>

    fun getAllCollectedParts(userId: Int): Flow<List<Parts>>
}