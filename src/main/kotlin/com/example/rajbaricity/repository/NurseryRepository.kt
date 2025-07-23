package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Nursery
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface NurseryRepository : JpaRepository<Nursery, Long>
