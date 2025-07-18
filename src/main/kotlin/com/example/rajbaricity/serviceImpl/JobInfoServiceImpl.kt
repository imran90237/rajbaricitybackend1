package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.JobInfo
import com.example.rajbaricity.repository.JobInfoRepository
import com.example.rajbaricity.service.JobInfoService
import org.springframework.stereotype.Service

@Service
class JobInfoServiceImpl(
    private val repository: JobInfoRepository
) : JobInfoService {

    override fun getAllJobs(): List<JobInfo> = repository.findAll()

    override fun getJobById(id: Long): JobInfo? =
        repository.findById(id).orElse(null)

    override fun saveJob(job: JobInfo): JobInfo = repository.save(job)

    override fun updateJob(id: Long, job: JobInfo): JobInfo? {
        return if (repository.existsById(id)) {
            repository.save(job.copy(id = id))
        } else null
    }

    override fun deleteJob(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
