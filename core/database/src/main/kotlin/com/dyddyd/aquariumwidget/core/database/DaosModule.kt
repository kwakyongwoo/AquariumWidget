package com.dyddyd.aquariumwidget.core.database

import com.dyddyd.aquariumwidget.core.database.dao.FishDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
internal object DaosModule {

    @Provides
    fun provideFishDao(
        database: AquariumDatabase
    ): FishDao = database.fishDao()
}