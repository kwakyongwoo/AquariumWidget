package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.model.data.Parts
import kotlinx.coroutines.flow.Flow

interface PartsRepository {

    suspend fun collectPart(userId: Int, partId: Int)

    fun getAllParts(): Flow<List<Parts>>

    fun getAllCollectedParts(userId: Int): Flow<List<Parts>>
}