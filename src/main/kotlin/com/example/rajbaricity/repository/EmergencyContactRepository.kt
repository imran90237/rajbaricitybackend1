package com.example.rajbaricity.repository

import com.example.rajbaricity.model.EmergencyContact
import org.springframework.data.jpa.repository.JpaRepository

interface EmergencyContactRepository : JpaRepository<EmergencyContact, Long>
