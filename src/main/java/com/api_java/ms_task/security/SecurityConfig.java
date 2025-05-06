package com.api_java.ms_task.security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    
    // ROLE_USER
    // ROLE_ADMIN

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http ) throws Exception {

        http
        .csrf(csrf -> csrf.disable())
        /* .authorizeHttpRequests()
                .requestMatchers("/api/lembretes/**").permitAll()
                .requestMatchers("/singleton/**").permitAll()
                .requestMatchers("/api/tarefas/**").permitAll()
                .anyRequest().authenticated()*/
        .oauth2ResourceServer(oauth2 -> oauth2
        .jwt(jwt -> jwt.jwtAuthenticationConverter(new JWTConverter())));
         

        return http.build();
    }
}
