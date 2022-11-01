package com.andrew.tacocloud.security;

import com.andrew.tacocloud.web.domains.User;
import com.andrew.tacocloud.data.jpa.UserRepositoryJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserRepositoryUserDetailsService implements UserDetailsService {
    private final UserRepositoryJpa userRepositoryJpa;

    @Autowired
    public UserRepositoryUserDetailsService(UserRepositoryJpa userRepositoryJpa) {
        this.userRepositoryJpa = userRepositoryJpa;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryJpa.findByUsername(username);
        if (user != null)
            return user;
        throw new UsernameNotFoundException("User '" + username + "' not found");
    }
}
