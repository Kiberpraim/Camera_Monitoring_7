package com.geeks.camera_monitoring_7.presentation.ui.fragment.cameras

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.camera_monitoring_7.domain.models.CameraModel
import com.geeks.camera_monitoring_7.domain.usecases.cameras.DeleteCameraUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.GetAllCamerasUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.InsertCameraUseCase
import com.geeks.camera_monitoring_7.domain.usecases.cameras.UpdateCameraUseCase
import com.geeks.camera_monitoring_7.domain.utils.Resource
import com.geeks.camera_monitoring_7.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CamerasViewModel @Inject constructor(
    private val getAllCamerasUseCase: GetAllCamerasUseCase,
    private val insertCameraUseCase: InsertCameraUseCase,
    private val updateCameraUseCase: UpdateCameraUseCase,
    private val deleteCameraUseCase: DeleteCameraUseCase
) : ViewModel() {

    private val _camerasList = MutableStateFlow<UiState<List<CameraModel>>>(UiState.Loading())
    val camerasList: StateFlow<UiState<List<CameraModel>>> = _camerasList

    fun getAllCameras() {
        viewModelScope.launch {
            getAllCamerasUseCase.getAllCameras().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _camerasList.value = UiState.Loading()

                    is Resource.Success -> {
                        if (resource.data != null) {
                            _camerasList.value = UiState.Success(data = resource.data)
                        } else {
                            _camerasList.value = UiState.Empty()
                        }
                    }

                    is Resource.Error -> _camerasList.value =
                        UiState.Error(message = resource.message ?: "ERROR")
                }
            }
        }
    }
}