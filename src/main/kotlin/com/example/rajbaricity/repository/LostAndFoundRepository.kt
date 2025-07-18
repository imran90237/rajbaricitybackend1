package com.example.rajbaricity.repository

import com.example.rajbaricity.model.LostAndFoundItem
import org.springframework.data.jpa.repository.JpaRepository

interface LostAndFoundRepository : JpaRepository<LostAndFoundItem, Long> {
    fun findByStatus(status: String): List<LostAndFoundItem>
}
