package com.example.rajbaricity.repository

import com.example.rajbaricity.model.BloodRequest
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BloodRequestRepository : JpaRepository<BloodRequest, Long>
