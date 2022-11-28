package com.exam.lista_de_la_compra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.exam.lista_de_la_compra.const.PRODUCT_EXTRA
import com.exam.lista_de_la_compra.const.RESULT_ADD
import com.exam.lista_de_la_compra.models.Product

class ProductoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_producto)

        val product = intent.getSerializableExtra(PRODUCT_EXTRA) as Product

        val name = findViewById<TextView>(R.id.p_name)
        val price = findViewById<TextView>(R.id.p_price)

        val butAdd = findViewById<Button>(R.id.but_add)
        val butBack = findViewById<Button>(R.id.but_return)

        name.text = product.name
        price.text = product.price.toString()

        butAdd.setOnClickListener {
            val replyIntent = Intent()
            replyIntent.putExtra(PRODUCT_EXTRA, product)
            setResult(RESULT_ADD, replyIntent)
            finish()
        }

        butBack.setOnClickListener {
            finish()
        }
    }
}