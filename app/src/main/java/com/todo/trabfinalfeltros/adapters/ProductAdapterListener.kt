package com.todo.trabfinalfeltros.adapters

import com.todo.trabfinalfeltros.model.Product


interface ProductAdapterListener {
    fun onProductSelected(product: Product)
}