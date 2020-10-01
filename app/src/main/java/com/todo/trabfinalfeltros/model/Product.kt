package com.todo.trabfinalfeltros.model

import java.io.Serializable

data class Product(
    var id: Long,
    var name: String,
    var description: String,
    var url_image: String,
    var price: String,
    var time: Int
) : Serializable {
    lateinit var materials: List<Material>
}

