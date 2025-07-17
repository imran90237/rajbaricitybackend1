package com.example.rajbaricity.model
import jakarta.persistence.*

@Entity
@Table(name = "blood_requests")
data class BloodRequest(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val bloodGroup: String = "",

    val bagCount: String = "",
    val dateTime: String = "",
    val phone: String = "",
    val hospital: String = "",
    val details: String = ""
)
