package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.database.model.Aquarium
import kotlinx.coroutines.flow.Flow

interface AquariumRepository {

    fun getAllCollectedAquariums(userId: Int): Flow<List<Aquarium>>

    fun getMatchedAquarium(habitatId: Int): Flow<Aquarium?>
}