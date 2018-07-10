package com.orienteer.orienteer.services;

import com.orienteer.orienteer.models.User;
import com.orienteer.orienteer.models.UserWithRoles;
import com.orienteer.orienteer.repositories.UsersRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {

    private final UsersRepository users;

    public UserDetailsLoader(UsersRepository users){
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findUserByUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("Couldn't find user w/ username: " + username);
        }
        return new UserWithRoles(user);
    }
}