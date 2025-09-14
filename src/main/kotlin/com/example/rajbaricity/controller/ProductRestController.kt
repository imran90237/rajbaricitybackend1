package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Shopping
import com.example.rajbaricity.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/products")
@CrossOrigin(origins = ["*"])
class ProductRestController(private val service: ProductService) {

    @GetMapping
    fun getAll(): List<Shopping> = service.getAll()

    @GetMapping("/type")
    fun getByType(@RequestParam isNew: Boolean): List<Shopping> = service.getByType(isNew)

    @GetMapping("/search")
    fun search(@RequestParam query: String): List<Shopping> = service.search(query)

    @PostMapping
    fun addProduct(@RequestBody product: Shopping): Shopping = service.save(product)
}
