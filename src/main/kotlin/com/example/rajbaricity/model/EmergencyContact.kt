package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "emergency_contact")
data class EmergencyContact(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var title: String = "",

    @ElementCollection
    @CollectionTable(name = "emergency_details", joinColumns = [JoinColumn(name = "contact_id")])
    @Column(name = "detail")
    var details: List<String> = listOf(),

    var icon: String = "",

    var color: String = "#000000" // HEX Color (e.g. Black)
)
