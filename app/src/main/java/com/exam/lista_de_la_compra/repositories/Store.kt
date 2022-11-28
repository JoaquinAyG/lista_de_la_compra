package com.exam.lista_de_la_compra.repositories

import com.exam.lista_de_la_compra.models.Product

class Store()  {
    companion object {
        var products = mutableListOf(Product(1, "Leche", 1.5),
        Product(2, "Pan", 0.5),
        Product(3, "Huevos", 2.0),
        Product(4, "Cerveza", 1.0),
        Product(5, "Patatas", 1.5),
        Product(6, "Coca-Cola", 1.5),
        Product(7, "Café", 1.5),
        Product(8, "Té", 1.5),
        Product(9, "Galletas", 1.5),
        Product(10, "Chorizo", 1.5),
        )
    }
    fun getProducts(): MutableList<Product> {
        return products
    }

    fun contains(product: Product): Boolean {
        return products.contains(product)
    }

}