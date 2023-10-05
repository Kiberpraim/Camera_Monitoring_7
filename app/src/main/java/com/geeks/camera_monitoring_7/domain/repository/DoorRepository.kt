package com.geeks.camera_monitoring_7.domain.repository

import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>>

    fun insertDoor(doorModel: DoorModel)

    fun updateDoor(doorModel: DoorModel)

    fun deleteDoor(doorModel: DoorModel)
}