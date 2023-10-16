package com.geeks.camera_monitoring_7.presentation.ui.fragment.cameras

import androidx.lifecycle.viewModelScope
import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.usecases.cameras.DeleteCameraUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.GetAllCamerasUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.InsertCameraUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.RefreshCamerasUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.UpdateCameraUseCase
import com.geeks.camera_monitoring_7.domain.utils.Resource
import com.geeks.camera_monitoring_7.presentation.base.BaseViewModel
import com.geeks.camera_monitoring_7.presentation.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getAllCamerasUseCase: GetAllCamerasUseCase,
    private val refreshCamerasUseCase: RefreshCamerasUseCase,
    private val insertCameraUseCase: InsertCameraUseCase,
    private val updateCameraUseCase: UpdateCameraUseCase,
    private val deleteCameraUseCase: DeleteCameraUseCase
) : BaseViewModel() {

    private val _camerasList = MutableStateFlow<UiState<List<CameraModel>>>(UiState.Loading())
    val camerasList: StateFlow<UiState<List<CameraModel>>> = _camerasList

    fun getAllCameras() = doRequest {
        getAllCamerasUseCase()
    }

    fun refreshCameras() = doRequest {
        refreshCamerasUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<CameraModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _camerasList.value = collectData { useCase() }
        }
    }
}