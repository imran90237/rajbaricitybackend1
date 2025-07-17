package com.example.rajbaricity.serviceImpl
import com.example.rajbaricity.model.BusCounter
import com.example.rajbaricity.repository.BusCounterRepository
import com.example.rajbaricity.service.BusCounterService
import org.springframework.stereotype.Service

@Service
class BusCounterServiceImpl(private val repository: BusCounterRepository) : BusCounterService {
    override fun getAll() = repository.findAll()
    override fun getById(id: Long) = repository.findById(id).orElse(null)
    override fun save(busCounter: BusCounter) = repository.save(busCounter)

    override fun update(id: Long, busCounter: BusCounter): BusCounter? {
        return if (repository.existsById(id)) {
            repository.save(busCounter.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
