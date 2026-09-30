package com.projects.buildora.controller;


import com.projects.buildora.Service.AuthService;
import com.projects.buildora.Service.UserService;
import com.projects.buildora.dto.auth.AuthResponse;
import com.projects.buildora.dto.auth.LoginRequest;
import com.projects.buildora.dto.auth.SignupRequest;
import com.projects.buildora.dto.auth.UserProfileResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final   AuthService authservice;
    private final UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(SignupRequest request) {

        return ResponseEntity.ok(authservice.signup(request));

    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(LoginRequest request) {
        return ResponseEntity.ok(authservice.login(request));
    }


    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }



}
