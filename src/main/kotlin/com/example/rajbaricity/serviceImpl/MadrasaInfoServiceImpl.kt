package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.MadrasaInfo
import com.example.rajbaricity.repository.MadrasaInfoRepository
import com.example.rajbaricity.service.MadrasaInfoService
import org.springframework.stereotype.Service

@Service
class MadrasaInfoServiceImpl(private val repository: MadrasaInfoRepository) : MadrasaInfoService {
    override fun getAll(): List<MadrasaInfo> = repository.findAll()

    override fun getById(id: Long): MadrasaInfo? = repository.findById(id).orElse(null)

    override fun save(info: MadrasaInfo): MadrasaInfo = repository.save(info)

    override fun delete(id: Long) = repository.deleteById(id)
}