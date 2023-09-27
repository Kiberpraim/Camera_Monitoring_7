package com.geeks.camera_monitoring_7.di

import android.content.Context
import androidx.room.Room
import com.geeks.camera_monitoring_7.data.local.db.CameraDao
import com.geeks.camera_monitoring_7.data.local.db.DoorDao
import com.geeks.camera_monitoring_7.data.local.db.HouseDatabase
import com.geeks.camera_monitoring_7.data.local.remoute.HouseApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAppDatabase(@ApplicationContext context: Context): HouseDatabase =
        Room.databaseBuilder(context, HouseDatabase::class.java, "house database")
            .allowMainThreadQueries().build()

    @Provides
    fun provideCameraDao(@ApplicationContext context: Context): CameraDao =
        provideAppDatabase(context).getCameraDao()

    @Provides
    fun provideDoorDao(houseDatabase: HouseDatabase): DoorDao = houseDatabase.getDoorDao()


    @Provides
    fun provideRetrofit(): Retrofit =
        Retrofit.Builder().baseUrl("http://cars.cprogroup.ru/api/rubetek/")
            .addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun provideHouseApiService(retrofit: Retrofit): HouseApiService =
        retrofit.create(HouseApiService::class.java)

}