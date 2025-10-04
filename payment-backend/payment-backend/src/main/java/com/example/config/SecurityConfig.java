package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    return httpSecurity
      /*CSRF protection is designed for session-based authentication (where browsers automatically send cookies).

      In JWT-based authentication:

      We don’t rely on cookies.
      Each request is authenticated by the Authorization: Bearer <token> header.
      So CSRF tokens are unnecessary.

      POST /register
      Authorization: Bearer <your-jwt-token>
      Content-Type: application/json

      {
        "username": "sirisha",
        "password": "12345"
      }
      Even though you provided a valid JWT, Spring Security will reject the request because it’s missing a CSRF token.

      You’ll see a 403 Forbidden response with a message like:
      */
      .csrf(AbstractHttpConfigurer::disable) //only with this line we can able to login to all pages without authentication
      .authorizeHttpRequests(request -> request //by adding this line to that csrf we can only able to access /hi only remaining all the APIs are not reachable
                            .requestMatchers("/hi").permitAll()
                            .anyRequest().authenticated())
      .httpBasic(Customizer.withDefaults()) // by adding this line to above two lines we are getting basic authentications
      .build();
  }
}
