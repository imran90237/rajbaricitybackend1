package com.example.rajbaricity.service

import com.example.rajbaricity.model.LostAndFound

interface LostAndFoundService {
    fun getAll(): List<LostAndFound>
    fun getAllByStatus(status: String): List<LostAndFound>
    fun getById(id: Long): LostAndFound?
    fun save(item: LostAndFound): LostAndFound
    fun update(id: Long, updatedItem: LostAndFound): LostAndFound?
    fun delete(id: Long): Boolean
}
