package com.example.rajbaricity.serviceImpl


import com.example.rajbaricity.model.BloodRequest
import com.example.rajbaricity.repository.BloodRequestRepository
import com.example.rajbaricity.service.BloodRequestService
import org.springframework.stereotype.Service

@Service
class BloodRequestServiceImpl(
    private val repository: BloodRequestRepository
) : BloodRequestService {

    override fun getAll(): List<BloodRequest> = repository.findAll()

    override fun getById(id: Long): BloodRequest? = repository.findById(id).orElse(null)

    override fun save(request: BloodRequest): BloodRequest = repository.save(request)

    override fun update(id: Long, request: BloodRequest): BloodRequest? {
        return if (repository.existsById(id)) {
            repository.save(request.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
