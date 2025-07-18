package com.example.rajbaricity.controller

import com.example.rajbaricity.model.SchoolInfo
import com.example.rajbaricity.service.SchoolInfoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/schools")
class SchoolInfoRestController(private val service: SchoolInfoService) {

    @GetMapping
    fun getAll(): List<SchoolInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): SchoolInfo? = service.getById(id)

    @PostMapping
    fun save(@RequestBody info: SchoolInfo): SchoolInfo = service.save(info)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}
