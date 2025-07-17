package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Section
import com.example.rajbaricity.service.SectionService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/sections")
class SectionController(private val sectionService: SectionService) {

    @GetMapping
    fun getSections(): List<Section> = sectionService.getSections()
}
