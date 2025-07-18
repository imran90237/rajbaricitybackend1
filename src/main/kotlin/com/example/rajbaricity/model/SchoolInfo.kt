package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "school_info")
data class SchoolInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",
    val established: String = "",
    @Column(columnDefinition = "TEXT")
    val features: String = "",
    val mapUrl: String = "",
    val imageUrl: String = "" // Use a string URL for images
)
