package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.AuthService;
import com.projects.buildora.dto.auth.AuthResponse;
import com.projects.buildora.dto.auth.LoginRequest;
import com.projects.buildora.dto.auth.SignupRequest;
import com.projects.buildora.entity.User;
import com.projects.buildora.error.BadRequestException;
import com.projects.buildora.mapper.UserMapper;
import com.projects.buildora.repository.UserRepository;
import com.projects.buildora.security.AuthUtil;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.authentication.AuthenticationManager;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    UserRepository userRepository;
    UserMapper userMapper;
    PasswordEncoder passwordEncoder;
    AuthUtil authUtil;
    AuthenticationManager authenticationManager;

    @Override
    public AuthResponse signup(SignupRequest request) {
        userRepository.findByUsername(request.username()).ifPresent(user -> {
            throw new BadRequestException("Username already exists with  username: " +request.username());
        });
        User user= userMapper.toEntity(request);
        user.setPassword(passwordEncoder.encode(request.password()));
        user= userRepository.save(user);

        String token= authUtil.generateAccessToken(user);

        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
    }

    @Override
    public AuthResponse login(LoginRequest request) {
        Authentication authentication= authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.username(),request.password())
        );

        User user= (User) authentication.getPrincipal();

        String token= authUtil.generateAccessToken(user);

        return new AuthResponse(token,userMapper.toUserProfileResponse(user));
    }
}
