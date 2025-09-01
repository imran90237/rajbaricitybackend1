package com.example.rajbaricity.controller

import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest
import com.example.rajbaricity.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"])
@RestController
@RequestMapping("/api/users")
class UserRestController(private val userService: UserService) {

    // The new registration flow starts with sending a verification code.
    // The old direct register endpoint is commented out in favor of the new flow.
    /*
    @PostMapping("/register")
    fun register(@RequestBody user: User): ResponseEntity<String> {
        val registeredUser = userService.registerUser(user)
        return if (registeredUser != null) {
            ResponseEntity.ok("Registration successful. Please check your email for a verification code.")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Email already registered.")
        }
    }
    */

    // Step 1: Send verification code to user's email
    @PostMapping("/send-verification")
    fun sendVerificationCode(@RequestBody user: User): ResponseEntity<String> {
        val sent = userService.sendVerificationCode(user)
        return if (sent) {
            ResponseEntity.ok("Verification code sent to ${user.email}.")
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body("Failed to send code. Email may be invalid or already registered and verified.")
        }
    }

    // Step 2: Verify the code and complete registration
    @PostMapping("/verify-and-register")
    fun verifyAndRegister(@RequestBody verificationRequest: VerificationRequest): ResponseEntity<Any> {
        val user = userService.verifyAndRegister(verificationRequest)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired code, or email already exists.")
        }
    }

    // Login with email/phone and password
    @PostMapping("/login")
    fun login(@RequestParam email: String, @RequestParam password: String): ResponseEntity<Any> {
        val user = userService.login(email, password)
        return if (user != null) {
            ResponseEntity.ok(user)
        } else {
            ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid credentials or user not verified.")
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

    // Simple test endpoint to verify API is working
    @GetMapping("/test")
    fun test(): ResponseEntity<Map<String, String>> {
        return ResponseEntity.ok(mapOf("message" to "API is working!"))
    }
}
