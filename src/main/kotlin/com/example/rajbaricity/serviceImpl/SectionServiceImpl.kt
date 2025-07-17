package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.Section
import com.example.rajbaricity.repository.SectionRepository
import com.example.rajbaricity.service.SectionService
import org.springframework.stereotype.Service

@Service
class SectionServiceImpl(
    private val sectionRepository: SectionRepository
) : SectionService {

    override fun getSections(): List<Section> = sectionRepository.findAll()

    override fun saveSection(section: Section): Section = sectionRepository.save(section)
}
