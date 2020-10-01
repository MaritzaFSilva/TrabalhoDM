package com.todo.trabfinalfeltros.fragments

import com.todo.trabfinalfeltros.model.Product


interface ProductListFragmentListener {
    fun onProductSelected(product: Product)
}