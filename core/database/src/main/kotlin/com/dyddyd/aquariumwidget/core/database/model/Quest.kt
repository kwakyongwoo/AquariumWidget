package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "QUEST",
    foreignKeys = [
        ForeignKey(
            entity = Habitat::class,
            parentColumns = ["habitat_id"],
            childColumns = ["habitat_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = Parts::class,
            parentColumns = ["parts_id"],
            childColumns = ["parts_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )
    ]
)
data class Quest(
    @PrimaryKey
    @ColumnInfo(name = "quest_id")
    val questId: Int,
    @ColumnInfo(name = "habitat_id")
    val habitatId: Int,
    @ColumnInfo(name = "parts_id")
    val partsId: Int,
)