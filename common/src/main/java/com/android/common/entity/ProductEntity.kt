package com.android.common.entity

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "product")
data class ProductEntity (
    @PrimaryKey
    @field:ColumnInfo(name = "productCode")
    val productCode: String,

    @field:ColumnInfo(name = "productName")
    val productName: String,

    @field:ColumnInfo(name = "price")
    val price: Double,

    @field:ColumnInfo(name = "currency")
    val currency: String,

    @field:ColumnInfo(name = "discount")
    val discount: Double,

    @field:ColumnInfo(name = "dimension")
    val dimension: String,

    @field:ColumnInfo(name = "unit")
    val unit: String
    ): Parcelable