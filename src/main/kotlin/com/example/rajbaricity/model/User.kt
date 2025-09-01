package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false, unique = true)
    val username: String = "",

    @Column(nullable = false, unique = true)
    val email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Column(nullable = true)
    val profileImageUrl: String? = null,

    @Column(nullable = false)
    var verified: Boolean = false  // ইমেইল বা ফোন ভেরিফিকেশন ফ্ল্যাগ
)


