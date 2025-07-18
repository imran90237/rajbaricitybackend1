package com.example.rajbaricity.service

import com.example.rajbaricity.model.TrainingInfo

interface TrainingInfoService {
    fun getAll(): List<TrainingInfo>
    fun getById(id: Long): TrainingInfo?
    fun save(info: TrainingInfo): TrainingInfo
    fun update(id: Long, info: TrainingInfo): TrainingInfo?
    fun delete(id: Long): Boolean
}
