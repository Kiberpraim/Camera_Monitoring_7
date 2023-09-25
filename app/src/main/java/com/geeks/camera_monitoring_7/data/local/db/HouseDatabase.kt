package com.geeks.camera_monitoring_7.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.geeks.camera_monitoring_7.data.dtos.CameraDto
import com.geeks.camera_monitoring_7.data.dtos.DoorDto

@Database(entities = [CameraDto::class, DoorDto::class], version = 1, exportSchema = true)
abstract class HouseDatabase : RoomDatabase() {
    abstract fun getCameraDao(): CameraDao
    abstract fun getDoorDao(): DoorDao
}