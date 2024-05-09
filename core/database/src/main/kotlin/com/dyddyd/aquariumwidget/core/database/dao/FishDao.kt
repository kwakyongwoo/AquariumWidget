package com.dyddyd.aquariumwidget.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dyddyd.aquariumwidget.core.database.model.FishEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FishDao {

    @Query("INSERT INTO CATCH (user_id, fish_id, rod_id) VALUES (:userId, :fishId, :rodId);")
    suspend fun catchFish(userId: Int, fishId: Int, rodId: Int)

    @Query("SELECT * FROM FISH")
    fun getAllFish(): Flow<List<FishEntity>>

    @Query("SELECT * FROM FISH INNER JOIN CATCH ON FISH.fish_id = CATCH.fish_id;")
    fun getAllCollectFish(): Flow<List<FishEntity>>

    @Query("INSERT OR IGNORE INTO CONTAIN (user_id, aquarium_id, fish_id) VALUES (:userId, :aquariumId, :fishId);")
    suspend fun addFishToAquarium(userId: Int, aquariumId: Int, fishId: Int)

    @Query("DELETE FROM CONTAIN WHERE user_id = :userId AND aquarium_id = :aquariumId AND fish_id = :fishId;")
    suspend fun removeFishFromAquarium(userId: Int, aquariumId: Int, fishId: Int)

    @Query("SELECT * FROM FISH INNER JOIN CONTAIN ON FISH.fish_id = CONTAIN.fish_id WHERE CONTAIN.user_id = :userId AND CONTAIN.aquarium_id = :aquariumId;")
    fun getAllFishInAquarium(userId: Int, aquariumId: Int): Flow<List<FishEntity>>

    @Query("SELECT * FROM FISH INNER JOIN CATCH ON FISH.fish_id = CATCH.fish_id WHERE CATCH.user_id = :userId AND CATCH.fish_id = :fishId;")
    fun getCollectedFish(userId: Int, fishId: Int): Flow<List<FishEntity>>

    @Query(
        value = """
            SELECT * FROM FISH
            INNER JOIN CATCH ON FISH.fish_id = CATCH.fish_id
            WHERE CATCH.user_id = :userId AND FISH.rarity = :rarity;
        """
    )
    fun getAllCollectedFishByRarity(userId: Int, rarity: String): Flow<List<FishEntity>>

    @Query(
        value = """
            SELECT DISTINCT FISH.fish_id, FISH.name, FISH.description, FISH.rarity, FISH.imageUrl, FISH.habitat_id FROM FISH 
            INNER JOIN CATCH ON FISH.fish_id = CATCH.fish_id 
            WHERE CATCH.user_id = :userId 
            GROUP BY FISH.fish_id
        """

    )
    fun getAllCollectedFishWithoutDuplication(userId: Int): Flow<List<FishEntity>>
}