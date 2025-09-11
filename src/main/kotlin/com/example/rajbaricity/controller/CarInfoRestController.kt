package com.example.rajbaricity.controller

import com.example.rajbaricity.model.CarInfo
import com.example.rajbaricity.service.CarInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/cars")
class

CarInfoRestController(
    private val carInfoService: CarInfoService
) {

    @GetMapping
    fun getAllCars(): List<CarInfo> = carInfoService.getAllCars()

    @GetMapping("/{id}")
    fun getCarById(@PathVariable id: Long): ResponseEntity<CarInfo> {
        val car = carInfoService.getCarById(id)
        return if (car != null) ResponseEntity.ok(car)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createCar(@RequestBody carInfo: CarInfo): ResponseEntity<CarInfo> {
        val savedCar = carInfoService.saveCar(carInfo)
        return ResponseEntity.ok(savedCar)
    }

    @PutMapping("/{id}")
    fun updateCar(@PathVariable id: Long, @RequestBody updatedCar: CarInfo): ResponseEntity<CarInfo> {
        val updated = carInfoService.updateCar(id, updatedCar)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteCar(@PathVariable id: Long): ResponseEntity<Void> {
        val deleted = carInfoService.deleteCar(id)
        return if (deleted) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
