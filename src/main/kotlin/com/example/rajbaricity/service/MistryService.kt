package com.example.rajbaricity.service

import com.example.rajbaricity.model.Mistry

interface MistryService {
    fun getAll(): List<Mistry>
    fun getById(id: Long): Mistry?
    fun save(mistry: Mistry): Mistry
    fun update(id: Long, mistry: Mistry): Mistry?
    fun delete(id: Long): Boolean
}
