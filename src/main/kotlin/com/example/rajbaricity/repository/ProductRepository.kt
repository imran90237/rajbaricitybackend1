package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Product, Long> {
    fun findByIsNew(isNew: Boolean): List<Product>
    fun findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(query1: String, query2: String): List<Product>
}
