package com.android.api_service.service.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.common.entity.LoginEntity

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRegister(loginEntity: LoginEntity)

    @Query("SELECT * FROM login WHERE userName =:userName")
    fun getUser(userName: String): LiveData<LoginEntity>
}