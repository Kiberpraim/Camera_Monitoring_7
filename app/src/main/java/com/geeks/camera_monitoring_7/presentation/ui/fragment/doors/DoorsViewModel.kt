package com.geeks.camera_monitoring_7.presentation.ui.fragment.doors

import androidx.lifecycle.viewModelScope
import com.geeks.camera_monitoring_7.domain.models.DoorModel
import com.geeks.camera_monitoring_7.domain.usecases.doors.DeleteDoorUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.GetAllDoorsUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.InsertDoorUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.RefreshDoorsUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.UpdateDoorUseCase
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
class DoorsViewModel @Inject constructor(
    private val getAllDoorsUseCase: GetAllDoorsUseCase,
    private val refreshDoorsUseCase: RefreshDoorsUseCase,
    private val insertDoorUseCase: InsertDoorUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val deleteDoorUseCase: DeleteDoorUseCase
) : BaseViewModel() {

    private val _doorsList = MutableStateFlow<UiState<List<DoorModel>>>(UiState.Loading())
    val doorsList: StateFlow<UiState<List<DoorModel>>> = _doorsList

    fun getAllDoors() = doRequest {
        getAllDoorsUseCase()
    }

    fun refreshDoors() = doRequest {
        refreshDoorsUseCase()
    }

    private fun doRequest(useCase: suspend () -> Flow<Resource<List<DoorModel>>>) {
        viewModelScope.launch(Dispatchers.IO) {
            _doorsList.value = collectData { useCase() }
        }
    }
}