package com.android.wingsstoreapp.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.android.api_service.service.repository.CheckoutRepository
import com.android.common.BaseViewModel
import com.android.common.entity.CheckoutEntity
import com.android.common.entity.ProductCheckout
import com.android.common.entity.ProductEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CheckoutViewModel @Inject constructor(
    application: Application,
    private val checkoutRepository: CheckoutRepository
): BaseViewModel(application) {

    var checkoutData : LiveData<List<ProductCheckout>>? = null
//    val totalData : MutableMap<ProductEntity, Double> = mutableMapOf()

    fun updatetProductCheckout(checkoutEntity: CheckoutEntity){
            checkoutRepository.updateQuantityProduct(checkoutEntity)
    }

    init {
        checkoutData = checkoutRepository.getProductCheckout()
    }

}