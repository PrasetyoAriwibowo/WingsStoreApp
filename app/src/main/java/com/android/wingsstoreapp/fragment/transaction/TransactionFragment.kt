package com.android.wingsstoreapp.fragment.transaction

import androidx.fragment.app.viewModels
import com.android.common.BaseFragment
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.TransactionListLayoutBinding
import com.android.wingsstoreapp.view_model.TransactionViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TransactionFragment: BaseFragment<TransactionViewModel, TransactionListLayoutBinding>() {
    override val vm: TransactionViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.transaction_list_layout

    val adapter = TransactionAdapter()

    override fun initBinding(binding: TransactionListLayoutBinding) {
        super.initBinding(binding)

        binding.rvTransactionList.adapter = adapter

        vm.transactionData?.observe(viewLifecycleOwner){
            adapter.submitData(it)
        }
    }
}