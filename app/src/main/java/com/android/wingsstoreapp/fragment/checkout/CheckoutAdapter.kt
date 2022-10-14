package com.android.wingsstoreapp.fragment.checkout

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.common.entity.ProductCheckout
import com.android.common.entity.ProductEntity
import com.android.wingsstoreapp.databinding.CheckoutItemLayoutBinding
import com.bumptech.glide.Glide

class CheckoutAdapter(val setTotal: () -> Unit, val deleteProductCheckout: (ProductCheckout) -> Unit) : RecyclerView.Adapter<CheckoutViewHolder>() {

    val total = mutableMapOf<ProductEntity, Double>()
    private val differ = AsyncListDiffer<ProductCheckout>(this, CheckoutAdapter.itemCallBack)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckoutViewHolder {
        return CheckoutViewHolder(
            CheckoutItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CheckoutViewHolder, position: Int) {
        val data = differ.currentList[position]
        holder.binding.data = data.productEntity

        Glide.with(holder.binding.imgProductCheckout).load(data.productEntity.photo)
            .into(holder.binding.imgProductCheckout)

        holder.binding.qtyProduct.setText("1")

        setTotal(
            data.productEntity,
            data.productEntity.price * holder.binding.qtyProduct.text.toString().toInt()
        )

        holder.binding.qtyProduct.addTextChangedListener {
            var subTotal = if (!it.isNullOrEmpty())

                (Integer.valueOf(it.toString())) * data.productEntity.price -
                        (data.productEntity.price * data.productEntity.discount / 100)
            else 0.0
            if (it.isNullOrEmpty() || it.equals("0")) {
                data.checkoutEntity.quantity = 1
            } else {
                data.checkoutEntity.quantity = it.toString().toInt()
//                holder.binding.imgMinus.isEnabled = false
                holder.binding.imgMinus.isEnabled = it.toString().toInt() > 1

            }
            holder.binding.subTotalProduct.text = "Rp. $subTotal"

            total[data.productEntity] = subTotal

            setTotal()
        }
        holder.binding.qtyProduct.setText(data.checkoutEntity.quantity.toString())

        holder.binding.imgAdd.setOnClickListener {
            data.checkoutEntity.quantity += 1
            holder.binding.qtyProduct.setText(data.checkoutEntity.quantity.toString())

        }

        holder.binding.imgMinus.setOnClickListener {
            data.checkoutEntity.quantity -= 1
            holder.binding.qtyProduct.setText(data.checkoutEntity.quantity.toString())
        }

        holder.binding.imgDelete.setOnClickListener {
            deleteProductCheckout(data)
        }

    }

    fun setTotal(productEntity: ProductEntity, subTotal: Double) {
        total[productEntity] = subTotal
    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitData(data: List<ProductCheckout>) {
        differ.submitList(data)
    }

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<ProductCheckout>() {
            override fun areItemsTheSame(
                oldItem: ProductCheckout,
                newItem: ProductCheckout
            ): Boolean {
                return oldItem.productEntity.productCode == newItem.productEntity.productCode
            }

            override fun areContentsTheSame(
                oldItem: ProductCheckout,
                newItem: ProductCheckout
            ): Boolean {
                return false
            }
        }
    }
}

class CheckoutViewHolder(val binding: CheckoutItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)