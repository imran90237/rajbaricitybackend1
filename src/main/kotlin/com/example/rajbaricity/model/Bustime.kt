package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "bus_time")
data class Bustime(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "bus_name")
    val busName: String = "",

    @Column(name = "from_location")
    val from: String = "",

    @Column(name = "to_location")
    val to: String = "",

    val time: String = "",
    val contact: String = ""
)
