package com.dyddyd.aquariumwidget.core.data.repository

import com.dyddyd.aquariumwidget.core.data.testdoubles.TestUserDao
import com.dyddyd.aquariumwidget.core.datastore.test.testUserPreferencesDataStore
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TemporaryFolder
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class OfflineUserRepositoryTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: OfflineUserRepository

    private lateinit var userDao: TestUserDao

//    @get:Rule
//    val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @Before
    fun setup() {
        userDao = TestUserDao()
        subject = OfflineUserRepository(
            userDao = userDao
        )
    }

    @Test
    fun offlineUserRepository_clearCurrentHabitat_success_test() = testScope.runTest {
        userDao.getMaxHabitat().map {
            if (1 < it) {
                userDao.clearCurrentHabitat(1, 1)
                true
            } else {
                false
            }
        }.collect {
            assertTrue(it)
        }
    }

    @Test
    fun offlineUserRepository_clearCurrentHabitat_fail_test() = testScope.runTest {
        userDao.getMaxHabitat().map {
            if (4 < it) {
                userDao.clearCurrentHabitat(1, 1)
                true
            } else {
                false
            }
        }.collect {
            assertFalse(it)
        }
    }
}