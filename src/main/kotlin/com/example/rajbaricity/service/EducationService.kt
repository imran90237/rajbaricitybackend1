package com.example.rajbaricity.service

import com.example.rajbaricity.model.Education

interface EducationService {
    fun getAllEducation(): List<Education>
<<<<<<< HEAD
    fun getById(id: Long): Education?
    fun save(education: Education): Education
    fun update(id: Long, education: Education): Education?
    fun delete(id: Long): Boolean
=======
>>>>>>> oldrepo/master
}
