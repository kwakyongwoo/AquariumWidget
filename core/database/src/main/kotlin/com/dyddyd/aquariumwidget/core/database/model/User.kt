package com.dyddyd.aquariumwidget.core.database.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "USER",
    foreignKeys = [
        ForeignKey(
            entity = Aquarium::class,
            parentColumns = ["aquarium_id"],
            childColumns = ["selected_aquarium_theme_id"],
            onDelete = ForeignKey.NO_ACTION,
            onUpdate = ForeignKey.NO_ACTION
        )
    ]
)
data class User(
    @PrimaryKey
    @ColumnInfo(name = "user_id")
    val userId: Int,
    val chance: Int,
    @ColumnInfo(name = "cur_habitat")
    val curHabitat: Int,
    @ColumnInfo(name = "selected_aquarium_theme_id")
    val selectedAquariumThemeId: Int?,
    @ColumnInfo(name = "last_played_date")
    val lastPlayedDate: Int?,
)
