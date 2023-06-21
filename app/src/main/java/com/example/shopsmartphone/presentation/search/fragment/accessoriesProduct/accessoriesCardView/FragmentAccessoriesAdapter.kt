package com.example.shopsmartphone.presentation.search.fragment.accessoriesProduct.accessoriesCardView

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.FragmentCardViewItemBinding

class FragmentAccessoriesAdapter: RecyclerView.Adapter<AccessoriesViewHolder>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccessoriesViewHolder {
        return AccessoriesViewHolder(
            FragmentCardViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AccessoriesViewHolder, position: Int) {
        holder.bind(items[position], itemClick)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(tasks: List<Product>) {
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }
}


