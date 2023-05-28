package com.example.shopsmartphone.presentation.search.fragment.xiaomiProduct.child

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.ProductItemBinding

class XiaomiChildAdapter : RecyclerView.Adapter<XiaomiChildViewHolder>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {
    }
    var onItemLongClick: (Int) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): XiaomiChildViewHolder {
        return XiaomiChildViewHolder(
            ProductItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }
    //@RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: XiaomiChildViewHolder, position: Int) {
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
