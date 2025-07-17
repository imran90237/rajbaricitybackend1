package com.example.rajbaricity.controller

import com.example.rajbaricity.model.HotelRestaurant
import com.example.rajbaricity.service.HotelRestaurantService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/hotels")
class HotelRestaurantRestController(
    private val service: HotelRestaurantService
) {

    @GetMapping
    fun getAll(): List<HotelRestaurant> = service.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<HotelRestaurant> {
        val hotel = service.getById(id)
        return if (hotel != null) ResponseEntity.ok(hotel)
        else ResponseEntity.notFound().build()
    }

    @PostMapping
    fun create(@RequestBody hotel: HotelRestaurant): ResponseEntity<HotelRestaurant> =
        ResponseEntity.ok(service.save(hotel))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody hotel: HotelRestaurant): ResponseEntity<HotelRestaurant> {
        val updated = service.update(id, hotel)
        return if (updated != null) ResponseEntity.ok(updated)
        else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Void> {
        return if (service.delete(id)) ResponseEntity.noContent().build()
        else ResponseEntity.notFound().build()
    }
}
