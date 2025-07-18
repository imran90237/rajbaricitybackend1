package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "lost_and_found_items")
data class LostAndFoundItem(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val itemName: String = "",

    @Column(nullable = false)
    val personName: String = "",

    @Column(nullable = false)
    val phone: String = "",

    @Column(nullable = false)
    val status: String = "" // Should be "LOST" or "FOUND"
)
