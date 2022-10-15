package com.android.api_service.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.android.api_service.service.dao.CheckoutDao
import com.android.api_service.service.preference.AuthDbService
import com.android.common.entity.*
import com.android.common.ext.AppExecutors
import com.ashokvarma.gander.internal.data.TransactionDao
import java.time.LocalDateTime
import kotlin.random.Random

class CheckoutRepository(
    private val checkoutDao: CheckoutDao,
    private val appExecutors: AppExecutors,
    val authDbService: AuthDbService
) {
    private val listProduct = MediatorLiveData<List<CheckoutEntity>>()

    fun insertProductCheckout(checkoutEntity: CheckoutEntity) {
        appExecutors.diskIO.execute {
            checkoutDao.insertCheckout(checkoutEntity)
        }
    }

    fun updateQuantityProduct(checkoutEntity: CheckoutEntity) {
        appExecutors.diskIO.execute {
            checkoutDao.updateCheckout(checkoutEntity)
        }
    }

    fun getProductCheckout(): LiveData<List<ProductCheckout>> = checkoutDao.getCheckout()


    fun getPriceDiscount(price: Double, discount: Double) = price - (price * discount / 100)

    fun getSubTotal(productCheckout: ProductCheckout) =
        getPriceDiscount(
            productCheckout.productEntity.price,
            productCheckout.productEntity.discount
        ) * productCheckout.checkoutEntity.quantity

    fun getTotal(subTotalList: List<ProductCheckout>): Double {
        var total = 0.0
        subTotalList.forEach {
            total += getSubTotal(it)

        }
        return total
    }

    fun insertCheckoutTransaction(checkoutList: List<ProductCheckout>, total: Double) {

        val documentCode = 0
        val transactionDetail = arrayListOf<TransactionDetailEntity>()
        val date = LocalDateTime.now().toString()
        val number = Random.nextInt() + 3

        checkoutList.forEach {
            transactionDetail.add(
                TransactionDetailEntity(
                    documentCode,
                    "DCNB${documentCode + number}",
                    it.productEntity.productCode,
                    getPriceDiscount(it.productEntity.price, it.productEntity.discount),
                    it.checkoutEntity.quantity,
                    it.productEntity.unit,
                    getSubTotal(it),
                    it.productEntity.currency
                )
            )
        }

        appExecutors.diskIO.execute{
            checkoutDao.insertCheckouttoHeader(
                TransactionHeaderEntity(
                    documentCode,
                    "DCNB${documentCode + number + 3}",
                    authDbService.getUser(),
                    total,
                    date
                )
            )
            checkoutDao.insertCheckouttoDetail(transactionDetail)
        }
    }

    fun deleteProductCheckout(checkoutEntity: CheckoutEntity){
        appExecutors.diskIO.execute{
            checkoutDao.deleteProductCheckout(checkoutEntity.productCode)
        }
    }

    fun deleteAllProductCheckout(){
        appExecutors.diskIO.execute{
            checkoutDao.deleteAllProductCheckout()
        }
    }
}