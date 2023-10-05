package com.geeks.camera_monitoring_7.domain.usecases.doors

import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.repository.DoorRepository
import javax.inject.Inject

class InsertDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun insertDoor(doorModel: DoorModel) = doorRepository.insertDoor(doorModel)
}