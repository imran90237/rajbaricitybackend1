package com.example.rajbaricity.repository

import com.example.rajbaricity.model.JobsTraining
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JobsTrainingRepository : JpaRepository<JobsTraining, Long>
