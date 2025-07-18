package com.example.rajbaricity.controller

import com.example.rajbaricity.model.TrainingInfo
import com.example.rajbaricity.service.TrainingInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/trainings")
class TrainingInfoRestController(
    private val service: TrainingInfoService
) {

    @GetMapping
    fun getAll(): List<TrainingInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<TrainingInfo> {
        val info = service.getById(id)
        return if (info != null) ResponseEntity.ok(info)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody info: TrainingInfo): ResponseEntity<TrainingInfo> =
        ResponseEntity.ok(service.save(info))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody info: TrainingInfo): ResponseEntity<TrainingInfo> {
        val updated = service.update(id, info)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
