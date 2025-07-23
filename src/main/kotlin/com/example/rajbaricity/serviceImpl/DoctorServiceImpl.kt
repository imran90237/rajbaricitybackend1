package com.example.rajbaricity.service.impl

import com.example.rajbaricity.model.Doctor
import com.example.rajbaricity.repository.DoctorRepository
import com.example.rajbaricity.service.DoctorService
import org.springframework.stereotype.Service

@Service
class DoctorServiceImpl(private val doctorRepository: DoctorRepository) : DoctorService {

    override fun saveDoctor(doctor: Doctor): Doctor {
        return doctorRepository.save(doctor)
    }

    override fun getAllDoctors(): List<Doctor> {
        return doctorRepository.findAll()
    }

    override fun getDoctorById(id: Long): Doctor? {
        return doctorRepository.findById(id).orElse(null)
    }

    override fun updateDoctor(id: Long, doctor: Doctor): Doctor? {
        val existing = doctorRepository.findById(id)
        if (existing.isPresent) {
            val toUpdate = existing.get().copy(
                photoResId = doctor.photoResId,
                photoUri = doctor.photoUri,
                name = doctor.name,
                specialty = doctor.specialty,
                qualification = doctor.qualification,
                workplace = doctor.workplace,
                diseasesTreated = doctor.diseasesTreated,
                chamber1 = doctor.chamber1,
                mapLink = doctor.mapLink
            )
            return doctorRepository.save(toUpdate)
        }
        return null
    }

    override fun deleteDoctor(id: Long) {
        doctorRepository.deleteById(id)
    }
}
