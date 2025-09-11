package com.example.rajbaricity.controller

import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest
import com.example.rajbaricity.repository.OtpCodeRepository
import com.example.rajbaricity.repository.UserRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class UserRestControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var userRepository: UserRepository

    @Autowired
    private lateinit var otpCodeRepository: OtpCodeRepository

    private val testUser = User(
        username = "testuser",
        email = "testuser@example.com",
        password = "password"
    )

    @BeforeEach
    fun setup() {
        // Clean up database before each test
        userRepository.findByEmail(testUser.email)?.let { userRepository.delete(it) }
        otpCodeRepository.findTopByEmailOrderByCreatedAtDesc(testUser.email).ifPresent { otpCodeRepository.delete(it) }
    }

    @Test
    fun `should register and verify a new user`() {
        // Step 0: Create a user first
        userRepository.save(testUser.copy(verified = false))

        // Step 1: Send verification code
        mockMvc.post("/api/users/send-verification") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(testUser)
        }.andExpect {
            status { isOk() }
            jsonPath("$.message") { value("Verification code sent to ${testUser.email}.") }
        }

        // Verify user is created but not verified
        val user = userRepository.findByEmail(testUser.email)
        assert(user != null)
        assert(user?.verified == false)

        // Step 2: Verify and register
        val otp = otpCodeRepository.findTopByEmailOrderByCreatedAtDesc(testUser.email).get()
        val verificationRequest = VerificationRequest(testUser.username, testUser.email, otp.code, "newpassword")

        mockMvc.post("/api/users/verify-and-register") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(verificationRequest)
        }.andExpect {
            status { isOk() }
            jsonPath("$.verified") { value(true) }
            jsonPath("$.email") { value(testUser.email) }
            jsonPath("$.username") { value(testUser.username) }
        }

        // Verify user is now verified
        val verifiedUser = userRepository.findByEmail(testUser.email)
        assert(verifiedUser?.verified == true)
    }
}
