package com.android.wingsstoreapp.view_model

import android.app.Application
import androidx.lifecycle.LiveData
import com.android.api_service.service.repository.TransactionRepository
import com.android.common.BaseViewModel
import com.android.common.entity.ProductCheckout
import com.android.common.entity.TransactionHeaderEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TransactionViewModel @Inject constructor(
    application: Application,
    private val transactionRepository: TransactionRepository
): BaseViewModel(application) {

    var transactionData : LiveData<List<TransactionHeaderEntity>>? = null

    init {
        transactionData = transactionRepository.getTransaction()
    }
}