package com.android.wingsstoreapp.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import com.android.api_service.service.repository.ProductRepository
import com.android.common.AppResponse
import com.android.common.BaseViewModel
import com.android.common.entity.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    application: Application,
    private val productRepository: ProductRepository
): BaseViewModel(application) {

    var productData : LiveData<List<ProductEntity>>? = null

    init {
        productData = productRepository.getProduct()
    }
}