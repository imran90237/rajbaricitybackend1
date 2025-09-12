package com.example.rajbaricity.service

import com.example.rajbaricity.model.MadrasaInfo

interface MadrasaInfoService {
    fun getAll(): List<MadrasaInfo>
    fun getById(id: Long): MadrasaInfo?
    fun save(info: MadrasaInfo): MadrasaInfo
    fun delete(id: Long)
}