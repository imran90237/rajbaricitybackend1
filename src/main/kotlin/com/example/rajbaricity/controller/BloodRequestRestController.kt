package com.example.rajbaricity.controller


import com.example.rajbaricity.model.BloodRequest
import com.example.rajbaricity.service.BloodRequestService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/blood-requests")
@CrossOrigin(origins = ["*"]) // Allow all origins for testing
class BloodRequestRestController(
    private val service: BloodRequestService
) {

    @GetMapping
    fun getAll(): List<BloodRequest> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<BloodRequest> {
        val request = service.getById(id)
        return if (request != null) ResponseEntity.ok(request)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun save(@RequestBody request: BloodRequest): ResponseEntity<BloodRequest> {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(request))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: BloodRequest): ResponseEntity<BloodRequest> {
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
