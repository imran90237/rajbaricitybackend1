package com.example.rajbaricity.service

import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest

interface UserService {
    fun login(email: String, password: String): User?
    fun getAllUsers(): List<User>
    fun getUserById(id: Long): User?

    fun sendVerificationCode(user: User): Boolean
    fun verifyAndRegister(verificationRequest: VerificationRequest): User?
}
