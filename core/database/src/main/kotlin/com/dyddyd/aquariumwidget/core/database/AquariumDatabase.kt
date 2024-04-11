package com.dyddyd.aquariumwidget.core.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.dyddyd.aquariumwidget.core.database.dao.FishDao
import com.dyddyd.aquariumwidget.core.database.model.Aquarium
import com.dyddyd.aquariumwidget.core.database.model.Catch
import com.dyddyd.aquariumwidget.core.database.model.Clear
import com.dyddyd.aquariumwidget.core.database.model.CollectRod
import com.dyddyd.aquariumwidget.core.database.model.Contain
import com.dyddyd.aquariumwidget.core.database.model.Fish
import com.dyddyd.aquariumwidget.core.database.model.Habitat
import com.dyddyd.aquariumwidget.core.database.model.Match
import com.dyddyd.aquariumwidget.core.database.model.Parts
import com.dyddyd.aquariumwidget.core.database.model.Quest
import com.dyddyd.aquariumwidget.core.database.model.Rod
import com.dyddyd.aquariumwidget.core.database.model.User

@Database(
    entities = [
        Aquarium::class,
        Catch::class,
        Clear::class,
        CollectRod::class,
        Contain::class,
        Fish::class,
        Habitat::class,
        Match::class,
        Parts::class,
        Quest::class,
        Rod::class,
        User::class,
    ],
    version = 1
)
internal abstract class AquariumDatabase: RoomDatabase() {
    abstract fun fishDao(): FishDao


}