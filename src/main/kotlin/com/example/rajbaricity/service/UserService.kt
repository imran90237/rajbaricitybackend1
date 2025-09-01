package com.example.rajbaricity.service

import com.example.rajbaricity.model.User
import com.example.rajbaricity.model.VerificationRequest

interface UserService {
    fun registerUser(user: User): User?
    fun login(email: String, password: String): User?
    fun verifyUser(id: Long): Boolean
    fun getAllUsers(): List<User>
    fun getUserById(id: Long): User?

    // فون বা ইমেইল, যেকোনো contact নিতে হবে
    fun sendVerificationCode(user: User): Boolean
    fun verifyAndRegister(verificationRequest: VerificationRequest): User?
}
