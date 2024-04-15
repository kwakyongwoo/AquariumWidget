package com.dyddyd.aquariumwidget.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dyddyd.aquariumwidget.core.database.model.Habitat
import kotlinx.coroutines.flow.Flow

@Dao
interface HabitatDao {

    @Query(
        value = """
            SELECT * FROM HABITAT 
            WHERE HABITAT.habitat_id IN (
                SELECT HABITAT.habitat_id FROM HABITAT, COLLECT_ROD, `MATCH` 
                WHERE
                    HABITAT.habitat_id = `MATCH`.habitat_id 
                    AND `MATCH`.rod_id = COLLECT_ROD.rod_id 
                    AND COLLECT_ROD.user_id = :userId)
        """
    )
    fun getAllCollectedHabitats(userId: Int): Flow<List<Habitat>>


    @Query("SELECT * FROM HABITAT")
    fun getAllHabitats(): Flow<List<Habitat>>

    @Query("SELECT * FROM HABITAT WHERE habitat_id = :habitatId")
    fun getHabitatInfo(habitatId: Int): Flow<Habitat>
}