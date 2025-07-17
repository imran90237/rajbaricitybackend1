package com.example.rajbaricity.service

import com.example.rajbaricity.model.Hospital

interface HospitalService {
    fun getAll(): List<Hospital>
    fun getById(id: Long): Hospital?
    fun save(hospital: Hospital): Hospital
    fun update(id: Long, hospital: Hospital): Hospital?
    fun delete(id: Long): Boolean
}
