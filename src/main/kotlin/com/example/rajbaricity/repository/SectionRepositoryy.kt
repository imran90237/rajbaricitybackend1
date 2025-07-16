package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Section
import org.springframework.stereotype.Repository

@Repository
class SectionRepository {

    fun getAllSections(): List<Section> = listOf(
        Section(1L, "শিক্ষা", "📚", "education"),
        Section(2L, "ডাক্তার", "🩺", "doctor"),
        Section(3L, "হাসপাতাল", "🏥", "hospital"),
        Section(4L, "রক্ত", "🩸", "blood"),
        Section(5L, "বাসের সময়সূচী", "🚌", "bus_schedule"),
        Section(6L, "ট্রেনের সময়সূচী", "🚆", "train_schedule"),
        Section(7L, "জরুরি নাম্বার ও হেল্পলাইন", "📞", "emergency"),
        Section(8L, "দর্শনীয় স্থান", "📸", "tourist_places"),
        Section(9L, "ওয়েবসাইট", "🌐", "websites"),
        Section(10L, "মিস্ত্রি", "🛠️", "mistry"),
        Section(11L, "গাড়ি ভাড়া", "🚖", "car_rent"),
        Section(12L, "হারানো ও পাওয়া", "🧳", "lost_found"),
        Section(13L, "কুরিয়ার সার্ভিস", "📦", "courier"),
        Section(14L, "চাকরি ও প্রশিক্ষণ", "💼", "jobs_training"),
        Section(15L, "হোটেল রেস্টুরেন্ট", "🍽️", "hotels_restaurants"),
        Section(16L, "লোকাল মার্কেট", "🛍️", "local_market"),
        Section(17L, "ব্যবসা ও কৃষি সহায়তা", "🌾", "business_agriculture"),
        Section(18L, "কাছাকাছি মসজিদ", "🕌", "mosque_nearby")
    )

}

