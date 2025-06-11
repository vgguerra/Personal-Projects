package com.victorguerra.projects.Configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // 1. Para uma API REST stateless, desabilitar CSRF é uma prática comum.
                .csrf(AbstractHttpConfigurer::disable)

                // 2. Regras de autorização corrigidas e mais específicas.
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/project/admin/**").hasRole("ADMIN") // Caminho correto e verificação de papel
                        .anyRequest().permitAll() // Permite acesso público para visualização
                )

                // 3. Habilita a autenticação HTTP Basic, ideal para APIs REST.
                .httpBasic(Customizer.withDefaults())

                // 4. Garante que a API seja stateless (sem sessão), que é o padrão para REST.
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}