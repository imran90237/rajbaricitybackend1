package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "donors")
data class BloodDonor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val bloodGroup: String = "",

    val donationDate: String = "",

    val address: String = "",

    val phone: String = ""
)
