package com.example.rajbaricity.repository

import com.example.rajbaricity.model.CourierInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CourierInfoRepository : JpaRepository<CourierInfo, Long>
