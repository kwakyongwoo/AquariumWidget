package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "FISH",
    foreignKeys = [
        ForeignKey(
            entity = Habitat::class,
            parentColumns = ["habitat_id"],
            childColumns = ["habitat_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )
    ]
)
data class Fish(
    @PrimaryKey
    @ColumnInfo(name = "fish_id")
    val fishId: Int,
    val name: String,
    val description: String,
    val rarity: String,
    val imageUrl: String?,
    @ColumnInfo(name = "habitat_id")
    val habitatId: Int,
)
