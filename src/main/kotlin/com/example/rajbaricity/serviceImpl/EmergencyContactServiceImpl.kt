package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.EmergencyContact
import com.example.rajbaricity.repository.EmergencyContactRepository
import com.example.rajbaricity.service.EmergencyContactService
import org.springframework.stereotype.Service

@Service
class EmergencyContactServiceImpl(
    private val repository: EmergencyContactRepository
) : EmergencyContactService {

    override fun getAll(): List<EmergencyContact> = repository.findAll()

    override fun getById(id: Long): EmergencyContact? =
        repository.findById(id).orElse(null)

    override fun save(info: EmergencyContact): EmergencyContact =
        repository.save(info)

    override fun update(id: Long, info: EmergencyContact): EmergencyContact? {
        return if (repository.existsById(id)) {
            repository.save(info.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
