package com.greenharbor.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greenharbor.model.User;
import com.greenharbor.repository.UserRepository;

import java.util.Set;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws AccountNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AccountNotFoundException("User not found"));

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                Set.of(new SimpleGrantedAuthority("ROLE_" + user.getRole()))
        );
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }
}
