package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Nursery
import com.example.rajbaricity.service.NurseryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/nurseries")
class NurseryRestController(private val nurseryService: NurseryService) {

    @PostMapping
    fun createNursery(@RequestBody nursery: Nursery): ResponseEntity<Nursery> {
        return ResponseEntity.ok(nurseryService.saveNursery(nursery))
    }

    @GetMapping
    fun getAllNurseries(): ResponseEntity<List<Nursery>> {
        return ResponseEntity.ok(nurseryService.getAllNurseries())
    }

    @GetMapping("/{id}")
    fun getNurseryById(@PathVariable id: Long): ResponseEntity<Nursery> {
        val nursery = nurseryService.getNurseryById(id)
        return if (nursery != null) ResponseEntity.ok(nursery)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteNursery(@PathVariable id: Long): ResponseEntity<Void> {
        nurseryService.deleteNursery(id)
        return ResponseEntity.noContent().build()
    }
}
