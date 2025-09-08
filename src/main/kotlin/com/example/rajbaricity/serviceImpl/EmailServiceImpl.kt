package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.network.ApiService
import com.example.rajbaricity.service.EmailService
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

@Service
class EmailServiceImpl(
    private val emailSender: JavaMailSender,
    private val apiService: ApiService
) : EmailService {

    @Value("\${spring.mail.from}")
    private lateinit var fromEmail: String

    private val logger = LoggerFactory.getLogger(EmailServiceImpl::class.java)

    override fun sendOtpEmail(to: String, otp: String) {
        try {
            val message = SimpleMailMessage()
            message.setFrom(fromEmail)
            message.setTo(to)
            message.subject = "Your OTP Code"
            message.text = "Your OTP code is: $otp"
            emailSender.send(message)
            logger.info("OTP email sent successfully to {}", to)
        } catch (e: Exception) {
            logger.error("Error sending OTP email to {}: {}", to, e.message, e)
            throw e
        }
    }

    override fun sendEmailWithCallback(to: String, subject: String, text: String) {
        val call = apiService.sendEmail(to, subject, text)
        call.enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                if (response.isSuccessful) {
                    println("Email sent successfully.")
                } else {
                    println("Failed to send email. Code: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                println("Error sending email: ${t.message}")
            }
        })
    }
}
