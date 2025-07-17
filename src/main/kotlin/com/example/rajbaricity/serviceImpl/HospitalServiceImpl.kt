package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Hospital
import com.example.rajbaricity.repository.HospitalRepository
import com.example.rajbaricity.service.HospitalService
import org.springframework.stereotype.Service

@Service
class HospitalServiceImpl(
    private val repository: HospitalRepository
) : HospitalService {

    override fun getAll(): List<Hospital> = repository.findAll()

    override fun getById(id: Long): Hospital? =
        repository.findById(id).orElse(null)

    override fun save(hospital: Hospital): Hospital =
        repository.save(hospital)

    override fun update(id: Long, hospital: Hospital): Hospital? {
        return if (repository.existsById(id)) {
            repository.save(hospital.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
