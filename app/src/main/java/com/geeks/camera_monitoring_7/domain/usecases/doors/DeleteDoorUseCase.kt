package com.geeks.camera_monitoring_7.domain.usecases.doors

import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.repository.DoorRepository
import javax.inject.Inject

class DeleteDoorUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    fun deleteDoor(doorModel: DoorModel) = doorRepository.deleteDoor(doorModel)
}