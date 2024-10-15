package com.dovhal.application.controllers;

import com.dovhal.application.requests.LoginUserRequest;
import com.dovhal.application.model.User;
import com.dovhal.application.requests.RegistryUserRequest;
import com.dovhal.application.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<User> register(@Valid @RequestBody RegistryUserRequest request) {
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());

        User createdUser = userService.registerUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Valid @RequestBody LoginUserRequest request) {
        User foundUser = userService.findUserByUsername(request.getUsername());
        if (foundUser != null && passwordEncoder.matches(request.getPassword(), foundUser.getPassword())) {
            // Here you would typically generate a JWT and return it.
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }
}