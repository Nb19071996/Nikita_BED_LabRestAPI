package com.gl.Collegefest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.gl.Collegefest.entity.User;
import com.gl.Collegefest.repository.UserRepository;
import com.gl.Collegefest.security.MyUserDetails;

public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        User user = userRepository.getUserByUsername(username);
        if (user==null){
            throw new UsernameNotFoundException("not found");
        }
        return new MyUserDetails(user);
    }

}
