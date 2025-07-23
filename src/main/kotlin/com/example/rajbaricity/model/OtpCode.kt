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

    val phone: String,
    val code: String,
    val createdAt: LocalDateTime = LocalDateTime.now()
) {
    fun isExpired(): Boolean = createdAt.plusMinutes(5).isBefore(LocalDateTime.now())
}
