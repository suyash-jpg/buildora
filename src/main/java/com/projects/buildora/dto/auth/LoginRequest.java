package com.projects.buildora.dto.auth;

public record LoginRequest(
        String email,
        String password
) {
}
