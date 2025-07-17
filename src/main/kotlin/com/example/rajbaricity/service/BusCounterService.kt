package com.example.rajbaricity.service

import com.example.rajbaricity.model.BusCounter

interface BusCounterService {
    fun getAll(): List<BusCounter>
    fun getById(id: Long): BusCounter?
    fun save(busCounter: BusCounter): BusCounter
    fun update(id: Long, busCounter: BusCounter): BusCounter?
    fun delete(id: Long): Boolean
}
