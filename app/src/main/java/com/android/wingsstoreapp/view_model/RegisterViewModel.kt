package com.android.wingsstoreapp.view_model

import android.app.Application
import com.android.api_service.service.repository.LoginRepository
import com.android.common.BaseViewModel
import com.android.common.entity.LoginEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class RegisterViewModel @Inject constructor(
    application: Application,
    private val loginRepository: LoginRepository
): BaseViewModel(application) {

    fun register(loginEntity: LoginEntity){
        loginRepository.insertUser(loginEntity)
    }
}