package com.example.rajbaricity.service

import com.example.rajbaricity.model.EmergencyContact

interface EmergencyContactService {
    fun getAll(): List<EmergencyContact>
    fun getById(id: Long): EmergencyContact?
    fun save(info: EmergencyContact): EmergencyContact
    fun update(id: Long, info: EmergencyContact): EmergencyContact?
    fun delete(id: Long): Boolean
}
