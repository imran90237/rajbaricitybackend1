package com.example.rajbaricity.service

import com.example.rajbaricity.model.Doctor


interface DoctorService {
    fun saveDoctor(doctor: Doctor): Doctor
    fun getAllDoctors(): List<Doctor>
    fun getDoctorById(id: Long): Doctor?
    fun updateDoctor(id: Long, doctor: Doctor): Doctor?
    fun deleteDoctor(id: Long)
}
