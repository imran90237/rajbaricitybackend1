package com.example.rajbaricity.repository

import com.example.rajbaricity.model.OtpCode
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface OtpCodeRepository : JpaRepository<OtpCode, Long> {
    fun findTopByPhoneOrderByCreatedAtDesc(phone: String): Optional<OtpCode>
}
