package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "lost_and_found_items")
data class LostAndFound(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String = "",

    @Column(nullable = false)
    val description: String = "",

    @Column(nullable = false)
    val contactName: String = "",


    @Column(nullable = false)
    val contactPhone: String = "",

    val photoUrl: String = "",

    val status: String = "LOST" // Should be "LOST" or "FOUND"
)



