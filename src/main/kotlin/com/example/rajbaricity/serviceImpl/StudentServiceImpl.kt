package com.example.rajbaricity.service

import com.example.rajbaricity.model.StudentEntity
import com.example.rajbaricity.repository.StudentRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class StudentServiceImpl(
    private val studentRepository: StudentRepository
) : StudentService {

    override fun getAllStudents(): List<StudentEntity> = studentRepository.findAll()

    override fun getStudentById(id: Long): StudentEntity? = studentRepository.findById(id).orElse(null)

    override fun saveStudent(student: StudentEntity): StudentEntity = studentRepository.save(student)

    override fun updateStudent(id: Long, updatedStudent: StudentEntity): StudentEntity? {
        val existingStudent = studentRepository.findById(id).orElse(null) ?: return null
        val studentToSave = existingStudent.copy(
            name = updatedStudent.name,
            title = updatedStudent.title,
            subject = updatedStudent.subject,
            days = updatedStudent.days,
            salary = updatedStudent.salary,
            gender = updatedStudent.gender,
            thana = updatedStudent.thana,
            address = updatedStudent.address,
            phone = updatedStudent.phone,
            imageUri = updatedStudent.imageUri,
            imageRes = updatedStudent.imageRes,
            likes = updatedStudent.likes
        )
        return studentRepository.save(studentToSave)
    }

    override fun deleteStudent(id: Long) = studentRepository.deleteById(id)

    override fun likeStudent(id: Long): StudentEntity? {
        val student = studentRepository.findById(id).orElse(null) ?: return null
        student.likes += 1
        return studentRepository.save(student)
    }
}
