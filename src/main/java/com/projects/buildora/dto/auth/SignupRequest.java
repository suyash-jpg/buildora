package com.projects.buildora.dto.auth;

public record SignupRequest(
        String email,
        String name,
        String password
) {
}
