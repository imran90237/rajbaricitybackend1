package com.example.rajbaricity.controller

import com.example.rajbaricity.model.CollegeInfo
import com.example.rajbaricity.service.CollegeInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import jakarta.validation.Valid

@RestController
@RequestMapping("/api/college")
class CollegeInfoRestController(
    private val service: CollegeInfoService
) {

    @GetMapping
    fun getAll(): List<CollegeInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<CollegeInfo> {
        val info = service.getById(id)
        return if (info != null) ResponseEntity.ok(info)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@Valid @RequestBody info: CollegeInfo): CollegeInfo = service.save(info)

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody updated: CollegeInfo): ResponseEntity<CollegeInfo> {
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
