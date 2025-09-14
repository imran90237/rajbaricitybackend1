package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Mistry
import com.example.rajbaricity.repository.MistryRepository
import com.example.rajbaricity.service.MistryService
import org.springframework.stereotype.Service
import java.util.*

@Service
class MistryServiceImpl(
    private val repository: MistryRepository
) : MistryService {

    override fun getAll(): List<Mistry> {
        return repository.findAll()
    }

    override fun getById(id: Long): Mistry? {
        return repository.findById(id).orElse(null)
    }

    override fun save(mistry: Mistry): Mistry {
        return repository.save(mistry)
    }

    override fun update(id: Long, mistry: Mistry): Mistry? {
        return if (repository.existsById(id)) {
            val mistryToUpdate = mistry.copy(id = id)
            repository.save(mistryToUpdate)
        } else {
            null
        }
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else {
            false
        }
    }
}