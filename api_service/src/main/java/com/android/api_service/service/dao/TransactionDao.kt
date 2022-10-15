package com.android.api_service.service.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.android.common.entity.ProductEntity
import com.android.common.entity.TransactionHeaderEntity

@Dao
interface TransactionDao {
    @Query("SELECT * FROM transactionHeader")
    fun getTransaction(): LiveData<List<TransactionHeaderEntity>>
}