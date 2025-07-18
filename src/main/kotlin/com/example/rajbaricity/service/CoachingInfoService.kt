package com.example.rajbaricity.service

import com.example.rajbaricity.model.CoachingInfo

interface CoachingInfoService {
    fun getAll(): List<CoachingInfo>
    fun getById(id: Long): CoachingInfo?
    fun save(coaching: CoachingInfo): CoachingInfo
    fun update(id: Long, coaching: CoachingInfo): CoachingInfo?
    fun delete(id: Long): Boolean
}
