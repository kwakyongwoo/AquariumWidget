package com.dyddyd.aquariumwidget.core.network.di

import com.dyddyd.aquariumwidget.core.network.Dispatcher
import com.dyddyd.aquariumwidget.core.network.AquariumDispatchers.IO
import com.dyddyd.aquariumwidget.core.network.AquariumDispatchers.Default
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
object DispatchersModule {
    @Provides
    @Dispatcher(IO)
    fun providesIODispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @Dispatcher(Default)
    fun providesDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default
}
