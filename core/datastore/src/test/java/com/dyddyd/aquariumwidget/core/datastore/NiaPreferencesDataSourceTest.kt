package com.dyddyd.aquariumwidget.core.datastore

import com.dyddyd.aquariumwidget.core.datastore.test.testUserPreferencesDataStore
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Before
import org.junit.Rule
import org.junit.rules.TemporaryFolder

class vAquariumPreferencesDataSourceTest {

    private val testScope = TestScope(UnconfinedTestDispatcher())

    private lateinit var subject: AquariumPreferencesDataSource

    @get:Rule
    val tmpFolder: TemporaryFolder = TemporaryFolder.builder().assureDeletion().build()

    @Before
    fun setup() {
        subject = AquariumPreferencesDataSource(
            tmpFolder.testUserPreferencesDataStore(testScope)
        )
    }
}
