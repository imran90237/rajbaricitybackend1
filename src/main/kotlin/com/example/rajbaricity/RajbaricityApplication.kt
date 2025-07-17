package com.example.rajbaricity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class RajbaricityApplication

fun main(args: Array<String>) {
	runApplication<RajbaricityApplication>(*args)
	println("Application started successfully!")
}
