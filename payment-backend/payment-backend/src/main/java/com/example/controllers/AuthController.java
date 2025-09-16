package com.example.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dto.UserDto;
import com.example.services.AuthService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AuthController {

    @Autowired
    private AuthService authService;

    @GetMapping("/hi")
    public String hi(){
        return "hi Spring Boot";
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello React";
    }

   
    @PostMapping("/register") 
    public ResponseEntity<UserDto> register(@RequestBody UserDto requestBody){
        UserDto user = authService.register(requestBody);
        //System.out.println(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public String postMethodName(@RequestBody String entity) {
        return entity;
    }
    
}
