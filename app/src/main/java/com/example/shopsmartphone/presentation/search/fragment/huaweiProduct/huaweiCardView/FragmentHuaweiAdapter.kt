package com.example.shopsmartphone.presentation.search.fragment.huaweiProduct.huaweiCardView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.FragmentCardViewItemBinding

class FragmentHuaweiAdapter: RecyclerView.Adapter<HuaweiViewHolder>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HuaweiViewHolder {
        return HuaweiViewHolder(
            FragmentCardViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: HuaweiViewHolder, position: Int) {
        holder.bind(items[position], itemClick)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(tasks: List<Product>) {
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }
}


