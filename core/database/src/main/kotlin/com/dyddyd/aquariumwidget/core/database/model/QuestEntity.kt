package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import com.dyddyd.aquariumwidget.core.model.data.Quest

@Entity(
    tableName = "QUEST",
    foreignKeys = [
        ForeignKey(
            entity = HabitatEntity::class,
            parentColumns = ["habitat_id"],
            childColumns = ["habitat_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = PartsEntity::class,
            parentColumns = ["parts_id"],
            childColumns = ["parts_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )
    ]
)
data class QuestEntity(
    @PrimaryKey
    @ColumnInfo(name = "quest_id")
    val questId: Int,
    @ColumnInfo(name = "habitat_id")
    val habitatId: Int,
    @ColumnInfo(name = "parts_id")
    val partsId: Int,
)

fun QuestEntity.asExternalModel() = Quest(
    questId = questId,
    habitatId = habitatId,
    partsId = partsId,
)