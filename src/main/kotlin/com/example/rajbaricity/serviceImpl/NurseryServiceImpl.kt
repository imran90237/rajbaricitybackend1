package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Nursery
import com.example.rajbaricity.repository.NurseryRepository
import com.example.rajbaricity.service.NurseryService
import org.springframework.stereotype.Service

@Service
class NurseryServiceImpl(private val nurseryRepository: NurseryRepository) : NurseryService {

    override fun saveNursery(nursery: Nursery): Nursery = nurseryRepository.save(nursery)

    override fun getAllNurseries(): List<Nursery> = nurseryRepository.findAll()

    override fun getNurseryById(id: Long): Nursery? =
        nurseryRepository.findById(id).orElse(null)

    override fun deleteNursery(id: Long) = nurseryRepository.deleteById(id)
}
