package com.example.rajbaricity.controller

import com.example.rajbaricity.model.CoachingInfo
import com.example.rajbaricity.service.CoachingInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/coaching")
class CoachingInfoRestController(
    private val service: CoachingInfoService
) {

    @GetMapping
    fun getAll(): List<CoachingInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<CoachingInfo> {
        val coaching = service.getById(id)
        return if (coaching != null) ResponseEntity.ok(coaching)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody coaching: CoachingInfo): CoachingInfo = service.save(coaching)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody coaching: CoachingInfo): ResponseEntity<CoachingInfo> {
        val updated = service.update(id, coaching)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
