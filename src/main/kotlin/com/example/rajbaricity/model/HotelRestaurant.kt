package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "hotel_restaurant")
data class HotelRestaurant(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var name: String = "",

    @Column(nullable = false)
    var menu: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var phone: String = ""
)
