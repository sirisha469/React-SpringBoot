package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.dto.UserDto;
import com.example.entity.User;
import com.example.repos.AuthRepo;

@Service
public class AuthService {
  
  @Autowired
  private AuthRepo authRepo;
  
  private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(12);

  public UserDto register(UserDto userRequest){
    //System.out.println(userRequest);
    UserDto userResponse = new UserDto();
    User user = new User();

    if(findByEmail(userRequest.getEmail())){
      user.setId(userRequest.getId());
      user.setName(userRequest.getName());
      user.setEmail(userRequest.getEmail());
      user.setMobile(userRequest.getMobile());
      user.setPassword(encoder.encode(userRequest.getPassword()));

      User userResult = authRepo.save(user);
      System.out.println("User Results: "+userResult);
      if(userResult.getId()>0){
        userResponse.setId(userResult.getId());
        userResponse.setUser(userResult);
        userResponse.setMessage("User saved successfully");
      } 
    }
    else{
      userResponse.setMessage("User aleardy exists");
    }

    return userResponse;  
  }

  public boolean findByEmail(String email){
    return authRepo.findByEmail(email)==null;
  }


  public UserDto login(UserDto userRequest){
    UserDto userResponse = new UserDto();

    if(findByEmail(userRequest.getEmail())){

    }

    return userResponse;
  }
}
