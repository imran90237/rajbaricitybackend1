package com.example.rajbaricity.controller

import com.example.rajbaricity.model.MadrasaInfo
import com.example.rajbaricity.service.MadrasaInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/madrasa")
class MadrasaInfoRestController(
    private val service: MadrasaInfoService
) {

    @PostMapping
    fun create(@RequestBody madrasaInfo: MadrasaInfo): MadrasaInfo =
        service.save(madrasaInfo)

    @GetMapping
    fun getAll(): List<MadrasaInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<MadrasaInfo> {
        val madrasa = service.getById(id)
        return if (madrasa != null) ResponseEntity.ok(madrasa)
        else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: MadrasaInfo): ResponseEntity<MadrasaInfo> {
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
