package com.geeks.camera_monitoring_7.domain.usecases.cameras

import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.repository.CameraRepository
import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    suspend fun getAllCameras() : Flow<Resource<List<CameraModel>>> {
        return cameraRepository.getAllCameras()
    }
}