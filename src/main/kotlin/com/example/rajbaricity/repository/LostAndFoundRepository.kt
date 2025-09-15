package com.example.rajbaricity.repository

import com.example.rajbaricity.model.LostAndFound
import org.springframework.data.jpa.repository.JpaRepository

interface LostAndFoundRepository : JpaRepository<LostAndFound, Long> {
    fun findByStatus(status: String): List<LostAndFound>
}
