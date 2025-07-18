package com.example.rajbaricity.controller

import com.example.rajbaricity.model.TeacherEntity
import com.example.rajbaricity.service.TeacherService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/teachers")
class TeacherRestController(private val teacherService: TeacherService) {

    // POST: create/save a teacher
    @PostMapping
    fun createTeacher(@RequestBody request: TeacherEntity): ResponseEntity<TeacherEntity> {
        val savedTeacher = teacherService.saveTeacher(request)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTeacher)
    }

    // GET: all teachers
    @GetMapping
    fun getAllTeachers(): ResponseEntity<List<TeacherEntity>> {
        return ResponseEntity.ok(teacherService.getAllTeachers())
    }

    // GET: teacher by ID
    @GetMapping("/{id}")
    fun getTeacherById(@PathVariable id: Long): ResponseEntity<TeacherEntity> {
        val teacher = teacherService.getTeacherById(id)
        return if (teacher != null) {
            ResponseEntity.ok(teacher)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // PUT: update teacher by ID
    @PutMapping("/{id}")
    fun updateTeacher(
        @PathVariable id: Long,
        @RequestBody updatedTeacher: TeacherEntity
    ): ResponseEntity<TeacherEntity> {
        val result = teacherService.updateTeacher(id, updatedTeacher)
        return if (result != null) {
            ResponseEntity.ok(result)
        } else {
            ResponseEntity.notFound().build()
        }
    }

    // DELETE: delete teacher by ID
    @DeleteMapping("/{id}")
    fun deleteTeacher(@PathVariable id: Long): ResponseEntity<Void> {
        return try {
            teacherService.deleteTeacher(id)
            ResponseEntity.noContent().build()
        } catch (e: Exception) {
            ResponseEntity.notFound().build()
        }
    }

    // PUT: like a teacher (increment likes)
    @PutMapping("/{id}/like")
    fun likeTeacher(@PathVariable id: Long): ResponseEntity<TeacherEntity> {
        val teacher = teacherService.getTeacherById(id)
        return if (teacher != null) {
            teacher.likes += 1
            val updated = teacherService.saveTeacher(teacher)
            ResponseEntity.ok(updated)
        } else {
            ResponseEntity.notFound().build()
        }
    }
}
