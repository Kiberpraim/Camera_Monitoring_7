package com.geeks.camera_monitoring_7.domain.repository

import com.geeks.camera_monitoring_7.domain.models.CameraModel

interface CameraRepository {

    suspend fun getAllCameras(): List<CameraModel>

    suspend fun insertCamera(cameraModel: CameraModel)

    suspend fun updateCamera(cameraModel: CameraModel)

    suspend fun deleteCamera(cameraModel: CameraModel)
}