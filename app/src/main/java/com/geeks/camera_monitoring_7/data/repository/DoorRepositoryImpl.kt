package com.geeks.camera_monitoring_7.data.repository

import com.geeks.camera_monitoring_7.data.local.db.DoorDao
import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.repository.DoorRepository
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val dao: DoorDao
) : DoorRepository {
    override suspend fun getAllDoors(): List<DoorModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insertDoor(doorModel: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateDoor(doorModel: DoorModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDoor(doorModel: DoorModel) {
        TODO("Not yet implemented")
    }
}