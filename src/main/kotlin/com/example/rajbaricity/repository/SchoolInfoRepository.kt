package com.example.rajbaricity.repository

import com.example.rajbaricity.model.SchoolInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface SchoolInfoRepository : JpaRepository<SchoolInfo, Long>
