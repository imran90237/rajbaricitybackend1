package com.example.rajbaricity.service

import com.example.rajbaricity.model.User

interface UserService {
    fun registerUser(user: User): Boolean
    fun login(input: String, password: String): User?
    fun verifyUser(id: Long): Boolean
    fun getAllUsers(): List<User>
    fun getUserById(id: Long): User?

    // ফোন বা ইমেইল, যেকোনো contact নিতে হবে
    fun sendVerificationCode(contact: String): Boolean
    fun verifyCode(contact: String, code: String): Boolean
}
