package com.kustims.a6six.data

import com.kustims.a6six.Repository.AuthenticationRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class AuthenticationRepositoryImpl(
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource,
) : AuthenticationRepository {

    override suspend fun authenticateWithBackend(googleToken: String): DataResult<String> =
        withContext(ioDispatcher) {
            try {
                val apiToken = authenticationRemoteDataSource.authenticateWithBackend(googleToken)
                DataResult.Success(apiToken)
            } catch (e: Exception) {
                DataResult.Error(CustomError.AUTHENTICATION_ERROR)
            }
        }
}