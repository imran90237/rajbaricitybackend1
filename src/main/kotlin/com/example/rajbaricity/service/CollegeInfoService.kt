package com.example.rajbaricity.service

import com.example.rajbaricity.model.CollegeInfo

interface CollegeInfoService {
    fun getAll(): List<CollegeInfo>
    fun getById(id: Long): CollegeInfo?
    fun save(info: CollegeInfo): CollegeInfo
    fun update(id: Long, updated: CollegeInfo): CollegeInfo?
    fun delete(id: Long): Boolean
}
