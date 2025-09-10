package com.example.rajbaricity.controller

import com.example.rajbaricity.model.BloodDonor
import com.example.rajbaricity.service.BloodDonorService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blood_donors")
@CrossOrigin(origins = ["*"]) // Useful for frontend testing
class BloodDonorRestController(
    private val service: BloodDonorService
) {

    @GetMapping
    fun getAll(): List<BloodDonor> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<BloodDonor> {
        val donor = service.getById(id)
        return if (donor != null) ResponseEntity.ok(donor)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun save(@RequestBody donor: BloodDonor): ResponseEntity<BloodDonor> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(donor))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: BloodDonor): ResponseEntity<BloodDonor> {
        val result = service.update(id, updated)
        return if (result != null) ResponseEntity.ok(result)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
