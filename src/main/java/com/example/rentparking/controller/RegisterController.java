package com.example.rentparking.controller;

import com.example.rentparking.entity.User;
import com.example.rentparking.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@RequiredArgsConstructor
public class RegisterController {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @PostMapping
    public ResponseEntity<User> register(@RequestBody User user) throws Exception {
        System.out.println(user);
        if(userRepository.findByUsername(user.getUsername()) != null) {
            throw new Exception("User with this username exist");
        } else {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
        }
    }
}
