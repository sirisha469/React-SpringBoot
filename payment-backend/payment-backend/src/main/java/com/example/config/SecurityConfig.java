package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  public UserDetailsService userDetailsService;
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    return httpSecurity
      .csrf(AbstractHttpConfigurer::disable)
      .cors(Customizer.withDefaults())
      .authorizeHttpRequests(request -> request //by adding this line to that csrf we can only able to access /hi only remaining all the APIs are not reachable
                            .requestMatchers("/hi").permitAll()
                            .anyRequest().authenticated())
      .httpBasic(Customizer.withDefaults()) // by adding this line to above two lines we are getting basic authentications
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .build();
  }

  // @Bean
  // public UserDetailsService userDetailsService(){
  //   UserDetails user1 = User.builder()
  //                       .username("admin")
  //                       .password("{noop}admin")
  //                       .roles("ADMIN")
  //                       .build();
  //   UserDetails user2 = User.builder()
  //                       .username("user")
  //                       .password("{noop}user")
  //                       .roles("USER")
  //                       .build();
  //   return new InMemoryUserDetailsManager(user1,user2);
  // }

  @Bean
  public AuthenticationProvider authenticationProvider(){
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    provider.setUserDetailsService(userDetailsService);
    return provider;
  }
}
