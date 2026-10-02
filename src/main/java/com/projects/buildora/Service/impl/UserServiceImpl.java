package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.UserService;
import com.projects.buildora.dto.auth.UserProfileResponse;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public UserProfileResponse getProfile(Long userId) {
        return null;
    }
}

