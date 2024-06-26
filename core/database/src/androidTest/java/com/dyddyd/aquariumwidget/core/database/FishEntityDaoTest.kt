package com.dyddyd.aquariumwidget.core.database

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.dyddyd.aquariumwidget.core.database.dao.FishDao
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

class FishEntityDaoTest {

    private lateinit var fishDao: FishDao
    private lateinit var db: AquariumDatabase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.databaseBuilder(
            context,
            AquariumDatabase::class.java,
            "aquarium-database-test7"
        ).createFromAsset("DB.sqlite3").build()
        fishDao = db.fishDao()
    }

    @Test
    fun fishDao_getAllFish() = runTest {
        val fishList = fishDao.getAllFish().firstOrNull()

        println("fishDao_getAllFish: $fishList")
    }

    @Test
    fun fishDao_getAllCollectedFish() = runTest {
        fishDao.catchFish(1, 1, 1)
        val fishList = fishDao.getAllCollectFish().firstOrNull()

        println("fishDao_getAllCollectedFish: $fishList")
    }
}