package com.security.learning.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class WebSecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/login", "/register", "/public/**").permitAll() // Allow login & register pages
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/login")  // Custom login page
                        .permitAll()          // Allow all users to access login
                )
                .logout(logout -> logout
                        .logoutUrl("/logout") // Custom logout URL
                        .logoutSuccessUrl("/login?logout") // Redirect to login after logout
                        .permitAll()
                );

        return http.build();
    }
}
