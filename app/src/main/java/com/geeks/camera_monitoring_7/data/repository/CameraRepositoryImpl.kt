package com.geeks.camera_monitoring_7.data.repository

import com.geeks.camera_monitoring_7.data.local.db.CameraDao
import com.geeks.camera_monitoring_7.data.local.remoute.HouseApiService
import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.repository.CameraRepository
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val dao: CameraDao,
    private val houseApiService: HouseApiService,
) : CameraRepository {
    override suspend fun getAllCameras(): List<CameraModel> {
        TODO("Not yet implemented")
    }

    override suspend fun insertCamera(cameraModel: CameraModel) {
        TODO("Not yet implemented")
    }

    override suspend fun updateCamera(cameraModel: CameraModel) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteCamera(cameraModel: CameraModel) {
        TODO("Not yet implemented")
    }
}