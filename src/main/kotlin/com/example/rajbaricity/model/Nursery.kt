package com.example.rajbaricity.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "nurseries")
data class Nursery(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var owner: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var mobile: String = "",

    var imageUri: String? = null,  // Store URI as String (e.g., Firebase or local path)

    @Temporal(TemporalType.TIMESTAMP)
    var createdAt: Date = Date()
)
