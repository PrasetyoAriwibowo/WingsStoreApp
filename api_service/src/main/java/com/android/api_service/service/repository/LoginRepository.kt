package com.android.api_service.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.android.api_service.service.dao.LoginDao
import com.android.api_service.service.preference.AuthDbService
import com.android.common.AppResponse
import com.android.common.entity.LoginEntity
import com.android.common.ext.AppExecutors
import okhttp3.ResponseBody.Companion.toResponseBody
import okhttp3.internal.http.HTTP_NOT_FOUND

class LoginRepository(
    private val loginDao: LoginDao,
    private val appExecutors: AppExecutors,
    private val authDbService: AuthDbService
) {
    private val liveDataLogin = MediatorLiveData<AppResponse<LoginEntity>>()
    fun getUser(loginEntity: LoginEntity): LiveData<AppResponse<LoginEntity>> {

        val dataLogin = loginDao.getUser(loginEntity.userName)

        liveDataLogin.addSource(dataLogin) {
            if (it == null|| it.password != loginEntity.password) {
                liveDataLogin.value = AppResponse.errorBackend(
                    HTTP_NOT_FOUND,
                    body = "Username or Password Invalid".toResponseBody()
                )
            } else {
                liveDataLogin.value = AppResponse.success(it)
                authDbService.login(it)
            }
        }
        return liveDataLogin
    }

    fun insertUser(loginEntity: LoginEntity) {
        appExecutors.diskIO.execute() {
            loginDao.insertRegister(loginEntity)
        }
    }
}