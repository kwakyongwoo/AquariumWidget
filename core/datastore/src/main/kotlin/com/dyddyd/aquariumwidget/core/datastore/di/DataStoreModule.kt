package com.dyddyd.aquariumwidget.core.datastore.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import androidx.datastore.dataStoreFile
import com.dyddyd.aquariumwidget.core.datastore.UserPreferences
import com.dyddyd.aquariumwidget.core.datastore.UserPreferencesSerializer
import com.dyddyd.aquariumwidget.core.network.Dispatcher
import com.dyddyd.aquariumwidget.core.network.di.ApplicationScope
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton
import com.dyddyd.aquariumwidget.core.network.AquariumDispatchers.IO
import kotlinx.coroutines.CoroutineScope

@Module
@InstallIn(Singleton::class)
object DataStoreModule {

    @Provides
    @Singleton
    internal fun providesUserPreferencesDataStore(
        @ApplicationScope context: Context,
        @Dispatcher(IO) ioDispatcher: CoroutineDispatcher,
        @ApplicationScope scope: CoroutineScope,
        userPreferencesSerializer: UserPreferencesSerializer,
    ): DataStore<UserPreferences> =
        DataStoreFactory.create(
            serializer = userPreferencesSerializer,
            scope = CoroutineScope(scope.coroutineContext + ioDispatcher),
        ) {
            context.dataStoreFile("user_preferences.pb")
        }
    }
