package com.projects.buildora.Service;


import com.projects.buildora.dto.auth.AuthResponse;
import com.projects.buildora.dto.auth.LoginRequest;
import com.projects.buildora.dto.auth.SignupRequest;

public interface AuthService {

    AuthResponse signup(SignupRequest request);

    AuthResponse login(LoginRequest request);

}
