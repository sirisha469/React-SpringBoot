package com.example.dto;

import com.example.entity.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class UserDto {
  
  private int id;
  private String userName;
  private String email;
  private String mobile;
  private String password;
  private User user;
  private String message;
  private String error;

}
