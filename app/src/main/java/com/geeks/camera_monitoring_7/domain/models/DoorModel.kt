package com.geeks.camera_monitoring_7.domain.models

data class DoorModel(
    val id: Long,
    val favorites: Boolean,
    val name: String,
    val room: String,
    val image: String
)
