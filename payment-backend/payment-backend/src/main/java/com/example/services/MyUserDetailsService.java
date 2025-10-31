package com.example.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.entity.MyUserDetails;
import com.example.entity.User;
import com.example.repos.AuthRepo;

@Service
public class MyUserDetailsService implements UserDetailsService{

  @Autowired
  private AuthRepo authRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User user = authRepo.findByEmail(username);

    if(user==null){
      System.out.println("User not found");
      throw new UsernameNotFoundException("user not found");
    }

    return new MyUserDetails(user);
  }
  
}
