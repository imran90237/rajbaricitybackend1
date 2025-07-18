package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.CoachingInfo
import com.example.rajbaricity.repository.CoachingInfoRepository
import com.example.rajbaricity.service.CoachingInfoService
import org.springframework.stereotype.Service

@Service
class CoachingInfoServiceImpl(
    private val repo: CoachingInfoRepository
) : CoachingInfoService {

    override fun getAll(): List<CoachingInfo> = repo.findAll()

    override fun getById(id: Long): CoachingInfo? = repo.findById(id).orElse(null)

    override fun save(coaching: CoachingInfo): CoachingInfo = repo.save(coaching)

    override fun update(id: Long, coaching: CoachingInfo): CoachingInfo? {
        val existing = repo.findById(id).orElse(null) ?: return null
        val updated = existing.copy(
            name = coaching.name,
            features = coaching.features,
            mapUrl = coaching.mapUrl,
            imageUrl = coaching.imageUrl
        )
        return repo.save(updated)
    }

    override fun delete(id: Long): Boolean {
        if (!repo.existsById(id)) return false
        repo.deleteById(id)
        return true
    }
}
