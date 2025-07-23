package com.example.rajbaricity.service
import com.example.rajbaricity.model.Product

interface ProductService {
    fun getAll(): List<Product>
    fun getByType(isNew: Boolean): List<Product>
    fun search(query: String): List<Product>
    fun save(product: Product): Product
}
