package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.CarInfo
import com.example.rajbaricity.repository.CarInfoRepository
import com.example.rajbaricity.service.CarInfoService
import org.springframework.stereotype.Service

@Service
class CarInfoServiceImpl(
    private val carInfoRepository: CarInfoRepository
) : CarInfoService {

    override fun getAllCars(): List<CarInfo> = carInfoRepository.findAll()

    override fun getCarById(id: Long): CarInfo? =
        carInfoRepository.findById(id).orElse(null)

    override fun saveCar(carInfo: CarInfo): CarInfo =
        carInfoRepository.save(carInfo)

    override fun updateCar(id: Long, carInfo: CarInfo): CarInfo? {
        return if (carInfoRepository.existsById(id)) {
            carInfoRepository.save(carInfo.copy(id = id))
        } else null
    }

    override fun deleteCar(id: Long): Boolean {
        return if (carInfoRepository.existsById(id)) {
            carInfoRepository.deleteById(id)
            true
        } else false
    }
}
