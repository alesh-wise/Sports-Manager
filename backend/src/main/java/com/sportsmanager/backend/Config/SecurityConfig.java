package com.sportsmanager.backend.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecurityConfig {

    private final JwtAuthFilter jwtAuthFilter;

    // Injetamos o filtro que acabaste de criar
    public SecurityConfig(JwtAuthFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable())
                // Informamos o Spring que não queremos gerir sessões (o JWT não tem estado / Stateless)
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))

                // Regras das Portas da Aplicação
                .authorizeHttpRequests(auth -> auth
                        // Deixar toda a gente fazer Login
                        .requestMatchers("/auth/login").permitAll()
                        // Deixar toda a gente criar conta (Registar)
                        .requestMatchers(HttpMethod.POST, "/utilizadores").permitAll()
                        // EXIGIR TOKEN VÁLIDO PARA ABSOLUTAMENTE TUDO O RESTO
                        .anyRequest().authenticated()
                )
                // Colocamos o nosso Segurança à porta (antes de qualquer filtro do Spring)
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();
    }
}