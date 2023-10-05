package com.geeks.camera_monitoring_7.data.utils

import com.geeks.camera_monitoring_7.domain.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

abstract class GetResource {
    protected suspend fun <T> getResult(result: suspend () -> T) = flow {
        emit(Resource.Loading())
        emit(Resource.Success(data = result()))
    }.flowOn(Dispatchers.IO).catch { exception ->
        emit(Resource.Error(message = exception.message ?: "Что-то пошло не так."))
    }
}