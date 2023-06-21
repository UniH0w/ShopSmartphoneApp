package com.example.shopsmartphone.presentation.search.fragment.huaweiProduct.child

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.ProductItemBinding

class HuaweiChildAdapter : RecyclerView.Adapter<HuaweiChildViewHolder>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {
    }
    var onItemLongClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HuaweiChildViewHolder {
        return HuaweiChildViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HuaweiChildViewHolder, position: Int) {
        holder.bind(items[position], itemClick,onItemLongClick)
    }

    override fun getItemCount() = items.size

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(product: List<Product>) {
        items.clear()
        items.addAll(product)
        notifyDataSetChanged()
    }
}
