package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Education
import com.example.rajbaricity.repository.EducationRepository
import com.example.rajbaricity.service.EducationService
import org.springframework.stereotype.Service

@Service
class EducationServiceImpl(
    private val educationRepository: EducationRepository
) : EducationService {

    override fun getAllEducation(): List<Education> = educationRepository.findAll()

    override fun getById(id: Long): Education? = educationRepository.findById(id).orElse(null)

    override fun save(education: Education): Education = educationRepository.save(education)

    override fun update(id: Long, education: Education): Education? {
        return if (educationRepository.existsById(id)) {
            educationRepository.save(education.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (educationRepository.existsById(id)) {
            educationRepository.deleteById(id)
            true
        } else false
    }
}