package com.dyddyd.aquariumwidget.core.database.dao

import androidx.room.Dao
import androidx.room.Query
import com.dyddyd.aquariumwidget.core.database.model.Parts
import com.dyddyd.aquariumwidget.core.database.model.Quest
import kotlinx.coroutines.flow.Flow

@Dao
interface QuestDao {

    @Query("INSERT OR IGNORE INTO CLEAR (user_id, habitat_id, quest_id) VALUES (:userId, :habitatId, :questId)")
    suspend fun clearQuest(userId: Int, habitatId: Int, questId: Int)

    @Query("SELECT * FROM QUEST WHERE habitat_id = :habitatId")
    fun getAllQuestsInTheHabitat(habitatId: Int): Flow<List<Quest>>

    @Query("SELECT * FROM QUEST INNER JOIN CLEAR ON QUEST.quest_id = CLEAR.quest_id WHERE QUEST.habitat_id = :habitatId AND CLEAR.user_id = :userId")
    fun getAllClearedQuestsInTheHabitat(userId: Int, habitatId: Int): Flow<List<Quest>>

    @Query("SELECT COUNT(*) FROM QUEST WHERE habitat_id = :habitatId")
    fun getTotalQuestNum(habitatId: Int): Flow<Int>

    @Query("SELECT COUNT(*) FROM CLEAR WHERE user_id = :userId AND habitat_id = :habitatId")
    fun getClearQuestNum(userId: Int, habitatId: Int): Flow<Int>

    @Query("SELECT EXISTS (SELECT * FROM CLEAR WHERE user_id = :userId AND quest_id = :questId) AS isQuestCleared;")
    fun checkQuestCleared(userId: Int, questId: Int): Flow<Boolean>


    @Query("SELECT * FROM PARTS INNER JOIN QUEST ON QUEST.parts_id = PARTS.parts_id WHERE QUEST.quest_id = :questId")
    fun getQuestReward(questId: Int): Flow<Parts?>
}