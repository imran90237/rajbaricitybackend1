package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.MadrasaInfo
import com.example.rajbaricity.repository.MadrasaInfoRepository
import com.example.rajbaricity.service.MadrasaInfoService
import org.springframework.stereotype.Service

@Service
class MadrasaInfoServiceImpl(
    private val repository: MadrasaInfoRepository
) : MadrasaInfoService {

    override fun save(madrasaInfo: MadrasaInfo): MadrasaInfo {
        return repository.save(madrasaInfo)
    }

    override fun getAll(): List<MadrasaInfo> {
        return repository.findAll()
    }

    override fun getById(id: Long): MadrasaInfo? {
        return repository.findById(id).orElse(null)
    }

    override fun update(id: Long, updated: MadrasaInfo): MadrasaInfo? {
        return if (repository.existsById(id)) {
            val toUpdate = updated.copy(id = id)
            repository.save(toUpdate)
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
