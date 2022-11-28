package com.exam.lista_de_la_compra

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.lista_de_la_compra.adapters.CarritoAdapter
import com.exam.lista_de_la_compra.adapters.StoreAdapter
import com.exam.lista_de_la_compra.const.CART_EXTRA
import com.exam.lista_de_la_compra.repositories.Cart

class CarritoActivity : AppCompatActivity() {

    lateinit var carrito: Cart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_carrito)

        carrito = intent.getSerializableExtra(CART_EXTRA) as Cart

        val recycleCarrito = findViewById<RecyclerView>(R.id.recyclerCarrito)
        val totalCompra = findViewById<TextView>(R.id.totalPrice)

        val carritoAdapter = CarritoAdapter(
            carrito.getProducts()
        )

        recycleCarrito.adapter = carritoAdapter
        recycleCarrito.layoutManager = LinearLayoutManager(this)

        //Calculo de la suma de todos los productos usando stream api
        totalCompra.text = carrito.getProducts().sumOf { it.price }.toString() + "€"
    }
}