package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Education
import com.example.rajbaricity.service.EducationService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/education")
class EducationController(
    private val educationService: EducationService
) {

    @GetMapping
    fun getAllEducation(): List<Education> = educationService.getAllEducation()
}
