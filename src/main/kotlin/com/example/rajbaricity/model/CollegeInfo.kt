package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "college_info")
data class CollegeInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",
    val established: String = "",

    @Column(columnDefinition = "TEXT")
    val features: String = "",

    val mapUrl: String = "",
    val imageUrl: String? = null
)
