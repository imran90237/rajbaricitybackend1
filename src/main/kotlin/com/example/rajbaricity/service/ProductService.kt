package com.example.rajbaricity.service
import com.example.rajbaricity.model.Shopping

interface ProductService {
    fun getAll(): List<Shopping>
    fun getByType(isNew: Boolean): List<Shopping>
    fun search(query: String): List<Shopping>
    fun save(product: Shopping): Shopping
}
