package com.geeks.camera_monitoring_7.domain.repository

import com.geeks.camera_monitoring_7.domain.models.DoorModel

interface DoorRepository {

    suspend fun getAllDoors(): List<DoorModel>

    suspend fun insertDoor(doorModel: DoorModel)

    suspend fun updateDoor(doorModel: DoorModel)

    suspend fun deleteDoor(doorModel: DoorModel)
}