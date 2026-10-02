package com.projects.buildora.controller;


import com.projects.buildora.Service.AuthService;
import com.projects.buildora.Service.UserService;
import com.projects.buildora.dto.auth.AuthResponse;
import com.projects.buildora.dto.auth.LoginRequest;
import com.projects.buildora.dto.auth.SignupRequest;
import com.projects.buildora.dto.auth.UserProfileResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class AuthController {

    AuthService authservice;
    UserService userService;


    @PostMapping("/signup")
    public ResponseEntity<AuthResponse> signup(@RequestBody SignupRequest request) {

        return ResponseEntity.ok(authservice.signup(request));

    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(authservice.login(request));
    }


    @GetMapping("/me")
    public ResponseEntity<UserProfileResponse> getProfile() {
        Long userId=1L;
        return ResponseEntity.ok(userService.getProfile(userId));
    }



}
