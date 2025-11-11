package com.techsisters.gatherly.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebSecurity
public class SpringApiSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Disable CSRF (Cross-Site Request Forgery)
                // We disable this because we are using stateless REST APIs (not HTML forms).
                // Our React app will send a JWT, not a session cookie.
                .csrf(csrf -> csrf.disable())

                // This line tells Spring Security to use the 'corsConfigurationSource' bean
                // defined below.
                .cors(Customizer.withDefaults())

                // Configure Session Management to be STATELESS
                // This is essential for REST APIs.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Set up authorization rules
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()

                        // Whitelist your "send-otp" and other auth endpoints
                        .requestMatchers("/api/auth/send-otp").permitAll()

                        // Whitelist static resources
                        .requestMatchers("/", "/index.html", "/static/**").permitAll()

                        // Whitelist Swagger/OpenAPI docs (if you use them)
                        .requestMatchers(
                                "/v3/api-docs/**",
                                "/swagger-ui/**",
                                "/swagger-ui.html")
                        .permitAll()

                        // --- SECURE (PRIVATE) ENDPOINTS ---
                        // All other requests must be authenticated
                        .anyRequest().authenticated());

        // Here you would also add your JWT filter:
        // .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }

    // This bean configures what origins, methods, and headers are allowed.
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration configuration = new CorsConfiguration();

        // Allow your React app's origin
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:3000"));

        // Allow all necessary HTTP methods
        configuration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));

        // Allow all headers
        configuration.setAllowedHeaders(Arrays.asList("*"));

        // Allow credentials (if you use cookies)
        configuration.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        // Apply this configuration to all routes
        source.registerCorsConfiguration("/**", configuration);

        return source;
    }
}
