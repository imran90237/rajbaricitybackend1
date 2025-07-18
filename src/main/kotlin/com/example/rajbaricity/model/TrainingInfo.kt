package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "training_info")
data class TrainingInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var organization: String = "",

    @Column(nullable = false)
    var qualification: String = "",

    @Column(nullable = false)
    var duration: String = "",

    @Column(nullable = false)
    var thana: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var fee: String = "",

    @Column(nullable = false)
    var phone: String = "",

    @Column(nullable = false)
    var email: String = "",

    @Column(nullable = false)
    var deadline: String = "",

    @Column(columnDefinition = "TEXT")
    var details: String = ""
)
