package com.geeks.camera_monitoring_7.domain.repository

import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface CameraRepository {

    suspend fun getAllCameras(): Flow<Resource<List<CameraModel>>>

    fun insertCamera(cameraModel: CameraModel)

    fun updateCamera(cameraModel: CameraModel)

    fun deleteCamera(cameraModel: CameraModel)
}