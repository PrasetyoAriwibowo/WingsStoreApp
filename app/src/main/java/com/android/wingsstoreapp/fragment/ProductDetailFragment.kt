package com.android.wingsstoreapp.fragment

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.android.common.BaseFragment
import com.android.wingsstoreapp.R
import com.android.wingsstoreapp.databinding.ProductDetailLayoutBinding
import com.android.wingsstoreapp.view_model.ProductDetailViewModel
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductDetailFragment : BaseFragment<ProductDetailViewModel, ProductDetailLayoutBinding>() {
    override val vm: ProductDetailViewModel by viewModels()
    override val layoutResourceId: Int = R.layout.product_detail_layout

    private val navArgs by navArgs<ProductDetailFragmentArgs>()

    override fun initBinding(binding: ProductDetailLayoutBinding) {
        super.initBinding(binding)

        binding.productDetailName.text = navArgs.product.productName
        binding.productDimensionDetail.text = navArgs.product.dimension
        binding.productUnitDetail.text = navArgs.product.unit

        Glide.with(binding.imgProductDetail).load(navArgs.product.photo).into(binding.imgProductDetail)
        binding.productPriceDetail.text =
            "Rp. ${navArgs.product.price - (navArgs.product.price * navArgs.product.discount / 100)}"


        binding.btnBuy.setOnClickListener {

            vm.insertProductCheckout(navArgs.product.productCode)
            Toast.makeText(requireContext(), "Produk Telah di Tambahkan", 1).show()

        }
    }
}