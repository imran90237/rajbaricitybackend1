package com.example.rajbaricity.repository

import com.example.rajbaricity.model.HotelRestaurant
import org.springframework.data.jpa.repository.JpaRepository

interface HotelRestaurantRepository : JpaRepository<HotelRestaurant, Long>
