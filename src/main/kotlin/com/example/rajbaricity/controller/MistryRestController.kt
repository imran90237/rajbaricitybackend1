package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Mistry
import com.example.rajbaricity.service.MistryService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/mistrys")
class MistryRestController(
    private val mistryService: MistryService
) {

    @GetMapping
    fun getAll(): ResponseEntity<List<Mistry>> {
        val mistrys = mistryService.getAll()
        return ResponseEntity.ok(mistrys)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Mistry> {
        val mistry = mistryService.getById(id)
        return mistry?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody mistry: Mistry): ResponseEntity<Mistry> {
        val saved = mistryService.save(mistry)
        return ResponseEntity.ok(saved)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: Mistry): ResponseEntity<Mistry> {
        val updatedMistry = mistryService.update(id, updated)
        return updatedMistry?.let { ResponseEntity.ok(it) } ?: ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (mistryService.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
