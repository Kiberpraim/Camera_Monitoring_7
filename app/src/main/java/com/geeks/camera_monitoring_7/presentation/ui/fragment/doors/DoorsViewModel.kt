package com.geeks.camera_monitoring_7.presentation.ui.fragment.doors

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.usecases.doors.DeleteDoorUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.GetAllDoorsUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.InsertDoorUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.UpdateDoorUseCase
import com.geeks.camera_monitoring_7.domain.utils.Resource
import com.geeks.camera_monitoring_7.presentation.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getAllDoorsUseCase: GetAllDoorsUseCase,
    private val insertDoorUseCase: InsertDoorUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val deleteDoorUseCase: DeleteDoorUseCase
) : ViewModel() {

    private val _doorsList = MutableStateFlow<UiState<List<DoorModel>>>(UiState.Loading())
    val doorsList: StateFlow<UiState<List<DoorModel>>> = _doorsList

    fun getAllDoors() {
        viewModelScope.launch {
            getAllDoorsUseCase.getAllCameras().collect { resource ->
                when (resource) {
                    is Resource.Loading -> _doorsList.value = UiState.Loading()

                    is Resource.Success -> {
                        if (resource.data != null) {
                            _doorsList.value = UiState.Success(data = resource.data)
                        } else {
                            _doorsList.value = UiState.Empty()
                        }
                    }

                    is Resource.Error -> _doorsList.value =
                        UiState.Error(message = resource.message ?: "ERROR")
                }
            }
        }
    }
}