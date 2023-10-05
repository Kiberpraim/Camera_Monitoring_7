package com.geeks.camera_monitoring_7.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.utils.Constants.EMPTY_STRING
import com.google.gson.annotations.SerializedName

data class DoorsDto(
    val data: List<DoorDto>,
    val success: Boolean
)

@Entity(tableName = "door_table")
data class DoorDto(
    @PrimaryKey
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val room: String = EMPTY_STRING,
    @SerializedName("snapshot")
    val image: String = EMPTY_STRING
)

fun DoorDto.toDomainModel() = DoorModel(id, favorites, name, room, image)
fun DoorModel.toDataDto() = DoorDto(id, favorites, name, room, image)

fun List<DoorDto>.toDomainModel() = this.map { door ->
    DoorModel(
        id = door.id,
        favorites = door.favorites,
        name = door.name,
        room = door.room ?: EMPTY_STRING,
        image = door.image ?: EMPTY_STRING
    )
}