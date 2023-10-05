package com.geeks.camera_monitoring_7.domain.usecases.doors

import com.geeks.camera_monitoring_7.domain.repository.DoorRepository
import javax.inject.Inject

class GetAllDoorsUseCase @Inject constructor(
    private val doorRepository: DoorRepository
) {
    suspend fun getAllCameras() = doorRepository.getAllDoors()
}