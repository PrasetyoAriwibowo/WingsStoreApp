package com.android.common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "login")
data class LoginEntity (
    @PrimaryKey
    @field:ColumnInfo(name = "userName")
    val userName: String,
    @field:ColumnInfo(name = "password")
    val password: String
    )