package com.example.rajbaricity.repository

import com.example.rajbaricity.model.MadrasaInfo
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MadrasaInfoRepository : JpaRepository<MadrasaInfo, Long>