package com.exam.lista_de_la_compra

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.exam.lista_de_la_compra.adapters.StoreAdapter
import com.exam.lista_de_la_compra.const.CART_EXTRA
import com.exam.lista_de_la_compra.const.PRODUCT_EXTRA
import com.exam.lista_de_la_compra.const.RESULT_ADD
import com.exam.lista_de_la_compra.models.Product
import com.exam.lista_de_la_compra.repositories.Cart
import com.exam.lista_de_la_compra.repositories.Store


class MainActivity : AppCompatActivity() {

    private val cart = Cart()
    private val store = Store()

    private val activityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()) {
        when (it.resultCode) {
            RESULT_ADD -> {
                val product = it.data?.getSerializableExtra(PRODUCT_EXTRA) as Product
                addProduct(product)
                Toast.makeText(this, "Product added to cart", Toast.LENGTH_SHORT).show()
            }
            RESULT_OK -> {}
            RESULT_CANCELED -> Toast.makeText(this, "Product not added to cart", Toast.LENGTH_SHORT).show()
            else -> Toast.makeText(this, "Product not added to cart", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycleStore = findViewById<RecyclerView>(R.id.recyclerStore)

        val storeAdapter = StoreAdapter(
            store.getProducts(),
            onClick = { startProductActivity(it) },
            onLongClick = { addProduct(it)  }
        )

        recycleStore.adapter = storeAdapter
        recycleStore.layoutManager = LinearLayoutManager(this)

    }

    private fun addProduct(product: Product) {
        if(cart.contains(product)) {
            Toast.makeText(
                this,
                "Product already in cart",
                Toast.LENGTH_SHORT
            ).show()
            return
        }
        cart.addProduct(product)
        Toast.makeText(
            this,
            "Product added",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun startProductActivity(product: Product) {
        val intent = Intent(this, ProductoActivity::class.java)
        intent.putExtra(PRODUCT_EXTRA, product)
        activityResultLauncher.launch(intent)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_appbar, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_formulario -> {
                val intent = Intent(this, FormularioActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.menu_carrito -> {
                val intent = Intent(this, CarritoActivity::class.java)
                intent.putExtra(CART_EXTRA, cart)
                startActivity(intent)
                true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }
}