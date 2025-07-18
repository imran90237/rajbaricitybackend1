package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "mistry_info")
data class Mistry(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    var photoUrl: String = "",

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var skill: String = "",

    @Column(nullable = false)
    var experience: String = "",

    @Column(nullable = false)
    var workplace: String = "",

    @Column(nullable = false)
    var specialtyWork: String = "",

    var chamber1: String = "",
    var chamber2: String = "",
    var chamber3: String = "",

    @Column(nullable = false)
    var phone: String = ""
)
