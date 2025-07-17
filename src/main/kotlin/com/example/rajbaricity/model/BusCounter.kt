package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "bus_counter")
data class BusCounter(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(name = "counter_name")
    val counterName: String = "",

    val location: String = "",
    val contact: String = ""
)
