package com.projects.buildora.dto.auth;

public record UserProfileResponse(
        Long id,
        String email,
        String name,
        String avtarUrl
) {

}
