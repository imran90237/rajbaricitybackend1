package com.example.rajbaricity.repository

import com.example.rajbaricity.model.BusCounter
import org.springframework.data.jpa.repository.JpaRepository

interface BusCounterRepository : JpaRepository<BusCounter, Long>
