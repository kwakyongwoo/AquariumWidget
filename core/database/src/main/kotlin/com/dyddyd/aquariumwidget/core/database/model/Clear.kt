package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "CLEAR",
    primaryKeys = ["user_id", "quest_id", "habitat_id"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = Quest::class,
            parentColumns = ["quest_id"],
            childColumns = ["quest_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = Habitat::class,
            parentColumns = ["habitat_id"],
            childColumns = ["habitat_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )

    ]
)
data class Clear(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "quest_id")
    val questId: Int,
    @ColumnInfo(name = "habitat_id")
    val habitatId: Int,
)
