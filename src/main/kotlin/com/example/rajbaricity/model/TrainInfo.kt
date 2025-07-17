package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "train_info")
data class TrainInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var trainName: String = "",

    @Column(nullable = false)
    var departureTime: String = "",

    @Column(nullable = false)
    var destination: String = ""
)
