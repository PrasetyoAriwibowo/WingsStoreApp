package com.android.wingsstoreapp.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.android.api_service.service.repository.LoginRepository
import com.android.common.AppResponse
import com.android.common.BaseViewModel
import com.android.common.entity.LoginEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    application: Application,
    private val loginRepository: LoginRepository
) : BaseViewModel(application) {
    var loginData: LiveData<AppResponse<LoginEntity>>? = null

    fun login(loginEntity: LoginEntity){
        viewModelScope.launch {
            loginData = loginRepository.getUser(loginEntity)
        }
    }
}