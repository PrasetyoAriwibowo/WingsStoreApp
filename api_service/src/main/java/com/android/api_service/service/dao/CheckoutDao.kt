package com.android.api_service.service.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.android.common.entity.CheckoutEntity
import com.android.common.entity.ProductCheckout
import com.android.common.entity.ProductEntity

@Dao
interface CheckoutDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertCheckout(checkoutEntity: CheckoutEntity)

    @Query("SELECT * FROM checkout")
    fun getCheckout(): LiveData<List<ProductCheckout>>

    @Update(entity = CheckoutEntity::class)
    fun updateCheckout(checkoutEntity: CheckoutEntity)

    @Query("DELETE FROM checkout WHERE productCode = :productCode")
    fun deleteProductCheckout(productCode: String)

    @Query("SELECT * FROM product WHERE productCode = :productCode")
    fun getProductCheckoutFromProduct(productCode: String): LiveData<ProductEntity>
}