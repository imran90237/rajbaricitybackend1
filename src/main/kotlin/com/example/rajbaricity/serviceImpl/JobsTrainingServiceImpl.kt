package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.JobsTraining
import com.example.rajbaricity.repository.JobsTrainingRepository
import com.example.rajbaricity.service.JobsTrainingService
import org.springframework.stereotype.Service

@Service
class JobsTrainingServiceImpl(private val repository: JobsTrainingRepository) : JobsTrainingService {
    override fun getJobsTraining(): List<JobsTraining> = repository.findAll()
    override fun getJobs(): List<JobsTraining> = repository.findAll().filter { it.isJob }
    override fun getTrainings(): List<JobsTraining> = repository.findAll().filter { !it.isJob }
    override fun addJobsTraining(jobsTraining: JobsTraining): JobsTraining = repository.save(jobsTraining)
    override fun updateJobsTraining(jobsTraining: JobsTraining): JobsTraining = repository.save(jobsTraining)
    override fun deleteJobsTraining(id: Long) = repository.deleteById(id)
}
