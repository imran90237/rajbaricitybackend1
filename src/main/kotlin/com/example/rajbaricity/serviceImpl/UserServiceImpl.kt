package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.OtpCode
import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest
import com.example.rajbaricity.repository.OtpCodeRepository
import com.example.rajbaricity.repository.UserRepository
import com.example.rajbaricity.service.UserService
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.random.Random

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val otpCodeRepository: OtpCodeRepository,
    private val passwordEncoder: PasswordEncoder
) : UserService {

    override fun login(email: String, password: String): User? {
        val user = userRepository.findByEmail(email)
        return user?.takeIf { passwordEncoder.matches(password, it.password) && it.verified }
    }

    override fun getAllUsers(): List<User> = userRepository.findAll()

    override fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    override fun sendVerificationCode(user: User): Boolean {
        // Prevent sending code if user already exists and is verified
        if (userRepository.existsByEmail(user.email)) {
            val existingUser = userRepository.findByEmail(user.email)
            if (existingUser?.verified == true) {
                return false
            }
        }

        val code = generateOtp()
        val message = "Your verification code is: $code"

        val sent = sendEmail(user.email, message)

        if (sent) {
            otpCodeRepository.save(OtpCode(email = user.email, code = code, createdAt = LocalDateTime.now()))
            return true
        }
        return false
    }

    override fun verifyAndRegister(verificationRequest: VerificationRequest): User? {
        if (userRepository.existsByEmail(verificationRequest.email)) {
            return null // User already exists
        }

        val otpOpt = otpCodeRepository.findTopByEmailOrderByCreatedAtDesc(verificationRequest.email)
        val isValid = otpOpt.map {
            !it.isExpired() && it.code == verificationRequest.code
        }.orElse(false)

        return if (isValid) {
            val newUser = User(
                email = verificationRequest.email,
                password = passwordEncoder.encode(verificationRequest.password),
                verified = true
            )
            userRepository.save(newUser)
        } else {
            null
        }
    }

    private fun sendEmail(email: String, message: String): Boolean {
        println("Sending Email to $email: $message") // এখানে বাস্তব Email API ইন্টিগ্রেট করুন
        return true
    }

    private fun generateOtp(): String {
        return Random.nextInt(100000, 999999).toString()
    }
}