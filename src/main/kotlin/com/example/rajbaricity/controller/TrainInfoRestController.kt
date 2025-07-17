package com.example.rajbaricity.controller

import com.example.rajbaricity.model.TrainInfo
import com.example.rajbaricity.service.TrainInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trains")
class TrainInfoRestController(
    private val trainInfoService: TrainInfoService
) {

    @GetMapping
    fun getAllTrains(): List<TrainInfo> = trainInfoService.getAllTrains()

    @GetMapping("/{id}")
    fun getTrainById(@PathVariable id: Long): ResponseEntity<TrainInfo> {
        val train = trainInfoService.getTrainById(id)
        return if (train != null) ResponseEntity.ok(train)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createTrain(@RequestBody trainInfo: TrainInfo): ResponseEntity<TrainInfo> {
        val savedTrain = trainInfoService.saveTrain(trainInfo)
        return ResponseEntity.ok(savedTrain)
    }

    @PutMapping("/{id}")
    fun updateTrain(@PathVariable id: Long, @RequestBody updatedTrain: TrainInfo): ResponseEntity<TrainInfo> {
        val updated = trainInfoService.updateTrain(id, updatedTrain)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTrain(@PathVariable id: Long): ResponseEntity<Void> {
        val deleted = trainInfoService.deleteTrain(id)
        return if (deleted) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
