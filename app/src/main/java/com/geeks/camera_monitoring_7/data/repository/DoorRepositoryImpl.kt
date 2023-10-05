package com.geeks.camera_monitoring_7.data.repository

import com.geeks.camera_monitoring_7.data.dtos.toDataDto
import com.geeks.camera_monitoring_7.data.dtos.toDomainModel
import com.geeks.camera_monitoring_7.data.local.db.DoorDao
import com.geeks.camera_monitoring_7.data.remoute.HouseApiService
import com.geeks.camera_monitoring_7.data.utils.GetResource
import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.repository.DoorRepository
import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class DoorRepositoryImpl @Inject constructor(
    private val dao: DoorDao,
    private val houseApiService: HouseApiService,
) : DoorRepository, GetResource() {
    override suspend fun getAllDoors(): Flow<Resource<List<DoorModel>>> {
        return getResult {
            houseApiService.getDoor().body()!!.data.toDomainModel()
        }
    }

    override fun insertDoor(doorModel: DoorModel) {
        dao.insertDoor(doorModel.toDataDto())
    }

    override fun updateDoor(doorModel: DoorModel) {
        dao.updateDoor(doorModel.toDataDto())
    }

    override fun deleteDoor(doorModel: DoorModel) {
        dao.deleteDoor(doorModel.toDataDto())
    }
}