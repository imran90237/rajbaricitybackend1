package com.example.rajbaricity.service

import com.example.rajbaricity.model.Nursery

interface NurseryService {
    fun saveNursery(nursery: Nursery): Nursery
    fun getAllNurseries(): List<Nursery>
    fun getNurseryById(id: Long): Nursery?
    fun deleteNursery(id: Long)
}
