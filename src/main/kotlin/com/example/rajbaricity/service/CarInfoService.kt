package com.example.rajbaricity.service

import com.example.rajbaricity.model.CarInfo

interface CarInfoService {
    fun getAllCars(): List<CarInfo>
    fun getCarById(id: Long): CarInfo?
    fun saveCar(carInfo: CarInfo): CarInfo
    fun updateCar(id: Long, carInfo: CarInfo): CarInfo?
    fun deleteCar(id: Long): Boolean
}
