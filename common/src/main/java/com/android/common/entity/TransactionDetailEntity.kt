package com.android.common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "transactionDetail")
data class TransactionDetailEntity (
    @field:ColumnInfo(name = "documentCode")
    val documentCode: String,

    @PrimaryKey
    @field:ColumnInfo(name = "documentNumber")
    val documentNumber: String,

    @field:ColumnInfo(name = "productCode")
    val productCode: String,

    @field:ColumnInfo(name = "price")
    val price: Double,

    @field:ColumnInfo(name = "quantity")
    val quantity: Int,

    @field:ColumnInfo(name = "unit")
    val unit: String,

    @field:ColumnInfo(name = "subTotal")
    val subTotal: Double,

    @field:ColumnInfo(name = "currency")
    val currency: String,
    )