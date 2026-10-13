package com.projects.buildora.dto.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.extern.slf4j.Slf4j;

public record SignupRequest(
        @NotBlank @Email String email,
        @Size(min = 1, max = 30) String name,
        @Size(min = 4) String password
) {
}
