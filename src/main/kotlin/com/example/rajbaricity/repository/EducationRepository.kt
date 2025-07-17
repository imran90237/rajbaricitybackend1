package com.example.rajbaricity.repository

import com.example.rajbaricity.model.Education
<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface EducationRepository : JpaRepository<Education, Long>
=======
import org.springframework.stereotype.Repository

@Repository
class EducationRepository {

    fun getAllEducationInfo(): List<Education> {
        return listOf(
            Education(
                title = "রাজবাড়ী সরকারি কলেজ",
                description = "এই কলেজটি রাজবাড়ী জেলার অন্যতম প্রধান শিক্ষা প্রতিষ্ঠান।",
                contact = "017xxxxxxxx"
            ),
            Education(
                title = "রাজবাড়ী টেকনিক্যাল স্কুল",
                description = "কারিগরি শিক্ষা প্রদানের জন্য এটি একটি ভালো প্রতিষ্ঠান।",
                contact = "018xxxxxxxx"
            )
        )
    }
}
>>>>>>> oldrepo/master
