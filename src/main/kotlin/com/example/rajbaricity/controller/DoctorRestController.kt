package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Doctor
import com.example.rajbaricity.service.DoctorService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/doctors")
class DoctorRestController(private val doctorService: DoctorService) {

    @PostMapping
    fun createDoctor(@RequestBody request: Doctor): ResponseEntity<Doctor> {
        val doctorEntity = Doctor(
            photoResId = request.photoResId,
            photoUri = request.photoUri,
            name = request.name,
            specialty = request.specialty,
            qualification = request.qualification,
            workplace = request.workplace,
            diseasesTreated = request.diseasesTreated,
            chamber1 = request.chamber1,
            mapLink = request.mapLink
        )
        val savedDoctor = doctorService.saveDoctor(doctorEntity)
        return ResponseEntity.ok(savedDoctor)
    }

    @GetMapping
    fun getDoctors(): ResponseEntity<List<Doctor>> {
        val doctors = doctorService.getAllDoctors()
        return ResponseEntity.ok(doctors)
    }

    @GetMapping("/{id}")
    fun getDoctorById(@PathVariable id: Long): ResponseEntity<Doctor> {
        val doctor = doctorService.getDoctorById(id)
        return if (doctor != null) ResponseEntity.ok(doctor)
        else ResponseEntity.notFound().build()
    }

    @PutMapping("/{id}")
    fun updateDoctor(@PathVariable id: Long, @RequestBody request: Doctor): ResponseEntity<Doctor> {
        val doctorEntity = Doctor(
            id = id,
            photoResId = request.photoResId,
            photoUri = request.photoUri,
            name = request.name,
            specialty = request.specialty,
            qualification = request.qualification,
            workplace = request.workplace,
            diseasesTreated = request.diseasesTreated,
            chamber1 = request.chamber1,
            mapLink = request.mapLink
        )
        val updatedDoctor = doctorService.updateDoctor(id, doctorEntity)
        return if (updatedDoctor != null) ResponseEntity.ok(updatedDoctor)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteDoctor(@PathVariable id: Long): ResponseEntity<Void> {
        doctorService.deleteDoctor(id)
        return ResponseEntity.noContent().build()
    }
}
