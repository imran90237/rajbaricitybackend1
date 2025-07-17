package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Bustime
import org.springframework.data.jpa.repository.JpaRepository

interface BustimeRepository : JpaRepository<Bustime, Long>
