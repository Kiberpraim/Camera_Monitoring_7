package com.geeks.camera_monitoring_7.data.repository

import com.geeks.camera_monitoring_7.data.dtos.toDataDto
import com.geeks.camera_monitoring_7.data.dtos.toDomainModel
import com.geeks.camera_monitoring_7.data.local.db.CameraDao
import com.geeks.camera_monitoring_7.data.remoute.HouseApiService
import com.geeks.camera_monitoring_7.data.utils.GetResource
import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.repository.CameraRepository
import javax.inject.Inject

class CameraRepositoryImpl @Inject constructor(
    private val dao: CameraDao,
    private val houseApiService: HouseApiService,
) : CameraRepository, GetResource() {
    override suspend fun getRemoteCameras() = getResult {
        houseApiService.getCamera().body()!!.data.cameras.toDomainModel()
    }

    override fun getLocalCameras(): List<CameraModel> {
        return dao.getAllCameras().toDomainModel()
    }

    override fun insertCamera(cameraModel: CameraModel) {
        dao.insertCamera(cameraModel.toDataDto())
    }

    override fun insertLocalCameras(cameraModels: List<CameraModel>) {
        dao.insertAllCameras(cameraModels.toDataDto())
    }

    override fun updateCamera(cameraModel: CameraModel) {
        dao.updateCamera(cameraModel.toDataDto())
    }

    override fun updateLocalCameras(cameraModels: List<CameraModel>) {
        dao.updateAllCameras(cameraModels.toDataDto())
    }

    override fun deleteCamera(cameraModel: CameraModel) {
        dao.deleteCamera(cameraModel.toDataDto())
    }
}