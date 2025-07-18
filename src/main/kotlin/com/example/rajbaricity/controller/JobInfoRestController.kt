package com.example.rajbaricity.controller

import com.example.rajbaricity.model.JobInfo
import com.example.rajbaricity.service.JobInfoService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/jobs")
class JobInfoRestController(
    private val service: JobInfoService
) {

    @GetMapping
    fun getAllJobs(): List<JobInfo> = service.getAllJobs()

    @GetMapping("/{id}")
    fun getJobById(@PathVariable id: Long): ResponseEntity<JobInfo> {
        val job = service.getJobById(id)
        return if (job != null) ResponseEntity.ok(job)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun createJob(@RequestBody job: JobInfo): ResponseEntity<JobInfo> =
        ResponseEntity.ok(service.saveJob(job))

    @PutMapping("/{id}")
    fun updateJob(@PathVariable id: Long, @RequestBody job: JobInfo): ResponseEntity<JobInfo> {
        val updated = service.updateJob(id, job)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteJob(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.deleteJob(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
