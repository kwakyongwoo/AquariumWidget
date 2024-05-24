package com.dyddyd.aquariumwidget.core.data.testdoubles

import com.dyddyd.aquariumwidget.core.database.dao.UserDao
import com.dyddyd.aquariumwidget.core.database.model.UserEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class TestUserDao: UserDao {
    override fun getUserId(): Flow<Int> = flowOf(1)

    override fun getUserInfo(userId: Int): Flow<UserEntity> {
        TODO("Not yet implemented")
    }

    override suspend fun decreaseGameChanceCount(userId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun resetGameChanceCount(userId: Int) {
        TODO("Not yet implemented")
    }

    override suspend fun changeAquariumTheme(userId: Int, aquariumId: Int) {
        TODO("Not yet implemented")
    }

    override fun getMaxHabitat(): Flow<Int> = flowOf(3)

    override suspend fun clearCurrentHabitat(userId: Int, habitatId: Int) {
        // nothing
    }

    override suspend fun updateLastPlayedDate(curDate: Int, userId: Int) {
        TODO("Not yet implemented")
    }
}