package com.projects.buildora.dto.member;

import com.projects.buildora.enums.ProjectRole;

public record UpdateMemberRoleRequest(
        ProjectRole role
) {
}
