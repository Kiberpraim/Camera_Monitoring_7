package com.geeks.camera_monitoring_7.data.local.remoute

import com.geeks.camera_monitoring_7.data.dtos.CameraDto
import com.geeks.camera_monitoring_7.data.dtos.DoorDto
import retrofit2.Call
import retrofit2.http.GET

interface HouseApiService {

    @GET("cameras/")
    fun getCamera(): Call<List<CameraDto>>

    @GET("doors/")
    fun getDoor(): Call<List<DoorDto>>
}