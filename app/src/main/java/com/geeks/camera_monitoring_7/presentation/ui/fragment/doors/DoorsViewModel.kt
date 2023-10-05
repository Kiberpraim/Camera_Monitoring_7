package com.geeks.camera_monitoring_7.presentation.ui.fragment.doors

import androidx.lifecycle.ViewModel
import com.geeks.camera_monitoring_7.domain.usecases.doors.DeleteDoorUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.GetAllDoorsUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.InsertDoorUseCase
import com.geeks.camera_monitoring_7.domain.usecases.doors.UpdateDoorUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DoorsViewModel @Inject constructor(
    private val getAllDoorsUseCase: GetAllDoorsUseCase,
    private val insertDoorUseCase: InsertDoorUseCase,
    private val updateDoorUseCase: UpdateDoorUseCase,
    private val deleteDoorUseCase: DeleteDoorUseCase
) : ViewModel() {

    suspend fun getAllDoors() = getAllDoorsUseCase.getAllCameras()
}