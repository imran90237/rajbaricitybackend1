package com.example.rajbaricity.service

import com.example.rajbaricity.model.StudentEntity

interface StudentService {
    fun getAllStudents(): List<StudentEntity>
    fun getStudentById(id: Long): StudentEntity?
    fun saveStudent(student: StudentEntity): StudentEntity
    fun updateStudent(id: Long, updatedStudent: StudentEntity): StudentEntity?
    fun deleteStudent(id: Long)
    fun likeStudent(id: Long): StudentEntity?
}
