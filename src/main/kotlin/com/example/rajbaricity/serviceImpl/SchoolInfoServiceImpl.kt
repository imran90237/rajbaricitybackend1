package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.SchoolInfo
import com.example.rajbaricity.repository.SchoolInfoRepository
import com.example.rajbaricity.service.SchoolInfoService
import org.springframework.stereotype.Service

@Service
class SchoolInfoServiceImpl(private val repository: SchoolInfoRepository) : SchoolInfoService {
    override fun getAll(): List<SchoolInfo> = repository.findAll()

    override fun getById(id: Long): SchoolInfo? = repository.findById(id).orElse(null)

    override fun save(info: SchoolInfo): SchoolInfo = repository.save(info)

    override fun delete(id: Long) = repository.deleteById(id)
}
