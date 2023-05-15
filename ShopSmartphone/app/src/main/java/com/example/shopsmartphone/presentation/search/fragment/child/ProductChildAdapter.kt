package com.example.shopsmartphone.presentation.search.fragment.child

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.shopsmartphone.data.ProductModel
import com.example.shopsmartphone.databinding.ProductItemBinding

class ProductChildAdapter : RecyclerView.Adapter<ProductChildViewHolder>() {
    val items = mutableListOf<ProductModel>()
    var itemClick: (Int ) -> Unit = {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductChildViewHolder {
       return ProductChildViewHolder(ProductItemBinding.inflate(LayoutInflater.from(parent.context),parent,false))
    }
    override fun onBindViewHolder(holder: ProductChildViewHolder, position: Int) {
        holder.bind(items[position], itemClick)
    }

    override fun getItemCount() = items.size

    fun submitList(product: List<ProductModel>){
        items.clear()
        items.addAll(product)
        notifyDataSetChanged()
    }
}
