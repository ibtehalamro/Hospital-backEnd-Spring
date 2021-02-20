package com.hospital.service;

import com.hospital.domain.User;
import com.hospital.exceptions.UserExceptions.UsernameAlreadyExistsException;
import com.hospital.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public User saveUser(User user) {

        try {
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            return userRepository.save(user);
        } catch (Exception e) {
            throw new UsernameAlreadyExistsException("Username "+user.getUsername()+" already exists.");
        }
    }
}
