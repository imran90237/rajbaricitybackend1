package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "sections")
data class Section(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String,

    @Column(nullable = false)
    val icon: String,

    @Column(nullable = false, unique = true)
    val route: String
)
