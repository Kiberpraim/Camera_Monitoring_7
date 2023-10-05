package com.geeks.camera_monitoring_7.di

import com.geeks.camera_monitoring_7.data.repository.CameraRepositoryImpl
import com.geeks.camera_monitoring_7.data.repository.DoorRepositoryImpl
import com.geeks.camera_monitoring_7.domain.repository.CameraRepository
import com.geeks.camera_monitoring_7.domain.repository.DoorRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {

    @Binds
    fun bindCameraRepository(cameraRepositoryImpl: CameraRepositoryImpl): CameraRepository

    @Binds
    fun bindDoorRepository(doorRepositoryImpl: DoorRepositoryImpl): DoorRepository
}