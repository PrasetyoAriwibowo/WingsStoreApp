package com.android.wingsstoreapp.fragment.checkout

import android.widget.Toast
import androidx.fragment.app.viewModels
import com.android.api_service.service.repository.CheckoutRepository
import com.android.common.BaseFragment
import com.android.common.entity.CheckoutEntity
import com.android.common.entity.ProductCheckout
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.CheckoutLayoutBinding
import com.android.wingsstoreapp.databinding.CheckoutLayoutBindingImpl
import com.android.wingsstoreapp.view_model.CheckoutViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckoutFragment : BaseFragment<CheckoutViewModel, CheckoutLayoutBinding>() {
    override val vm: CheckoutViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.checkout_layout

    val adapter = CheckoutAdapter({
        setTotal()
    },
        deleteProductCheckout = {
           vm.deleteCheckout(it)
        })

    override fun initBinding(binding: CheckoutLayoutBinding) {
        super.initBinding(binding)

        binding.rvCheckout.adapter = adapter
        vm.checkoutData?.observe(viewLifecycleOwner) {
            adapter.submitData(it)
            it.forEach {
                vm.totalData[it] =
                    it.productEntity.price - (it.productEntity.price * it.productEntity.discount / 100)
            }
            setTotal()
        }

        binding.btnConfirmCheckout.setOnClickListener {
            vm.insertCheckouttoTransaction()
            vm.deleteAllCheckout()

            Toast.makeText(requireContext(), "Transaksi di Berhasil", 1).show()
        }

    }

    fun setTotal() {
        var total: Double = 0.0

        adapter.total.forEach {
            total += it.value
        }
        binding.txtTotalPriceCheckout.text = "Rp. $total"
    }
}