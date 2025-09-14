package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Shopping
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ProductRepository : JpaRepository<Shopping, Long> {
    fun findByIsNew(isNew: Boolean): List<Shopping>
    fun findByTitleContainingIgnoreCaseOrDetailsContainingIgnoreCase(query1: String, query2: String): List<Shopping>
}
