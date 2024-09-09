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


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager user() {
        return new InMemoryUserDetailsManager(
                User.withUsername("admin")
                        .password("{bcrypt}" + new BCryptPasswordEncoder().encode("Matioszkar"))
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
