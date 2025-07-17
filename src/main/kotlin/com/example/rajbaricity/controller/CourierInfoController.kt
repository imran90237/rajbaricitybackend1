package com.example.rajbaricity.controller

import com.example.rajbaricity.model.CourierInfo
import com.example.rajbaricity.service.CourierInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/couriers")
class CourierInfoController(
    private val service: CourierInfoService
) {

    @GetMapping
    fun getAll(): List<CourierInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<CourierInfo> {
        val info = service.getById(id)
        return if (info != null) ResponseEntity.ok(info)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody info: CourierInfo): ResponseEntity<CourierInfo> =
        ResponseEntity.ok(service.save(info))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody info: CourierInfo): ResponseEntity<CourierInfo> {
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
