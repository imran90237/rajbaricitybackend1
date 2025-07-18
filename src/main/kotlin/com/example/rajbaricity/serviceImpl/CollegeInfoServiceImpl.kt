package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.CollegeInfo
import com.example.rajbaricity.repository.CollegeInfoRepository
import com.example.rajbaricity.service.CollegeInfoService
import org.springframework.stereotype.Service

@Service
class CollegeInfoServiceImpl(
    private val repo: CollegeInfoRepository
) : CollegeInfoService {

    override fun getAll(): List<CollegeInfo> = repo.findAll()

    override fun getById(id: Long): CollegeInfo? = repo.findById(id).orElse(null)

    override fun save(info: CollegeInfo): CollegeInfo = repo.save(info)

    override fun update(id: Long, updated: CollegeInfo): CollegeInfo? {
        val existing = repo.findById(id).orElse(null) ?: return null
        val newData = existing.copy(
            name = updated.name,
            established = updated.established,
            features = updated.features,
            mapUrl = updated.mapUrl,
            imageUrl = updated.imageUrl
        )
        return repo.save(newData)
    }

    override fun delete(id: Long): Boolean {
        return if (repo.existsById(id)) {
            repo.deleteById(id)
            true
        } else {
            false
        }
    }
}
