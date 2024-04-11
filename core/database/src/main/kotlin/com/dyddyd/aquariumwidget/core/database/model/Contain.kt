package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "CONTAIN",
    primaryKeys = ["user_id", "aquarium_id", "fish_id"],
    foreignKeys = [
        ForeignKey(
            entity = User::class,
            parentColumns = ["user_id"],
            childColumns = ["user_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = Aquarium::class,
            parentColumns = ["aquarium_id"],
            childColumns = ["aquarium_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        ),
        ForeignKey(
            entity = Fish::class,
            parentColumns = ["fish_id"],
            childColumns = ["fish_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )
    ]
)
data class Contain(
    @ColumnInfo(name = "user_id")
    val userId: Int,
    @ColumnInfo(name = "aquarium_id")
    val aquariumId: Int,
    @ColumnInfo(name = "fish_id")
    val fishId: Int,
)
