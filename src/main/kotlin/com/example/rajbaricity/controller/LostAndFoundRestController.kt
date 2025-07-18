package com.example.rajbaricity.controller

import com.example.rajbaricity.model.LostAndFoundItem
import com.example.rajbaricity.service.LostAndFoundService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/lostfound")
class LostAndFoundRestController(
    private val service: LostAndFoundService
) {

    @PostMapping
    fun create(@RequestBody item: LostAndFoundItem): LostAndFoundItem =
        service.save(item)

    @GetMapping
    fun getAll(): List<LostAndFoundItem> =
        service.getAll()

    @GetMapping("/status/{status}")
    fun getByStatus(@PathVariable status: String): List<LostAndFoundItem> =
        service.getAllByStatus(status)

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<LostAndFoundItem> {
        val item = service.getById(id)
        return if (item != null) ResponseEntity.ok(item)
        else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: LostAndFoundItem): ResponseEntity<LostAndFoundItem> {
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
