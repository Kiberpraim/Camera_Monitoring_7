package com.geeks.camera_monitoring_7.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "door_table")
data class DoorDto(
    @PrimaryKey
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val room: String,
    @SerializedName("snapshot")
    val image: String
)

fun DoorDto.toDomainModel() = DoorModel(id, favorites, name, room, image)
