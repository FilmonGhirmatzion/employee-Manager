package com.filmon.employeemanager;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class EmployeemanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmployeemanagerApplication.class, args);
    }

    @Bean
    public CorsFilter corsFilter() {
        // Create a CORS configuration
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Allow the frontend's origin
        config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow these HTTP methods
        config.setAllowedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization")); // Allowed headers
        config.setAllowCredentials(true); // Allow credentials (cookies, authorization headers)
        config.setExposedHeaders(Arrays.asList("Authorization")); // Expose the Authorization header

        // Apply the CORS configuration to all endpoints
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config); // Apply to all paths

        // Return the CorsFilter with the configured source hhhhh
        return new CorsFilter(source);
    }
}
