package com.geeks.camera_monitoring_7.presentation.ui.fragment.cameras

import androidx.lifecycle.ViewModel
import com.geeks.camera_monitoring_7.domain.usecases.cameras.DeleteCameraUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.GetAllCamerasUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.InsertCameraUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.UpdateCameraUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getAllCamerasUseCase: GetAllCamerasUseCase,
    private val insertCameraUseCase: InsertCameraUseCase,
    private val updateCameraUseCase: UpdateCameraUseCase,
    private val deleteCameraUseCase: DeleteCameraUseCase
) : ViewModel() {

    suspend fun getAllCameras() = getAllCamerasUseCase.getAllCameras()
}