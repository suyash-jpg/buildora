package com.projects.buildora.security;

import com.projects.buildora.enums.ProjectRole;
import com.projects.buildora.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component("security")
@RequiredArgsConstructor
public class SecurityExpressions {

    private final AuthUtil authUtil;
    private final ProjectMemberRepository projectMemberRepository;


    public boolean canViewProject(Long projectId) {

        Long userId= authUtil.getCurrentUserId();

       return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId).map(role -> role.equals(ProjectRole.OWNER)
               || role.equals(ProjectRole.EDITOR)
               || role.equals(ProjectRole.VIEWER))
               .orElse(false);
    }

    public boolean canEditProject(Long projectId) {
        Long userId= authUtil.getCurrentUserId();

        return projectMemberRepository.findRoleByProjectIdAndUserId(projectId,userId).map(role -> role.equals(ProjectRole.OWNER)
                        || role.equals(ProjectRole.EDITOR))
                .orElse(false);
    }
}
