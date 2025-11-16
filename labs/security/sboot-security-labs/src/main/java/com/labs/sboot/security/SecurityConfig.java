package com.labs.sboot.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // Configure your security filter chain herehttp
        http
                .csrf(csrf -> csrf.disable())
                .cors(cors -> cors.disable())
            .authorizeHttpRequests(authz -> authz
//                            .requestMatchers("/accounts/**").authenticated()
//                            .anyRequest().permitAll()
                            .requestMatchers("/").permitAll()
                            .anyRequest().authenticated()
                        )
                .httpBasic(Customizer.withDefaults());
//                        .formLogin(Customizer.withDefaults());

        return http.build();
    }

}
