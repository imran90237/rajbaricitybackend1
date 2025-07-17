package com.example.rajbaricity.service

import com.example.rajbaricity.model.Bustime

interface BustimeService {
    fun getAll(): List<Bustime>
    fun getById(id: Long): Bustime?
    fun save(bustime: Bustime): Bustime
    fun update(id: Long, bustime: Bustime): Bustime?
    fun delete(id: Long): Boolean
}
