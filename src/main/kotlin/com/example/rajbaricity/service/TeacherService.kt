package com.example.rajbaricity.service

import com.example.rajbaricity.model.TeacherEntity

interface TeacherService {
    fun saveTeacher(teacher: TeacherEntity): TeacherEntity
    fun getAllTeachers(): List<TeacherEntity>
    fun getTeacherById(id: Long): TeacherEntity?
    fun updateTeacher(id: Long, updatedTeacher: TeacherEntity): TeacherEntity?
    fun deleteTeacher(id: Long)
}
