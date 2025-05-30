package ch.fhnw.pizza.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {


@Bean
public UserDetailsService users() {
    return new InMemoryUserDetailsManager(
        User.withUsername("myuser")
            .password("{noop}12345") // Mark as plaintext (no-op encoding)
            .roles("USER")
            .build(),
        User.withUsername("myadmin")
            .password("{noop}1234567")
            .roles("ADMIN")
            .build()
    );
}

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                // Public endpoints (no login required)
                .requestMatchers("/", "/menu/**", "/swagger-ui.html", "/v3/api-docs/**", "/swagger-ui/**", "/h2-console/**").permitAll()

                // Allow GET (read) for USER and ADMIN
                .requestMatchers(org.springframework.http.HttpMethod.GET, "/api/**").hasAnyRole("USER", "ADMIN")

                // Allow POST, PUT, DELETE (write) only for ADMIN
                .requestMatchers(org.springframework.http.HttpMethod.POST, "/api/**").hasRole("ADMIN")
                .requestMatchers(org.springframework.http.HttpMethod.PUT, "/api/**").hasRole("ADMIN")
                .requestMatchers(org.springframework.http.HttpMethod.DELETE, "/api/**").hasRole("ADMIN")

                // Everything else requires ADMIN
                .anyRequest().hasRole("ADMIN")
            )
            .headers(headers -> headers.frameOptions(frameOptions -> frameOptions.disable()))
            .httpBasic(withDefaults())
            .build();
    }
}
