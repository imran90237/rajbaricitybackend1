package com.example.rajbaricity.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonProperty
import jakarta.persistence.*

@Entity
@Table(name = "lost_and_found_items")
data class LostAndFound(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val title: String = "",

    @Column(nullable = false)
    val description: String = "",

    @Column(nullable = false)
    val contactName: String = "",

    @Column(nullable = false)
    val contactPhone: String = "",

    val photoUrl: String = "",

    // এটি ডাটাবেজে সেভ হবে এবং এটাই আসল ডেটা
    var status: String = "LOST"
) {
    // এই প্রপার্টিটি শুধুমাত্র সার্ভার থেকে অ্যাপে JSON পাঠানোর জন্য ব্যবহৃত হবে
    @get:JsonProperty("isLost")
    val isLostForClient: Boolean
        get() = "LOST".equals(status, ignoreCase = true)

    // এই প্রপার্টিটি শুধুমাত্র অ্যাপ থেকে সার্ভারে JSON নেওয়ার জন্য ব্যবহৃত হবে
    @Transient
    @field:JsonIgnore // অ্যাপে JSON পাঠানোর সময় এটিকে উপেক্ষা করা হবে
    @set:JsonProperty("isLost")
    var isLostFromClient: Boolean = true

    // ডাটাবেজে সেভ বা আপডেট করার আগে 'status' ফিল্ডটিকে ঠিক করে নেবে
    @PrePersist
    @PreUpdate
    fun updateStatusFromClient() {
        this.status = if (isLostFromClient) "LOST" else "FOUND"
    }
}