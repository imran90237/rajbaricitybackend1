package com.example.rajbaricity.service

import com.example.rajbaricity.model.MadrasaInfo

interface MadrasaInfoService {
    fun save(madrasaInfo: MadrasaInfo): MadrasaInfo
    fun getAll(): List<MadrasaInfo>
    fun getById(id: Long): MadrasaInfo?
    fun update(id: Long, updated: MadrasaInfo): MadrasaInfo?
    fun delete(id: Long): Boolean
}
