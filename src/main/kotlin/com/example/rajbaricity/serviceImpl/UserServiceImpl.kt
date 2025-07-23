package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.OtpCode
import com.example.rajbaricity.model.User
import com.example.rajbaricity.repository.OtpCodeRepository
import com.example.rajbaricity.repository.UserRepository
import com.example.rajbaricity.service.UserService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.random.Random

@Service
@Transactional
class UserServiceImpl(
    private val userRepository: UserRepository,
    private val otpCodeRepository: OtpCodeRepository
) : UserService {

    override fun registerUser(user: User): Boolean {
        user.email?.let {
            if (userRepository.existsByEmail(it)) return false
        }
        user.phone?.let {
            if (userRepository.existsByPhone(it)) return false
        }

        userRepository.save(user)

        // Send verification code to contact (phone or email) after registration
        val contact = user.phone ?: user.email
        contact?.let {
            sendVerificationCode(it)
        }

        return true
    }

    override fun login(input: String, password: String): User? {
        val user = when {
            "@" in input -> userRepository.findByEmail(input)
            input.all { it.isDigit() } -> userRepository.findByPhone(input)
            else -> userRepository.findByUsername(input)
        }
        return user?.takeIf { it.password == password }
    }

    override fun verifyUser(userId: Long): Boolean {
        val userOpt = userRepository.findById(userId)
        return if (userOpt.isPresent) {
            val user = userOpt.get()
            user.verified = true
            userRepository.save(user)
            true
        } else {
            false
        }
    }

    override fun getAllUsers(): List<User> = userRepository.findAll()

    override fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    override fun sendVerificationCode(contact: String): Boolean {
        val code = generateOtp()
        val message = "Your verification code is: $code"

        val sent = if (contact.contains("@")) {
            sendEmail(contact, message)
        } else {
            sendSMS(contact, message)
        }

        if (sent) {
            otpCodeRepository.save(OtpCode(phone = contact, code = code, createdAt = LocalDateTime.now()))
            return true
        }
        return false
    }

    override fun verifyCode(contact: String, code: String): Boolean {
        val otpOpt = otpCodeRepository.findTopByPhoneOrderByCreatedAtDesc(contact)
        return otpOpt.map {
            !it.isExpired() && it.code == code
        }.orElse(false)
    }

    private fun sendSMS(phone: String, message: String): Boolean {
        println("Sending SMS to $phone: $message") // এখানে বাস্তব SMS API ইন্টিগ্রেট করুন
        return true
    }

    private fun sendEmail(email: String, message: String): Boolean {
        println("Sending Email to $email: $message") // এখানে বাস্তব Email API ইন্টিগ্রেট করুন
        return true
    }

    private fun generateOtp(): String {
        return Random.nextInt(100000, 999999).toString()
    }
}
