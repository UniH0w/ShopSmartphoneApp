package com.example.shopsmartphone.presentation.search.fragment.accessoriesProduct.child

import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.ProductItemBinding

class AccessoriesChildViewHolder(private val binding: ProductItemBinding
) : RecyclerView.ViewHolder(binding.root) {
 fun bind(product: Product, itemClick: (Int) -> Unit)
 {
     binding.textViewName.text = product.model
     binding.textViewPrice.text = product.price
     binding.imageButtonOrder.setOnClickListener {
         itemClick.invoke(product.id.toInt())



     }

 }
}