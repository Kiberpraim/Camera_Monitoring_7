package com.geeks.camera_monitoring_7.data.local.db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.geeks.camera_monitoring_7.data.dtos.DoorDto

@Dao
interface DoorDao {

    @Query("SELECT * FROM door_table")
    fun getAllDoor(): List<DoorDto>

    @Insert
    fun insertDoor(door: DoorDto)

    @Update
    fun updateAllDoors(doors: List<DoorDto>)

    @Update
    fun updateDoor(door: DoorDto)

    @Delete
    fun deleteDoor(door: DoorDto)
}