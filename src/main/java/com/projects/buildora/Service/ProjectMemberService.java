package com.projects.buildora.Service;

import com.projects.buildora.dto.member.InviteMemberRequest;
import com.projects.buildora.dto.member.MemberResponse;
import com.projects.buildora.dto.member.UpdateMemberRoleRequest;

import java.util.List;

public interface ProjectMemberService {
    List<MemberResponse> getProjectMembers(Long projectId);

    MemberResponse inviteMember(Long projectId, InviteMemberRequest request);

    MemberResponse updateMemberRole(Long projectId, UpdateMemberRoleRequest request, Long memberId);

    void removeProjectMember(Long projectId, Long memberId);
}
