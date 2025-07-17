package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Section
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SectionRepository : JpaRepository<Section, Long>
