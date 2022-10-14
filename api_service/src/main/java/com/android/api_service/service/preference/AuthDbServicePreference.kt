package com.android.api_service.service.preference

import android.content.Context
import android.preference.PreferenceManager
import com.android.common.entity.LoginEntity

class AuthDbServicePreference(val context: Context): AuthDbService {

    val preferences = PreferenceManager.getDefaultSharedPreferences(context)

    companion object Constants {
        const val KEY_USER_TOKEN = "USER_TOKEN"
        const val USER = "USER"
    }

    override fun login(loginEntity: LoginEntity) {
        preferences.edit().putString(USER, loginEntity.userName).apply()
    }

    override fun logout() {

    }

    override fun getUser(): String =
        preferences.getString(USER, "")?:""

}