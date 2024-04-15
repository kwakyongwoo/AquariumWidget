package com.dyddyd.aquariumwidget.core.data.repository

import android.os.Build.VERSION_CODES.P
import com.dyddyd.aquariumwidget.core.database.dao.UserDao
import com.dyddyd.aquariumwidget.core.database.model.User
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

internal class OfflineUserRepository @Inject constructor(
    private val userDao: UserDao,
): UserRepository {
    override fun getUserId(): Flow<Int> =
        userDao.getUserId()

    override fun getUserInfo(userId: Int): Flow<User> =
        userDao.getUserInfo(userId)

    override suspend fun decreaseGameChanceCount(userId: Int) {
        userDao.decreaseGameChanceCount(userId)
    }

    override suspend fun resetGameChanceCount(userId: Int) {
        userDao.resetGameChanceCount(userId)
    }

    override suspend fun changeAquariumTheme(userId: Int, aquariumId: Int) {
        userDao.changeAquariumTheme(userId, aquariumId)
    }

    override fun clearCurrentHabitat(userId: Int, habitatId: Int): Flow<Boolean> =
        userDao.getMaxHabitat().map { maxHabitatId ->
            if (habitatId < maxHabitatId) {
                userDao.clearCurrentHabitat(userId, habitatId)
                true
            }
            false
        }

    override suspend fun updateLastPlayedDate(curDate: Int, userId: Int) {
        userDao.updateLastPlayedDate(curDate, userId)
    }
}