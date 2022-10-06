package com.android.api_service.service.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.android.common.entity.LoginEntity
import com.android.common.entity.ProductEntity

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertProduct(productEntity: ProductEntity)

    @Query("SELECT * FROM product")
    fun getProduct(): LiveData<List<ProductEntity>>
}