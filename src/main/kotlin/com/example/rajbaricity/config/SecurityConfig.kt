package com.example.rajbaricity.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.web.SecurityFilterChain

@Configuration
@EnableWebSecurity
class SecurityConfig {

    @Bean
    fun passwordEncoder(): PasswordEncoder {
        return BCryptPasswordEncoder()
    }

    @Bean
    fun securityFilterChain(http: HttpSecurity): SecurityFilterChain {
        http
            .csrf { it.disable() } // CSRF সুরক্ষা নিষ্ক্রিয় করুন
            .authorizeHttpRequests { auth ->
                auth
                    .requestMatchers("/api/**").permitAll() // /api/ দিয়ে শুরু সব URL অনুমতি দিন
                    .anyRequest().authenticated() // বাকি সব URL এর জন্য authentication লাগবে
            }
        return http.build()
    }
}
