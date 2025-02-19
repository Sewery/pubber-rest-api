package com.sartyro.pubberrestapi.config;

import lombok.SneakyThrows;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.beans.factory.annotation.Value;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    @Value("${credentials.username}")
    private String username;
    @Value("${credentials.password}")
    private String password;
    @Bean
    public InMemoryUserDetailsManager user() {
        return new InMemoryUserDetailsManager(
                User.withUsername(username)
                        .password("{bcrypt}" + new BCryptPasswordEncoder().encode(password))
                        .roles("USER", "ADMIN")
                        .build());
    }
    @SneakyThrows
    @Bean
    public SecurityFilterChain httpFilterChain(HttpSecurity http) {
        http
            .csrf(AbstractHttpConfigurer::disable)
            .authorizeHttpRequests(auth->{
                        auth.requestMatchers("/pubs/*").permitAll()
                                .anyRequest()
                                .authenticated();
                    })
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
