package com.example.rajbaricity.serviceImpl
import com.example.rajbaricity.model.Bustime
import com.example.rajbaricity.repository.BustimeRepository
import com.example.rajbaricity.service.BustimeService
import org.springframework.stereotype.Service

@Service
class BustimeServiceImpl(private val repository: BustimeRepository) : BustimeService {
    override fun getAll() = repository.findAll()
    override fun getById(id: Long) = repository.findById(id).orElse(null)
    override fun save(bustime: Bustime) = repository.save(bustime)

    override fun update(id: Long, bustime: Bustime): Bustime? {
        return if (repository.existsById(id)) {
            repository.save(bustime.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
