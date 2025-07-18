package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "coaching_info")
data class CoachingInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = "",

    @Column(columnDefinition = "TEXT")
    val features: String = "",

    @Column(nullable = false)
    val mapUrl: String = "",

    @Column(nullable = true)
    val imageUrl: String? = null
)
