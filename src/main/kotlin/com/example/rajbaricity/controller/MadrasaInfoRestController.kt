package com.example.rajbaricity.controller

import com.example.rajbaricity.model.MadrasaInfo
import com.example.rajbaricity.service.MadrasaInfoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/madrasas")
class MadrasaInfoRestController(private val service: MadrasaInfoService) {

    @GetMapping
    fun getAll(): List<MadrasaInfo> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): MadrasaInfo? = service.getById(id)

    @PostMapping
    fun save(@RequestBody info: MadrasaInfo): MadrasaInfo = service.save(info)

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = service.delete(id)
}