package com.kustims.a6six.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart


sealed class Result<out T> {
    object Loading : Result<Nothing>()
    data class Success<T>(val data: T) : Result<T>()
    data class Error(val throwable: Throwable, val statusCode: Int? = 0) : Result<Nothing>()
}

// result 를 repository interface 함수의 반환형에서 제거하면 해당 함수 적용 가능
// 반복되는 코드를 제거하기 위해 helper 함수 추카
fun <T> Flow<T>.asResult(): Flow<Result<T>> {
    return this
        // 맵의 결과값이 Success 만 들어오는 것이 아니기때문에
        // 코드 분석 필요
        .map<T, Result<T>> {
            Result.Success(it)
        }
        .onStart { emit(Result.Loading) }
        .catch { Result.Error(it) }
}
