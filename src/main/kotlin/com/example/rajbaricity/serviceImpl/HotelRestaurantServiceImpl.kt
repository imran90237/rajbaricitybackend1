package com.example.rajbaricity.serviceImpl

import com.example.rajbaricity.model.HotelRestaurant
import com.example.rajbaricity.repository.HotelRestaurantRepository
import com.example.rajbaricity.service.HotelRestaurantService
import org.springframework.stereotype.Service

@Service
class HotelRestaurantServiceImpl(
    private val repository: HotelRestaurantRepository
) : HotelRestaurantService {

    override fun getAll(): List<HotelRestaurant> = repository.findAll()

    override fun getById(id: Long): HotelRestaurant? =
        repository.findById(id).orElse(null)

    override fun save(hotel: HotelRestaurant): HotelRestaurant =
        repository.save(hotel)

    override fun update(id: Long, hotel: HotelRestaurant): HotelRestaurant? {
        return if (repository.existsById(id)) {
            repository.save(hotel.copy(id = id))
        } else null
    }

    override fun delete(id: Long): Boolean {
        return if (repository.existsById(id)) {
            repository.deleteById(id)
            true
        } else false
    }
}
