package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "PARTS",
    foreignKeys = [
        ForeignKey(
            entity = Rod::class,
            parentColumns = ["rod_id"],
            childColumns = ["rod_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )
    ]
)
data class Parts(
    @PrimaryKey
    @ColumnInfo(name = "parts_id")
    val partsId: Int,
    val name: String,
    val description: String,
    val imageUrl: String?,
    @ColumnInfo(name = "rod_id")
    val rodId: Int,
)
