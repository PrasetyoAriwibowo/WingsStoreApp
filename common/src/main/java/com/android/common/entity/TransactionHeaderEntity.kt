package com.android.common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDateTime
import java.util.*

@Entity(tableName = "transactionHeader")
data class TransactionHeaderEntity (

    @PrimaryKey(autoGenerate = true)
    @field:ColumnInfo(name = "documentCode")
    val documentCode: Int,

    @field:ColumnInfo(name = "documentNumber")
    val documentNumber: String,

    @field:ColumnInfo(name = "userName")
    val userName: String,

    @field:ColumnInfo(name = "total")
    val total: Double,

    @field:ColumnInfo(name = "date")
    val date: String
)