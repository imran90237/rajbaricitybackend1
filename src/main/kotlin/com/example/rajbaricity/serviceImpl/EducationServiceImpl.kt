package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Education
import com.example.rajbaricity.repository.EducationRepository
import com.example.rajbaricity.service.EducationService
import org.springframework.stereotype.Service

@Service
class EducationServiceImpl(
    private val educationRepository: EducationRepository
) : EducationService {
    override fun getAllEducation(): List<Education> = educationRepository.getAllEducationInfo()
}
