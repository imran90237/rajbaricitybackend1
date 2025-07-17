package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Section
import com.example.rajbaricity.service.SectionService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/sections")
class SectionRestController(private val sectionService: SectionService) {

    @GetMapping
    fun getSections(): List<Section> = sectionService.getSections()

    @PostMapping
    fun createSection(@RequestBody section: Section): Section {
        return sectionService.saveSection(section)
    }
}