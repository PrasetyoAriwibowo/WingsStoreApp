package com.android.wingsstoreapp.fragment.product

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.common.entity.CheckoutEntity
import com.android.common.entity.ProductEntity
import com.android.wingsstoreapp.databinding.ProductItemLayoutBinding
import com.bumptech.glide.Glide

class ProductAdapter(val navigate: (ProductEntity)-> Unit, val insertProducttoCheckout:(CheckoutEntity)->Unit) : RecyclerView.Adapter<ProductViewHolder>() {

    private val differ = AsyncListDiffer<ProductEntity>(this, itemCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ProductItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.data = data

        if (data.discount.toString().equals("0.0")){
            holder.binding.productPrice.text = "Rp. ${data.price}"
            holder.binding.productDiscount.visibility = View.GONE
        } else {
            holder.binding.productPrice.text = "Rp. ${data.price - (data.price * data.discount / 100)}"
            holder.binding.productDiscount.text = "Rp. ${data.price}"
        }

        Glide.with(holder.binding.imgProductList)
            .load(data.photo).into(holder.binding.imgProductList)

        holder.binding.constraintProduct.setOnClickListener {
            navigate(data)
        }

        holder.binding.btnAddProduct.setOnClickListener {
            insertProducttoCheckout(CheckoutEntity(data.productCode, 1))
        }
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitData(data: List<ProductEntity>) {
        differ.submitList(data)
    }

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<ProductEntity>() {
            override fun areItemsTheSame(oldItem: ProductEntity, newItem: ProductEntity): Boolean {
                return oldItem.productCode == newItem.productCode
            }

            override fun areContentsTheSame(
                oldItem: ProductEntity,
                newItem: ProductEntity
            ): Boolean {
                return true
            }
        }
    }
}

class ProductViewHolder(val binding: ProductItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)