package com.example.rajbaricity

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

import org.springframework.scheduling.annotation.EnableAsync

@SpringBootApplication
@EnableAsync
class RajbaricityApplication

fun main(args: Array<String>) {
	runApplication<RajbaricityApplication>(*args)
	println("Application started successfully!")
}
