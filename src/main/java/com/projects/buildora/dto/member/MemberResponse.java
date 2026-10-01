package com.projects.buildora.dto.member;

import com.projects.buildora.enums.ProjectRole;

import java.time.Instant;

public record MemberResponse(
        Long UserId,
        String email,
        String name,
        String avatarUrl,
        ProjectRole role,
        Instant invitedAt
)
{

}
