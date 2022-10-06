package com.android.api_service.service.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.android.api_service.service.dao.ProductDao
import com.android.common.entity.ProductEntity
import com.android.common.ext.AppExecutors

class ProductRepository(
    private val productDao: ProductDao,
    private val appExecutors: AppExecutors
) {
    private val listProduct = MediatorLiveData<List<ProductEntity>>()

    fun getProduct(): LiveData<List<ProductEntity>> {
        val data = productDao.getProduct()
        val data1 = productDao.getProduct()

        listProduct.addSource(data) {
            if (it.isEmpty()) {
                appExecutors.diskIO.execute {
                    productDao.insertProduct(
                        ProductEntity(
                            "SKLNPW135",
                            "So Klin Pewangi",
                            15000.0,
                            "IDR",
                            10.0,
                            "25cm x 15cm x 10cm",
                            "Pcs"
                        )
                    )
                    productDao.insertProduct(
                        ProductEntity(
                            "GVB11",
                            "Giv Biru",
                            11000.0,
                            "IDR",
                            0.0,
                            "10cm x 5cm x 3cm",
                            "Pcs"
                        )
                    )
                    productDao.insertProduct(
                        ProductEntity(
                            "SKLNLQ11",
                            "So Klin Liquid",
                            18000.0,
                            "IDR",
                            0.0,
                            "25cm x 15cm x 10cm",
                            "Pcs"
                        )
                    )
                    productDao.insertProduct(
                        ProductEntity(
                            "GVK10",
                            "Giv Kuning",
                            10000.0,
                            "IDR",
                            0.0,
                            "10cm x 5cm x 3cm",
                            "Pcs"
                        )
                    )
                }
            }
        }

        listProduct.addSource(data1) {
            listProduct.value = it
        }
        return listProduct
    }
}