package com.example.rajbaricity.service

import com.example.rajbaricity.model.JobsTraining

interface JobsTrainingService {
    fun getJobsTraining(): List<JobsTraining>
    fun getJobs(): List<JobsTraining>
    fun getTrainings(): List<JobsTraining>
    fun addJobsTraining(jobsTraining: JobsTraining): JobsTraining
    fun updateJobsTraining(jobsTraining: JobsTraining): JobsTraining
    fun deleteJobsTraining(id: Long)
}
