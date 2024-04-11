package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ROD")
data class Rod(
    @PrimaryKey
    @ColumnInfo(name = "rod_id")
    val rodId: Int,
    val name: String,
    val description: String,
    val imageUrl: String?,
)
