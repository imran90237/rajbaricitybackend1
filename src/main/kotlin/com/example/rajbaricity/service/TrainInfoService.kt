package com.example.rajbaricity.service

import com.example.rajbaricity.model.TrainInfo

interface TrainInfoService {
    fun getAllTrains(): List<TrainInfo>
    fun getTrainById(id: Long): TrainInfo?
    fun saveTrain(trainInfo: TrainInfo): TrainInfo
    fun updateTrain(id: Long, trainInfo: TrainInfo): TrainInfo?
    fun deleteTrain(id: Long): Boolean
}
