package com.geeks.camera_monitoring_7.data.remoute

import com.geeks.camera_monitoring_7.data.dtos.CameraDto
import com.geeks.camera_monitoring_7.data.dtos.CamerasDto
import com.geeks.camera_monitoring_7.data.dtos.DoorDto
import com.geeks.camera_monitoring_7.data.dtos.DoorsDto
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface HouseApiService {

    @GET("cameras/")
    suspend fun getCamera(): Response<CamerasDto>

    @GET("doors/")
    suspend fun getDoor(): Response<DoorsDto>
}