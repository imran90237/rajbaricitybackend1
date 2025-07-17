package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "educations")
data class Education(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
<<<<<<< HEAD
    val title: String = "",

    @Column(columnDefinition = "TEXT")
    val description: String = "",

    @Column(nullable = false)
    val contact: String = ""
=======
    val title: String,

    @Column(columnDefinition = "TEXT")
    val description: String,

    @Column(nullable = false)
    val contact: String
>>>>>>> oldrepo/master
)
