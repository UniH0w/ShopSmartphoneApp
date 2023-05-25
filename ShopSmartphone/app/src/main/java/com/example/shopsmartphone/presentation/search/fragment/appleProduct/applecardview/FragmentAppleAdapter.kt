package com.example.shopsmartphone.presentation.search.fragment.appleProduct.applecardview

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.models.product.Product
import com.example.shopsmartphone.databinding.FragmentCardViewItemBinding

class FragmentAppleAdapter: RecyclerView.Adapter<AppleViewHolder>() {
    val items = mutableListOf<Product>()
    var itemClick: (Int) -> Unit = {

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppleViewHolder {
        return AppleViewHolder(
            FragmentCardViewItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: AppleViewHolder, position: Int) {
        holder.bind(items[position], itemClick)
    }

    @SuppressLint("NotifyDataSetChanged")
    fun submitList(tasks: List<Product>) {
        items.clear()
        items.addAll(tasks)
        notifyDataSetChanged()
    }
}


