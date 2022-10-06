package com.android.api_service.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.android.api_service.service.dao.CheckoutDao
import com.android.common.entity.CheckoutEntity
import com.android.common.entity.ProductCheckout
import com.android.common.entity.ProductEntity
import com.android.common.ext.AppExecutors

class CheckoutRepository(
    private val checkoutDao: CheckoutDao,
    private val appExecutors: AppExecutors
) {
    private val listProduct = MediatorLiveData<List<CheckoutEntity>>()

    fun insertProductCheckout(checkoutEntity: CheckoutEntity){
        appExecutors.diskIO.execute{
            checkoutDao.insertCheckout(checkoutEntity)
        }
    }

    fun updateQuantityProduct(checkoutEntity: CheckoutEntity){
        appExecutors.diskIO.execute{
            checkoutDao.updateCheckout(checkoutEntity)
        }
    }

    fun getProductCheckout() : LiveData<List<ProductCheckout>> = checkoutDao.getCheckout()

}