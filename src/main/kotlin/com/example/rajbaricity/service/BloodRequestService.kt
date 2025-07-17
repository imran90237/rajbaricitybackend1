package com.example.rajbaricity.service

import com.example.rajbaricity.model.BloodRequest


interface BloodRequestService {
    fun getAll(): List<BloodRequest>
    fun getById(id: Long): BloodRequest?
    fun save(request: BloodRequest): BloodRequest
    fun update(id: Long, request: BloodRequest): BloodRequest?
    fun delete(id: Long): Boolean
}
