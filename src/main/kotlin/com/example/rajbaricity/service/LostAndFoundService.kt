package com.example.rajbaricity.service

import com.example.rajbaricity.model.LostAndFoundItem

interface LostAndFoundService {
    fun getAll(): List<LostAndFoundItem>
    fun getAllByStatus(status: String): List<LostAndFoundItem>
    fun getById(id: Long): LostAndFoundItem?
    fun save(item: LostAndFoundItem): LostAndFoundItem
    fun update(id: Long, updatedItem: LostAndFoundItem): LostAndFoundItem?
    fun delete(id: Long): Boolean
}
