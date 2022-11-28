package com.exam.lista_de_la_compra.adapters

import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.exam.lista_de_la_compra.R
import com.exam.lista_de_la_compra.models.Product

class StoreAdapter (
    private val list : MutableList<Product>,
    private val onClick: (Product) -> Unit,
    private val onLongClick: (Product) -> Unit
    ) : RecyclerView.Adapter<StoreAdapter.ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ViewGroup.inflate(parent.context, R.layout.store_item, null)
        return ProductViewHolder(view, onClick, onLongClick)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ProductViewHolder(
        itemView: View,
        private val onClick: (Product) -> Unit,
        private val onLongClick: (Product) -> Unit

    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.s_name)
        private val price: TextView = itemView.findViewById(R.id.s_price)

        fun bind(product: Product) {
            name.text = product.name
            price.text = product.price.toString() + "€"
            itemView.setOnClickListener { onClick(product) }
            itemView.setOnLongClickListener { onLongClick(product); true }
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

}