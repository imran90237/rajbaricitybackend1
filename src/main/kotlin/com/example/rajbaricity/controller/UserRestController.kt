package com.example.rajbaricity.controller

import com.example.rajbaricity.model.User
import com.example.rajbaricity.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/api/users")
class UserRestController(private val userService: UserService) {

    // Register a new user
    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<String> {
        val success = userService.registerUser(user)
        return if (success) {
            ResponseEntity.ok("Registration successful.")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email or phone already registered.")
        }
    }

    // Login with email/phone and password
    @PostMapping("/login")
    fun login(@RequestParam input: String, @RequestParam password: String): ResponseEntity<Any> {
        val user = userService.login(input, password)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials.")
        }
    }

    // Verify user by ID (e.g., after OTP)
    @PostMapping("/verify/{id}")
    fun verify(@PathVariable id: Long): ResponseEntity<String> {
        val verified = userService.verifyUser(id)
        return if (verified) {
            ResponseEntity.ok("User verified.")
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.")
        }
    }

    // Get all users
    @GetMapping("/all")
    fun getAllUsers(): ResponseEntity<List<User>> =
        ResponseEntity.ok(userService.getAllUsers())

    // Get user by ID
    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): ResponseEntity<Any> {
        val user = userService.getUserById(id)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.NOT_FOUND).body("User not found.")
        }
    }

    // Send OTP code to phone or email
    @PostMapping("/send-code")
    fun sendVerificationCode(@RequestParam contact: String): ResponseEntity<String> {
        val sent = userService.sendVerificationCode(contact)
        return if (sent) {
            ResponseEntity.ok("Verification code sent to $contact.")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Failed to send code. Contact may be invalid or already verified.")
        }
    }

    // Verify OTP code sent to phone or email
    @PostMapping("/verify-code")
    fun verifyCode(
        @RequestParam contact: String,
        @RequestParam code: String
    ): ResponseEntity<String> {
        val verified = userService.verifyCode(contact, code)
        return if (verified) {
            ResponseEntity.ok("Verification successful for $contact.")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired verification code.")
        }
    }

    // Simple test endpoint to verify API is working
    @GetMapping("/test")
    fun test(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(mapOf("message" to "API is working!"))
    }
}
