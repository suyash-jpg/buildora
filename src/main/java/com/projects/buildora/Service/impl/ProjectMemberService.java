package com.projects.buildora.Service.impl;

import com.projects.buildora.dto.member.InviteMemberRequest;
import com.projects.buildora.dto.member.MemberResponse;
import com.projects.buildora.dto.member.UpdateMemberRoleRequest;
import com.projects.buildora.entity.ProjectMember;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectMemberService implements com.projects.buildora.Service.ProjectMemberService {
    @Override
    public List<ProjectMember> getProjectMembers(Long projectId, Long userId) {
        return List.of();
    }

    @Override
    public MemberResponse inviteMember(Long projectId, InviteMemberRequest request, Long userId) {
        return null;
    }

    @Override
    public MemberResponse updateMemberRole(Long projectId, UpdateMemberRoleRequest request, Long memberId) {
        return null;
    }

    @Override
    public MemberResponse deleteProjectMember(Long projectId, Long memberId, Long userId) {
        return null;
    }
}
