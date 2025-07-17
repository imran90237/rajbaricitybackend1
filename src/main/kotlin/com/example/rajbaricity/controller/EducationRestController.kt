package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Education
import com.example.rajbaricity.service.EducationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/educations")
@CrossOrigin(origins = ["*"])  // Optional: allow all origins for local testing
class EducationRestController(private val educationService: EducationService) {

    @GetMapping
    fun getAll(): List<Education> = educationService.getAllEducation()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Education> {
        val education = educationService.getById(id)
        return if (education != null) ResponseEntity.ok(education)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun save(@RequestBody education: Education): ResponseEntity<Education> {
        val saved = educationService.save(education)
        return ResponseEntity.status(HttpStatus.CREATED).body(saved)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody updated: Education): ResponseEntity<Education> {
        val updatedEducation = educationService.update(id, updated)
        return if (updatedEducation != null) ResponseEntity.ok(updatedEducation)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (educationService.delete(id)) {
            ResponseEntity.noContent().build()
        } else ResponseEntity.notFound().build()
    }
}
