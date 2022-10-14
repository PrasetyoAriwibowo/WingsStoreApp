package com.android.api_service.service.preference

import com.android.common.entity.LoginEntity

interface AuthDbService {
    fun login(loginEntity: LoginEntity)
    fun logout()
    fun getUser() : String
}