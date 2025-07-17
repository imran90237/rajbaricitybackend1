package com.example.rajbaricity.repository

import com.example.rajbaricity.model.CarInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CarInfoRepository : JpaRepository<CarInfo, Long>
