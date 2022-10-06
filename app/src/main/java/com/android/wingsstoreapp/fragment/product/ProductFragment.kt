package com.android.wingsstoreapp.fragment.product

import android.content.Intent
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.android.common.BaseFragment
import com.android.common.ResponseLoading
import com.android.common.ResponseSuccess
import com.android.common.entity.ProductEntity
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.ProductListLayoutBinding
import com.android.wingsstoreapp.fragment.LoginFragmentDirections
import com.android.wingsstoreapp.view_model.ProductViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment: BaseFragment<ProductViewModel, ProductListLayoutBinding>() {
    override val vm: ProductViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.product_list_layout


    val adapter = ProductAdapter{
        findNavController().navigate(
            ProductFragmentDirections.productFragmentToProductDetailFragment(it)
        )
    }

    override fun initBinding(binding: ProductListLayoutBinding) {
        super.initBinding(binding)

        binding.rvProductList.adapter = adapter

        vm.productData?.observe(viewLifecycleOwner){
            adapter.submitData(it)
        }

        binding.btnCheckout.setOnClickListener {
            findNavController().navigate(
                ProductFragmentDirections.productDetailFragmentToCheckoutFragment()
            )
        }

    }
}