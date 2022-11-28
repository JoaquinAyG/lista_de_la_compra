package com.exam.lista_de_la_compra.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.exam.lista_de_la_compra.R
import com.exam.lista_de_la_compra.models.Product

class CarritoAdapter(
    private val list: MutableList<Product>
) : RecyclerView.Adapter<CarritoAdapter.ProductViewHolder>() {
     

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = ViewGroup.inflate(parent.context, R.layout.carrito_item, null)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class ProductViewHolder(
        itemView: View,

    ) : RecyclerView.ViewHolder(itemView) {

        private val name: TextView = itemView.findViewById(R.id.c_name)
        private val price: TextView = itemView.findViewById(R.id.c_price)

        fun bind(product: Product) {
            name.text = product.name
            price.text = product.price.toString() + "€"
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }
}