package com.inventory.inventory_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Use BCrypt for strong, salted password hashing
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF for stateless REST APIs
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authz -> authz
                        // Allow anyone to view the API list of products
                        .requestMatchers(HttpMethod.GET, "/api/products/**").permitAll()
                        // Allow anyone to view the web page list of products
                        .requestMatchers("/products").permitAll()
                        // Require authentication for any other request
                        .anyRequest().authenticated()
                )
                // Enable form-based login for the web UI
                .formLogin(Customizer.withDefaults());

        return http.build();
    }
}