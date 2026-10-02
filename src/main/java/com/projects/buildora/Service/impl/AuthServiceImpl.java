package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.AuthService;
import com.projects.buildora.dto.auth.AuthResponse;
import com.projects.buildora.dto.auth.LoginRequest;
import com.projects.buildora.dto.auth.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {
    @Override
    public AuthResponse signup(SignupRequest request) {
        return null;
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        return null;
    }
}
