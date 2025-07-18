package com.example.rajbaricity.service

import com.example.rajbaricity.model.TeacherEntity
import com.example.rajbaricity.repository.TeacherRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class TeacherServiceImpl(
    private val teacherRepository: TeacherRepository
) : TeacherService {

    override fun saveTeacher(teacher: TeacherEntity): TeacherEntity {
        return teacherRepository.save(teacher)
    }

    override fun getAllTeachers(): List<TeacherEntity> {
        return teacherRepository.findAll()
    }

    override fun getTeacherById(id: Long): TeacherEntity? {
        return teacherRepository.findById(id).orElse(null)
    }

    override fun updateTeacher(id: Long, updatedTeacher: TeacherEntity): TeacherEntity? {
        val existingTeacher = teacherRepository.findById(id).orElse(null) ?: return null

        val teacherToUpdate = existingTeacher.copy(
            name = updatedTeacher.name,
            title = updatedTeacher.title,
            subject = updatedTeacher.subject,
            days = updatedTeacher.days,
            salary = updatedTeacher.salary,
            gender = updatedTeacher.gender,
            thana = updatedTeacher.thana,
            address = updatedTeacher.address,
            phone = updatedTeacher.phone,
            imageUri = updatedTeacher.imageUri,
            imageRes = updatedTeacher.imageRes,
            likes = updatedTeacher.likes
        )
        return teacherRepository.save(teacherToUpdate)
    }

    override fun deleteTeacher(id: Long) {
        teacherRepository.deleteById(id)
    }
}
