package com.example.rajbaricity.controller

import com.example.rajbaricity.model.StudentEntity
import com.example.rajbaricity.service.StudentService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/students")
class StudentRestController(
    private val studentService: StudentService
) {

    @GetMapping
    fun getAllStudents(): List<StudentEntity> = studentService.getAllStudents()

    @GetMapping("/{id}")
    fun getStudentById(@PathVariable id: Long): ResponseEntity<StudentEntity> {
        val student = studentService.getStudentById(id)
        return if (student != null) ResponseEntity.ok(student) else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createStudent(@RequestBody student: StudentEntity): ResponseEntity<StudentEntity> {
        val savedStudent = studentService.saveStudent(student)
        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent)
    }

    @PutMapping("/{id}")
    fun updateStudent(
        @PathVariable id: Long,
        @RequestBody updatedStudent: StudentEntity
    ): ResponseEntity<StudentEntity> {
        val updated = studentService.updateStudent(id, updatedStudent)
        return if (updated != null) ResponseEntity.ok(updated) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteStudent(@PathVariable id: Long): ResponseEntity<Void> {
        studentService.deleteStudent(id)
        return ResponseEntity.noContent().build()
    }

    @PostMapping("/{id}/like")
    fun likeStudent(@PathVariable id: Long): ResponseEntity<StudentEntity> {
        val likedStudent = studentService.likeStudent(id)
        return if (likedStudent != null) ResponseEntity.ok(likedStudent) else ResponseEntity.notFound().build()
    }
}
