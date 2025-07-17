package com.example.rajbaricity.controller

import com.example.rajbaricity.model.EmergencyContact
import com.example.rajbaricity.service.EmergencyContactService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/emergency")
class EmergencyRestContactController(
    private val service: EmergencyContactService
) {

    @GetMapping
    fun getAll(): List<EmergencyContact> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<EmergencyContact> {
        val info = service.getById(id)
        return if (info != null) ResponseEntity.ok(info)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody info: EmergencyContact): ResponseEntity<EmergencyContact> =
        ResponseEntity.ok(service.save(info))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody info: EmergencyContact): ResponseEntity<EmergencyContact> {
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
