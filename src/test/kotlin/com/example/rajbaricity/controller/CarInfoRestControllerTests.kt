package com.example.rajbaricity.controller

import com.example.rajbaricity.model.CarInfo
import com.example.rajbaricity.repository.CarInfoRepository
import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.post
import org.springframework.transaction.annotation.Transactional

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CarInfoRestControllerTests {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var objectMapper: ObjectMapper

    @Autowired
    private lateinit var carInfoRepository: CarInfoRepository

    @Test
    fun `should create a new car`() {
        val newCar = CarInfo(
            carName = "Test Car",
            driverName = "Test Driver",
            type = "Sedan",
            thana = "Rajbari Sadar",
            phone = "01234567890"
        )

        mockMvc.post("/api/cars") {
            contentType = MediaType.APPLICATION_JSON
            content = objectMapper.writeValueAsString(newCar)
        }.andExpect {
            status { isOk() }
            jsonPath("$.id") { isNotEmpty() }
            jsonPath("$.carName") { value(newCar.carName) }
            jsonPath("$.driverName") { value(newCar.driverName) }
            jsonPath("$.phone") { value(newCar.phone) }
        }

        // Verify it was saved to the database
        val cars = carInfoRepository.findAll()
        assert(cars.any { it.carName == "Test Car" && it.driverName == "Test Driver" })
    }
}
