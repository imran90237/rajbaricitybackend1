package com.example.rajbaricity.model

import jakarta.persistence.*

@Entity
@Table(name = "madrasa_info")
data class MadrasaInfo(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    val name: String = "",
    val established: String = "",
    val features: String = "",
    val mapUrl: String = "",

    // You cannot store Uri or Drawable in DB; imageUri and imageRes are only for UI, not DB
    // Remove or ignore them from the entity
) {
    constructor() : this(0, "", "", "", "") // 👈 Required default constructor
}
