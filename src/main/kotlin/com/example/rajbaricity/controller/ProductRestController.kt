package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Product
import com.example.rajbaricity.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = ["*"])
class ProductRestController(private val service: ProductService) {

    @GetMapping
    fun getAll(): List<Product> = service.getAll()

    @GetMapping("/type")
    fun getByType(@RequestParam isNew: Boolean): List<Product> = service.getByType(isNew)

    @GetMapping("/search")
    fun search(@RequestParam query: String): List<Product> = service.search(query)

    @PostMapping
    fun addProduct(@RequestBody product: Product): Product = service.save(product)
}
