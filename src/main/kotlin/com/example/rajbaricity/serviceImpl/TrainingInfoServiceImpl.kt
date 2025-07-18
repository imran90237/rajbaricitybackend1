package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.TrainingInfo
import com.example.rajbaricity.repository.TrainingInfoRepository
import com.example.rajbaricity.service.TrainingInfoService
import org.springframework.stereotype.Service

@Service
class TrainingInfoServiceImpl(
    private val repo: TrainingInfoRepository
) : TrainingInfoService {

    override fun getAll(): List<TrainingInfo> = repo.findAll()

    override fun getById(id: Long): TrainingInfo? = repo.findById(id).orElse(null)

    override fun save(info: TrainingInfo): TrainingInfo = repo.save(info)

    override fun update(id: Long, info: TrainingInfo): TrainingInfo? {
        return if (repo.existsById(id)) {
            repo.save(info.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repo.existsById(id)) {
            repo.deleteById(id)
            true
        } else false
    }
}
