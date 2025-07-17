package com.example.rajbaricity.service

import com.example.rajbaricity.model.BloodDonor

interface BloodDonorService {
    fun getAll(): List<BloodDonor>
    fun getById(id: Long): BloodDonor?
    fun save(donor: BloodDonor): BloodDonor
    fun update(id: Long, donor: BloodDonor): BloodDonor?
    fun delete(id: Long): Boolean
}
