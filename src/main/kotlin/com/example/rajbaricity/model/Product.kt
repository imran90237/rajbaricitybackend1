package com.example.rajbaricity.model

import jakarta.persistence.*
import java.util.*

@Entity
@Table(name = "products")
data class Product(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    var title: String = "",

    @Column(nullable = false)
    var details: String = "",

    @Column(nullable = false)
    var address: String = "",

    @Column(nullable = false)
    var price: String = "",

    @Column(nullable = false)
    var mobile: String = "",

    @Column(nullable = false)
    var isNew: Boolean = true,

    @Column
    var imageUrl: String? = null,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    var createdAt: Date = Date()

) {
    // ✅ Required by Hibernate (JPA) to instantiate the entity
    constructor() : this(
        id = 0,
        title = "",
        details = "",
        address = "",
        price = "",
        mobile = "",
        isNew = true,
        imageUrl = null,
        createdAt = Date()
    )
}
