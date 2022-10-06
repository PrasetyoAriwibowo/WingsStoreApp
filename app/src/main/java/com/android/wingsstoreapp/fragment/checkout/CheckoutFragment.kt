package com.android.wingsstoreapp.fragment.checkout

import androidx.fragment.app.viewModels
import com.android.common.BaseFragment
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.CheckoutLayoutBinding
import com.android.wingsstoreapp.databinding.CheckoutLayoutBindingImpl
import com.android.wingsstoreapp.view_model.CheckoutViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CheckoutFragment : BaseFragment<CheckoutViewModel, CheckoutLayoutBinding>() {
    override val vm: CheckoutViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.checkout_layout

    val adapter = CheckoutAdapter{
        setTotal()
    }

    override fun initBinding(binding: CheckoutLayoutBinding) {
        super.initBinding(binding)

        binding.rvCheckout.adapter = adapter
        vm.checkoutData?.observe(viewLifecycleOwner) {
            adapter.submitData(it)

            setTotal()
        }
    }

    fun setTotal() {
        var total: Double = 0.0

        adapter.total.forEach {
            total += it.value
        }
        binding.txtTotalPriceCheckout.text ="Rp. $total"
    }

}