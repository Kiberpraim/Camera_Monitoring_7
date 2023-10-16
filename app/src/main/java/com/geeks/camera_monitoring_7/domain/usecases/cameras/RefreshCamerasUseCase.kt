package com.geeks.camera_monitoring_7.domain.usecases.cameras

import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.repository.CameraRepository
import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RefreshCamerasUseCase @Inject constructor(
    private val cameraRepository: CameraRepository
) {
    suspend operator fun invoke(): Flow<Resource<List<CameraModel>>> {

        cameraRepository.getRemoteCameras().collect { resource ->
            if (resource is Resource.Success) {
                if (cameraRepository.getLocalCameras().isEmpty()) {
                    cameraRepository.insertLocalCameras(resource.data!!)
                } else {
                    cameraRepository.updateLocalCameras(resource.data!!)
                }
            }
        }
        return cameraRepository.getRemoteCameras()
    }
}