package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Bustime
import com.example.rajbaricity.repository.BustimeRepository
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/bus_time")
class BustimeRestController(
    private val repository: BustimeRepository
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Bustime>> {
        val all = repository.findAll()
        return ResponseEntity.ok(all)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Bustime> {
        return repository.findById(id)
            .map { ResponseEntity.ok(it) }
            .orElseGet { ResponseEntity.notFound().build() }
    }

    @PostMapping
    fun save(@RequestBody bustime: Bustime): ResponseEntity<Bustime> {
        val saved = repository.save(bustime)
        return ResponseEntity.ok(saved)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: Bustime): ResponseEntity<Bustime> {
        return if (repository.existsById(id)) {
            val saved = repository.save(updated.copy(id = id))
            ResponseEntity.ok(saved)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            ResponseEntity.noContent().build()
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
