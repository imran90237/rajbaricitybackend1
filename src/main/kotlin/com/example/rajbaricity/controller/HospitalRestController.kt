package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Hospital
import com.example.rajbaricity.service.HospitalService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hospitals")
class HospitalRestController(
    private val service: HospitalService
) {

    @GetMapping
    fun getAll(): List<Hospital> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Hospital> {
        val hospital = service.getById(id)
        return if (hospital != null) ResponseEntity.ok(hospital)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody hospital: Hospital): ResponseEntity<Hospital> =
        ResponseEntity.ok(service.save(hospital))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody hospital: Hospital): ResponseEntity<Hospital> {
        val updated = service.update(id, hospital)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
