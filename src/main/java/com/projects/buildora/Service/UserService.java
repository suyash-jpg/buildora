package com.projects.buildora.Service;

import com.projects.buildora.dto.auth.UserProfileResponse;

public interface UserService {

    UserProfileResponse getProfile(Long userId);
}
