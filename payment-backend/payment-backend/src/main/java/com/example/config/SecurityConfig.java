package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.services.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

  @Autowired
  public MyUserDetailsService myUserDetailsService;
  
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{

    return httpSecurity
      .csrf(AbstractHttpConfigurer::disable)
      .cors(Customizer.withDefaults())
      .authorizeHttpRequests(request -> request //by adding this line to that csrf we can only able to access /hi only remaining all the APIs are not reachable
                            .requestMatchers("/hi","/register","/login").permitAll()
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
    //provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
    provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
    provider.setUserDetailsService(myUserDetailsService);
    return provider;
  }

  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception{
    return config.getAuthenticationManager();
  }
}
