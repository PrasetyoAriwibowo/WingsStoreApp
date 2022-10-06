package com.android.common.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "checkout")
class CheckoutEntity (

    @PrimaryKey
    @field:ColumnInfo(name = "productCode")
    val productCode: String,

    @field:ColumnInfo(name = "quantity")
    val quantity : Int,
)