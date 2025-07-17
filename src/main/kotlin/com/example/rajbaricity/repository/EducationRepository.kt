package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Education
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EducationRepository : JpaRepository<Education, Long>
