package com.geeks.camera_monitoring_7.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.utils.Constants.EMPTY_STRING
import com.google.gson.annotations.SerializedName

data class CamerasDto(
    val data: Data,
    val success: Boolean
)

data class Data(
    val cameras: List<CameraDto>,
    val room: List<String>
)

@Entity(tableName = "camera_table")
data class CameraDto(
    @PrimaryKey
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val rec: Boolean,
    val room: String = EMPTY_STRING,
    @SerializedName("snapshot")
    val image: String
)

fun CameraDto.toDomainModel() = CameraModel(id, favorites, name, rec, room, image)
fun CameraModel.toDataDto() = CameraDto(id, favorites, name, rec, room, image)

fun List<CameraDto>.toDomainModel() = this.map { camera ->
    CameraModel(
        id = camera.id,
        favorites = camera.favorites,
        name = camera.name,
        rec = camera.rec,
        room = camera.room ?: EMPTY_STRING,
        image = camera.image
    )
}

fun List<CameraModel>.toDataDto() = this.map { camera ->
    CameraDto(
        id = camera.id,
        favorites = camera.favorites,
        name = camera.name,
        rec = camera.rec,
        room = camera.room,
        image = camera.image
    )
}