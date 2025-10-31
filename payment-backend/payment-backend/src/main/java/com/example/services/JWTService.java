package com.example.services;

import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

@Service
public class JWTService {

  private String secretKey = "";
    private SecretKey key;

  public String generateToken(String email) {
    return "";
  }
  
}
