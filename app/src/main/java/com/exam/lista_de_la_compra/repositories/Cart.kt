package com.exam.lista_de_la_compra.repositories

import com.exam.lista_de_la_compra.models.Product

class Cart : java.io.Serializable{
    companion object {
        var products = mutableListOf<Product>()
    }

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(product: Product) {
        products.remove(product)
    }

    fun getProducts(): MutableList<Product> {
        return products
    }

    fun contains(product: Product): Boolean {
        return products.contains(product)
    }

}