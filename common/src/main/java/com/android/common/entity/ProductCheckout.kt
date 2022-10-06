package com.android.common.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ProductCheckout (

    @Embedded
    val checkoutEntity: CheckoutEntity,

    @Relation(
        parentColumn = "productCode",
        entityColumn = "productCode"
    )
    val productEntity : ProductEntity
)