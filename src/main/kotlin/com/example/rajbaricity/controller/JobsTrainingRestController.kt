package com.example.rajbaricity.controller

import com.example.rajbaricity.model.JobsTraining
import com.example.rajbaricity.service.JobsTrainingService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/jobs-training")
class JobsTrainingRestController(private val service: JobsTrainingService) {

    @GetMapping
    fun getAllJobsTraining(): List<JobsTraining> = service.getJobsTraining()

    @GetMapping("/jobs")
    fun getAllJobs(): List<JobsTraining> = service.getJobs()

    @GetMapping("/trainings")
    fun getAllTrainings(): List<JobsTraining> = service.getTrainings()

    @PostMapping
    fun addJobsTraining(@RequestBody jobsTraining: JobsTraining): JobsTraining = service.addJobsTraining(jobsTraining)

    @PutMapping
    fun updateJobsTraining(@RequestBody jobsTraining: JobsTraining): JobsTraining = service.updateJobsTraining(jobsTraining)

    @DeleteMapping("/{id}")
    fun deleteJobsTraining(@PathVariable id: Long) = service.deleteJobsTraining(id)
}
