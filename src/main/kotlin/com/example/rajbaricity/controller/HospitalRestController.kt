package com.example.rajbaricity.controller

import com.example.rajbaricity.model.Hospital
import com.example.rajbaricity.service.HospitalService
import jakarta.servlet.http.HttpServletRequest
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

@RestController
@RequestMapping("/api/hospitals")
class HospitalRestController(
    private val service: HospitalService
) {

    @GetMapping
    fun getAll(): List<Hospital> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<Hospital> {
        val hospital = service.getById(id)
        return if (hospital != null) ResponseEntity.ok(hospital)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody hospital: Hospital): ResponseEntity<Hospital> =
        ResponseEntity.ok(service.save(hospital))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody hospital: Hospital): ResponseEntity<Hospital> {
        val updated = service.update(id, hospital)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }

    @PostMapping("/upload")
    fun uploadImage(@RequestParam("image") file: MultipartFile, request: HttpServletRequest): ResponseEntity<Map<String, String>> {
        val fileName = "${UUID.randomUUID()}-${file.originalFilename}"
        val path = Paths.get("uploads", fileName)
        Files.copy(file.inputStream, path)

        // Construct the base URL from the request
        val baseUrl = request.scheme + "://" + request.serverName + ":" + request.serverPort
        val fileUrl = "$baseUrl/uploads/$fileName"

        return ResponseEntity.ok(mapOf("url" to fileUrl))
    }
}
