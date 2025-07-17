package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.BloodDonor
import com.example.rajbaricity.repository.BloodDonorRepository
import com.example.rajbaricity.service.BloodDonorService
import org.springframework.stereotype.Service

@Service
class BloodDonorServiceImpl(
    private val repository: BloodDonorRepository
) : BloodDonorService {

    override fun getAll(): List<BloodDonor> = repository.findAll()

    override fun getById(id: Long): BloodDonor? = repository.findById(id).orElse(null)

    override fun save(donor: BloodDonor): BloodDonor = repository.save(donor)

    override fun update(id: Long, donor: BloodDonor): BloodDonor? {
        return if (repository.existsById(id)) {
            repository.save(donor.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
