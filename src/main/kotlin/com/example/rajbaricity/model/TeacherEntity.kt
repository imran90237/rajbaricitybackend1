package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "teachers")
data class TeacherEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val title: String = "",

    @Column(nullable = false)
    val subject: String = "",

    @Column(nullable = false)
    val days: String = "",

    @Column(nullable = false)
    val salary: String = "",

    @Column(nullable = false)
    val gender: String = "",

    @Column(nullable = false)
    val thana: String = "",

    @Column(nullable = false)
    val address: String = "",

    @Column(nullable = false)
    val phone: String = "",

    val imageUri: String? = null,

    val imageRes: Int = 0,

    var likes: Int = 0
)
