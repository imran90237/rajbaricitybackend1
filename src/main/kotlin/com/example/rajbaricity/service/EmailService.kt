package com.example.rajbaricity.service

interface EmailService {
    fun sendOtpEmail(to: String, otp: String)
    fun sendEmailWithCallback(to: String, subject: String, text: String)
}
