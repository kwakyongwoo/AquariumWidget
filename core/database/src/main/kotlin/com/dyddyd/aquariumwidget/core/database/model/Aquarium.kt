package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "AQUARIUM")
data class Aquarium(
    @PrimaryKey
    @ColumnInfo(name = "aquarium_id")
    val aquariumId: Int,
    val name: String,
    val description: String,
    val imageUrl: String?,
)