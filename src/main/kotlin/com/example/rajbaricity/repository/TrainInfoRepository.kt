package com.example.rajbaricity.repository

import com.example.rajbaricity.model.TrainInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface TrainInfoRepository : JpaRepository<TrainInfo, Long>
