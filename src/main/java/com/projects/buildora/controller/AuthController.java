package com.projects.buildora.controller;


import com.projects.buildora.Service.AuthService;
import com.projects.buildora.dto.auth.AuthResponse;
import com.projects.buildora.dto.auth.SignupRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private  AuthService authservice;


    public ResponseEntity<AuthResponse> signup(SignupRequest signupRequest) {

    }


}
