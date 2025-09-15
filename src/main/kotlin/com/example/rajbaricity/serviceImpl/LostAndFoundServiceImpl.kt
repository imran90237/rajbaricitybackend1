package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.LostAndFound
import com.example.rajbaricity.repository.LostAndFoundRepository
import com.example.rajbaricity.service.LostAndFoundService
import org.springframework.stereotype.Service

@Service
class LostAndFoundServiceImpl(
    private val repo: LostAndFoundRepository
) : LostAndFoundService {

    override fun getAll(): List<LostAndFound> = repo.findAll()

    override fun getAllByStatus(status: String): List<LostAndFound> =
        repo.findByStatus(status.uppercase())

    override fun getById(id: Long): LostAndFound? = repo.findById(id).orElse(null)

    override fun save(item: LostAndFound): LostAndFound = repo.save(item)

    override fun update(id: Long, updatedItem: LostAndFound): LostAndFound? {
        return if (repo.existsById(id)) {
            val itemToUpdate = updatedItem.copy(id = id) // keep the same id
            repo.save(itemToUpdate)
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repo.existsById(id)) {
            repo.deleteById(id)
            true
        } else false
    }
}
