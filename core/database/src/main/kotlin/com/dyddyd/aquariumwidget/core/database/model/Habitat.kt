package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "HABITAT")
data class Habitat(
    @PrimaryKey
    @ColumnInfo(name = "habitat_id")
    val habitatId: Int,
    val name: String,
    val description: String,
    val imageUrl: String?,
)