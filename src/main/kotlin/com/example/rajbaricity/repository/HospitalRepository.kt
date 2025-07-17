package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Hospital
import org.springframework.data.jpa.repository.JpaRepository

interface HospitalRepository : JpaRepository<Hospital, Long>
