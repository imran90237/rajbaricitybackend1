package com.example.rajbaricity.service

import com.example.rajbaricity.model.JobInfo

interface JobInfoService {
    fun getAllJobs(): List<JobInfo>
    fun getJobById(id: Long): JobInfo?
    fun saveJob(job: JobInfo): JobInfo
    fun updateJob(id: Long, job: JobInfo): JobInfo?
    fun deleteJob(id: Long): Boolean
}
