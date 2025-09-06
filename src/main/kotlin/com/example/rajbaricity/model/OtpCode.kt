package com.example.rajbaricity.model

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime

@Entity
data class OtpCode(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val email: String = "",
    val code: String = "",
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    /**
     * Checks if the OTP has expired.
     * An OTP is considered expired if the current time is after 5 minutes from its creation time.
     */
    fun isExpired(): Boolean {
        val expirationTime = createdAt.plusMinutes(5)
        return LocalDateTime.now().isAfter(expirationTime)
    }
}