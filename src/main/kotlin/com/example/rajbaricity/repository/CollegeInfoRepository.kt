package com.example.rajbaricity.repository

import com.example.rajbaricity.model.CollegeInfo
import org.springframework.data.jpa.repository.JpaRepository

interface CollegeInfoRepository : JpaRepository<CollegeInfo, Long>
