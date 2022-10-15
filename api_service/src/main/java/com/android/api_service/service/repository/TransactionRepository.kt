package com.android.api_service.service.repository

import androidx.lifecycle.LiveData
import com.android.api_service.service.dao.ProductDao
import com.android.api_service.service.dao.TransactionDao
import com.android.common.entity.ProductCheckout
import com.android.common.entity.TransactionHeaderEntity
import com.android.common.ext.AppExecutors

class TransactionRepository(
    private val transactionDao: TransactionDao,
) {
    fun getTransaction(): LiveData<List<TransactionHeaderEntity>> = transactionDao.getTransaction()

}