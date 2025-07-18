package com.example.rajbaricity.service

import com.example.rajbaricity.model.SchoolInfo

interface SchoolInfoService {
    fun getAll(): List<SchoolInfo>
    fun getById(id: Long): SchoolInfo?
    fun save(info: SchoolInfo): SchoolInfo
    fun delete(id: Long)
}
