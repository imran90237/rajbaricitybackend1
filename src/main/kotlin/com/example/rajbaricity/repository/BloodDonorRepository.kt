package com.example.rajbaricity.repository
import com.example.rajbaricity.model.BloodDonor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BloodDonorRepository : JpaRepository<BloodDonor, Long>
