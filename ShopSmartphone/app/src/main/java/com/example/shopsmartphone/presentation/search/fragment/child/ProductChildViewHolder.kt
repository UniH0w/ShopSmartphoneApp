package com.example.shopsmartphone.presentation.search.fragment.child

import androidx.recyclerview.widget.RecyclerView
import com.example.shopsmartphone.data.ProductModel
import com.example.shopsmartphone.databinding.ProductItemBinding

class ProductChildViewHolder(private val binding: ProductItemBinding
) : RecyclerView.ViewHolder(binding.root) {
 fun bind(productModel: ProductModel, itemClick: (Int) -> Unit)
 {
     binding.textViewName.text = productModel.manufacturer
     binding.textViewPrice.text = productModel.price
     binding.imageButtonOrder.setOnClickListener {
         itemClick.invoke(productModel.id)

     }

 }
}