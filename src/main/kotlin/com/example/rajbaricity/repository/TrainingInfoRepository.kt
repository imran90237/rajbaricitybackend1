package com.example.rajbaricity.repository

import com.example.rajbaricity.model.TrainingInfo
import org.springframework.data.jpa.repository.JpaRepository

interface TrainingInfoRepository : JpaRepository<TrainingInfo, Long>
