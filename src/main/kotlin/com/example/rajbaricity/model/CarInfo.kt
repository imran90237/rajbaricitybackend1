package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "car_info")
data class CarInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var carName: String = "",

    @Column(nullable = false)
    var driverName: String = "",

    @Column(nullable = false)
    var type: String = "",

    @Column(nullable = false)
    var thana: String = "",

    @Column(nullable = false)
    var phone: String = ""
)
