package com.example.rajbaricity.repository

import com.example.rajbaricity.model.TeacherEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TeacherRepository : JpaRepository<TeacherEntity, Long>
