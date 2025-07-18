package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.LostAndFoundItem
import com.example.rajbaricity.repository.LostAndFoundRepository
import com.example.rajbaricity.service.LostAndFoundService
import org.springframework.stereotype.Service

@Service
class LostAndFoundServiceImpl(
    private val repo: LostAndFoundRepository
) : LostAndFoundService {

    override fun getAll(): List<LostAndFoundItem> = repo.findAll()

    override fun getAllByStatus(status: String): List<LostAndFoundItem> =
        repo.findByStatus(status.uppercase())

    override fun getById(id: Long): LostAndFoundItem? = repo.findById(id).orElse(null)

    override fun save(item: LostAndFoundItem): LostAndFoundItem = repo.save(item)

    override fun update(id: Long, updatedItem: LostAndFoundItem): LostAndFoundItem? {
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
