package com.example.uberappproject.uberapp.controllers;

import com.example.uberappproject.uberapp.dto.SignupDto;
import com.example.uberappproject.uberapp.dto.UserDto;
import com.example.uberappproject.uberapp.services.AuthService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignupDto signupDto){
        return authService.signup(signupDto);
    }
}
