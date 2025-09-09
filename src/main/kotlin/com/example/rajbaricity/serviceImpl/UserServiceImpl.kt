package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.OtpCode
import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest
import com.example.rajbaricity.repository.OtpCodeRepository
import com.example.rajbaricity.repository.UserRepository
import com.example.rajbaricity.service.EmailService
import com.example.rajbaricity.service.UserService
import org.slf4j.LoggerFactory
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
    private val passwordEncoder: PasswordEncoder,
    private val emailService: EmailService
) : UserService {

    private val logger = LoggerFactory.getLogger(UserServiceImpl::class.java)

    override fun login(email: String, password: String): User? {
        logger.info("Attempting login for email: {}", email)
        var user = userRepository.findByEmail(email)
        if (user == null) {
            val correctedEmail = correctEmailTypo(email)
            if (correctedEmail != email) {
                logger.info("Original email not found. Trying corrected email: {}", correctedEmail)
                user = userRepository.findByEmail(correctedEmail)
                if (user != null) {
                    logger.info("User found with corrected email: {}", correctedEmail)
                }
            }
        }

        if (user == null) {
            logger.warn("Login failed: No user found for email: {}", email)
            return null
        }
        if (passwordEncoder.matches(password, user.password)) {
            logger.info("Login successful for email: {}", email)
            return user
        }
        logger.warn("Login failed: Invalid password for email: {}", email)
        return null
    }

    private fun correctEmailTypo(email: String): String {
        val parts = email.split("@")
        if (parts.size == 2) {
            val domain = parts[1]
            if (domain.equals("gmal.com", ignoreCase = true)) {
                return parts[0] + "@gmail.com"
            }
        }
        return email
    }

    override fun getAllUsers(): List<User> = userRepository.findAll()

    override fun getUserById(id: Long): User? = userRepository.findById(id).orElse(null)

    override fun sendVerificationCode(user: User): Boolean {
        logger.info("Received request to send verification code to email: {}", user.email)

        val code = generateOtp()

        try {
            emailService.sendOtpEmail(user.email, code)
            // Remove old code if it exists
            otpCodeRepository.findByEmail(user.email).ifPresent { otpCodeRepository.delete(it) }
            // Save the new code
            otpCodeRepository.save(OtpCode(email = user.email, code = code, createdAt = LocalDateTime.now()))
            logger.info("Verification code {} sent to {} and saved to database.", code, user.email)

            return true
        } catch (e: Exception) {
            logger.error("Failed to send verification email to {}", user.email, e)
            throw e
        }
    }

    override fun verifyAndRegister(verificationRequest: VerificationRequest): User? {
        logger.info("Starting verification and registration process for email: {}", verificationRequest.email)
        logger.debug("Received verification request: {}", verificationRequest)

        try {
            val otpOpt = otpCodeRepository.findByEmail(verificationRequest.email)

            if (!otpOpt.isPresent) {
                logger.warn("Verification failed: No OTP found for email: {}", verificationRequest.email)
                return null
            }

            val otpCode = otpOpt.get()
            logger.info("Found OTP for email: {}. Code: {}. CreatedAt: {}. Is Expired: {}",
                otpCode.email, otpCode.code, otpCode.createdAt, otpCode.isExpired())

            // 1. Check if code is valid and not expired
            if (otpCode.isExpired() || otpCode.code != verificationRequest.code) {
                logger.warn("Verification failed: OTP is invalid or expired. Request code: {}, DB code: {}. Is Expired: {}",
                    verificationRequest.code, otpCode.code, otpCode.isExpired())
                return null
            }

            // 2. OTP is valid. Now, find or create the user.
            val existingUser = userRepository.findByEmail(verificationRequest.email)
            val user = if (existingUser != null) {
                logger.info("User already exists with email: {}. Updating details.", verificationRequest.email)
                existingUser
            } else {
                logger.info("User does not exist with email: {}. Creating new user.", verificationRequest.email)
                User(
                    username = verificationRequest.username,
                    name = verificationRequest.username,
                    email = verificationRequest.email
                )
            }

            // 3. Update user details
            user.password = passwordEncoder.encode(verificationRequest.password)
            user.verified = true
            logger.info("Attempting to save user: {}", user)

            val savedUser = userRepository.save(user)
            logger.info("User successfully verified and saved with ID: {}", savedUser.id)

            // 4. Clean up the used OTP code
            otpCodeRepository.delete(otpCode)
            logger.info("Cleaned up OTP for email: {}", verificationRequest.email)

            return savedUser
        } catch (e: Exception) {
            logger.error("An unexpected error occurred during registration for email: {}", verificationRequest.email, e)
            // Re-throwing the exception to allow for proper transaction rollback.
            throw e
        }
    }

    private fun generateOtp(): String {
        return Random.nextInt(100000, 999999).toString()
    }
}