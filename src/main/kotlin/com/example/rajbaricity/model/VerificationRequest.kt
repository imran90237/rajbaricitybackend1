package com.example.rajbaricity.model

data class VerificationRequest(
    val username: String,
    val email: String,
    val password: String,
    val code: String
)
