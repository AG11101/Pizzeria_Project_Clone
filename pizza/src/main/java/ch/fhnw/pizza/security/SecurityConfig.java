/*

package ch.fhnw.pizza.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration

public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers("/swagger-ui/**", "/v3/api-docs/**").permitAll() // Allow Swagger access
            .anyRequest().authenticated(); // Secure other endpoints
        return http.build();
    }
}
*/

/*The security dependency should be added later*/