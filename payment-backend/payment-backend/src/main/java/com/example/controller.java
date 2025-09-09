package com.example;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class controller {

    @GetMapping("/hi")
    public String hi(){
        return "hi Spring Boot";
    }

    @GetMapping("hello")
    public String hello(){
        return "Hello React";
    }
}
