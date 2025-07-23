package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Product
import com.example.rajbaricity.repository.ProductRepository
import com.example.rajbaricity.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val repo: ProductRepository) : ProductService {
    override fun getAll(): List<Product> = repo.findAll()

    override fun getByType(isNew: Boolean): List<Product> = repo.findByIsNew(isNew)

    override fun search(query: String): List<Product> =
        repo.findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(query, query)

    override fun save(product: Product): Product = repo.save(product)
}
