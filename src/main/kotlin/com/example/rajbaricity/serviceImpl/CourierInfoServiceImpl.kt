package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.CourierInfo
import com.example.rajbaricity.repository.CourierInfoRepository
import com.example.rajbaricity.service.CourierInfoService
import org.springframework.stereotype.Service

@Service
class CourierInfoServiceImpl(
    private val repository: CourierInfoRepository
) : CourierInfoService {

    override fun getAll(): List<CourierInfo> = repository.findAll()

    override fun getById(id: Long): CourierInfo? =
        repository.findById(id).orElse(null)

    override fun save(info: CourierInfo): CourierInfo =
        repository.save(info)

    override fun update(id: Long, info: CourierInfo): CourierInfo? {
        return if (repository.existsById(id)) {
            repository.save(info.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
