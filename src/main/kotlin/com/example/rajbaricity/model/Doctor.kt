package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "doctors")
data class Doctor(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "photo_res_id", nullable = false)
    val photoResId: Int = 0,

    @Column(name = "photo_uri")
    val photoUri: String? = null,

    @Column(nullable = false)
    val name: String = "",

    @Column(nullable = false)
    val specialty: String = "",

    @Column(nullable = false)
    val qualification: String = "",

    @Column(nullable = false)
    val workplace: String = "",

    @Column(name = "diseases_treated", nullable = false)
    val diseasesTreated: String = "",

    @Column(nullable = false)
    val chamber1: String = "",

    @Column(name = "map_link", nullable = false)
    val mapLink: String = ""
)
