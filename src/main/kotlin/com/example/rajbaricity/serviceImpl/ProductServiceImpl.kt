package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Shopping
import com.example.rajbaricity.repository.ProductRepository
import com.example.rajbaricity.service.ProductService
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl(private val repo: ProductRepository) : ProductService {
    override fun getAll(): List<Shopping> = repo.findAll()

    override fun getByType(isNew: Boolean): List<Shopping> = repo.findByIsNew(isNew)

    override fun search(query: String): List<Shopping> =
        repo.findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(query, query)

    override fun save(product: Shopping): Shopping = repo.save(product)
}
