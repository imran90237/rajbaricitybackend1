package com.example.rajbaricity.controller

import com.example.rajbaricity.model.LoginRequest
import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest
import com.example.rajbaricity.service.UserService
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/api/users")
class UserRestController(private val userService: UserService) {

    private val logger = LoggerFactory.getLogger(UserRestController::class.java)

    @PostMapping("/send-verification")
    fun sendVerificationCode(@RequestBody user: User): ResponseEntity<Map<String, String>> {
        logger.info("Request received for /send-verification for email: {}", user.email)
        return try {
            val sent = userService.sendVerificationCode(user)
            if (sent) {
                ResponseEntity.ok(mapOf("message" to "Verification code sent to ${user.email}."))
            } else {
                // This case now specifically means the user exists and is verified.
                ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(mapOf("message" to "This email is already registered and verified."))
            }
        } catch (e: Exception) {
            logger.error("Error in /send-verification for email {}: {}", user.email, e.message)
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mapOf("message" to "An unexpected error occurred."))
        }
    }

    @PostMapping("/verify-and-register")
    fun verifyAndRegister(@RequestBody verificationRequest: VerificationRequest): ResponseEntity<out Any> {
        logger.info("Request received for /verify-and-register for email: {}", verificationRequest.email)
        return try {
            val user = userService.verifyAndRegister(verificationRequest)
            if (user != null) {
                ResponseEntity.ok(user)
            } else {
                ResponseEntity.status(HttpStatus.BAD_REQUEST).body(mapOf("message" to "Invalid or expired code."))
            }
        } catch (e: Exception) {
            logger.error("Error in /verify-and-register for email {}: {}", verificationRequest.email, e.message)
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mapOf("message" to "An unexpected error occurred during registration."))
        }
    }

    @PostMapping("/login")
    fun login(@RequestBody loginRequest: LoginRequest): ResponseEntity<out Any> {
        logger.info("Request received for /login for email: {}", loginRequest.email)
        return try {
            val user = userService.login(loginRequest.email, loginRequest.password)
            if (user != null) {
                ResponseEntity.ok(user)
            } else {
                ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(mapOf("message" to "Invalid credentials or user not verified."))
            }
        } catch (e: Exception) {
            logger.error("Error in /login for email {}: {}", loginRequest.email, e.message)
            ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(mapOf("message" to "An unexpected error occurred during login."))
        }
    }

    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<List<User>> =
        ResponseEntity.ok(userService.getAllUsers())

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<out Any> {
        val user = userService.getUserById(id)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body(mapOf("message" to "User not found."))
        }
    }
}
