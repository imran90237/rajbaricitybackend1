package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "hospital")
data class Hospital(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var phone: String = "",

    @Column(nullable = false)
    var hours: String = "",

    @Column(nullable = false)
    var hasEmergency: Boolean = false,

    var mapUrl: String = "",

    var photoUrl: String = "" // You can save a URL or relative path
)
