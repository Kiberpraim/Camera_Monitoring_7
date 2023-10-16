package com.geeks.camera_monitoring_7.domain.repository

import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoorRepository {

    suspend fun getRemoteDoors(): Flow<Resource<List<DoorModel>>>

    fun getLocalDoors(): List<DoorModel>

    fun insertDoor(doorModel: DoorModel)

    fun insertLocalDoors(doorModels: List<DoorModel>)

    fun updateDoor(doorModel: DoorModel)

    fun updateLocalDoors(doorModels: List<DoorModel>)

    fun deleteDoor(doorModel: DoorModel)
}