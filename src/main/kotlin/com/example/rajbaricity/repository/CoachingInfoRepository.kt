package com.example.rajbaricity.repository

import com.example.rajbaricity.model.CoachingInfo
import org.springframework.data.jpa.repository.JpaRepository

interface CoachingInfoRepository : JpaRepository<CoachingInfo, Long>
