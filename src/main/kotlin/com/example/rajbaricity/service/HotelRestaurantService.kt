package com.example.rajbaricity.service

import com.example.rajbaricity.model.HotelRestaurant

interface HotelRestaurantService {
    fun getAll(): List<HotelRestaurant>
    fun getById(id: Long): HotelRestaurant?
    fun save(hotel: HotelRestaurant): HotelRestaurant
    fun update(id: Long, hotel: HotelRestaurant): HotelRestaurant?
    fun delete(id: Long): Boolean
}
