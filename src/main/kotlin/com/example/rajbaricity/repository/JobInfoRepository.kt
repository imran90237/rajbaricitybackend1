package com.example.rajbaricity.repository

import com.example.rajbaricity.model.JobInfo
import org.springframework.data.jpa.repository.JpaRepository

interface JobInfoRepository : JpaRepository<JobInfo, Long>
