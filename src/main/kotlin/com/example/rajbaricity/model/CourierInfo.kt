package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "courier_info")
data class CourierInfo(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var mapUrl: String = "",

    @Column(nullable = false)
    var phone: String = ""
)
