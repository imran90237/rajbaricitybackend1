package com.example.rajbaricity.service

import com.example.rajbaricity.model.CourierInfo

interface CourierInfoService {
    fun getAll(): List<CourierInfo>
    fun getById(id: Long): CourierInfo?
    fun save(info: CourierInfo): CourierInfo
    fun update(id: Long, info: CourierInfo): CourierInfo?
    fun delete(id: Long): Boolean
}
