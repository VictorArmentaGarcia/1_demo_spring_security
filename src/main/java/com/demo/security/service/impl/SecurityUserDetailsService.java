package com.demo.security.service.impl;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import com.demo.security.repository.UsersRepository;
import com.demo.security.security.SecurityUser;

@Repository
public class SecurityUserDetailsService implements UserDetailsService {

    private final UsersRepository userRepository;

    public SecurityUserDetailsService(UsersRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        var user = this.userRepository.findByName(username);

        if(user.isPresent()){
           return new SecurityUser(user.get());
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }

}
