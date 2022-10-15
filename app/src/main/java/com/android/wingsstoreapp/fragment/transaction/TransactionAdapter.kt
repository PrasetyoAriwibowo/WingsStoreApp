package com.android.wingsstoreapp.fragment.transaction

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.android.common.entity.TransactionHeaderEntity
import com.android.wingsstoreapp.databinding.TransactionItemLayoutBinding

class TransactionAdapter() : RecyclerView.Adapter<TransactionViewHolder>() {

    private val differ = AsyncListDiffer<TransactionHeaderEntity>(this, itemCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        return TransactionViewHolder(
            TransactionItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val data = differ.currentList[position]

        holder.binding.total.text = "Rp. ${data.total}"
        holder.binding.date.text = data.date.toString()
        holder.binding.documentNumber.text = data.documentNumber

    }

    override fun getItemCount(): Int = differ.currentList.size

    fun submitData(data: List<TransactionHeaderEntity>) {
        differ.submitList(data)
    }

    companion object {
        val itemCallBack = object : DiffUtil.ItemCallback<TransactionHeaderEntity>() {
            override fun areItemsTheSame(
                oldItem: TransactionHeaderEntity,
                newItem: TransactionHeaderEntity
            ): Boolean {
                return oldItem.documentCode == newItem.documentCode
            }

            override fun areContentsTheSame(
                oldItem: TransactionHeaderEntity,
                newItem: TransactionHeaderEntity
            ): Boolean {
                return false
            }
        }
    }
}

class TransactionViewHolder(val binding: TransactionItemLayoutBinding) :
    RecyclerView.ViewHolder(binding.root)