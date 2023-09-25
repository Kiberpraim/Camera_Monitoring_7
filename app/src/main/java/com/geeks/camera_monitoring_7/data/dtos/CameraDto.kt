package com.geeks.camera_monitoring_7.data.dtos

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.google.gson.annotations.SerializedName

@Entity(tableName = "camera_table")
data class CameraDto(
    @PrimaryKey
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val rec: Boolean,
    val room: String,
    @SerializedName("snapshot")
    val image: String
)

fun CameraDto.toDomainModel() = CameraModel(id, favorites, name, rec, room, image)