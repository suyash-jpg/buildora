package com.projects.buildora.controller;

import com.projects.buildora.Service.ProjectMemberService;
import com.projects.buildora.dto.member.InviteMemberRequest;
import com.projects.buildora.dto.member.MemberResponse;
import com.projects.buildora.entity.ProjectMember;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects/{projectId}/members")
public class ProjectMemberController {

    private final ProjectMemberService projectMemberService;



    @GetMapping
    public ResponseEntity<List<ProjectMember>> getProjectMembers(@PathVariable Long projectId) {

        Long UserId= 1L;

        return ResponseEntity.ok(projectMemberService.getProjectMembers(projectId,UserId));
    }


    @PostMapping
    public ResponseEntity<MemberResponse> createProjectMember(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequest request){

        Long UserId= 1L;

        return ResponseEntity.status(HttpStatus.CREATED).body(
                projectMemberService.inviteMember(projectId,request,UserId)
        );

    }

    @PatchMapping("/{memberId}")
    public ResponseEntity<MemberResponse> updateMemberRole(
            @PathVariable Long projectId,
            @RequestBody InviteMemberRequest request,
            @PathVariable Long memberId
    ){
        Long UserId= 1L;
        return ResponseEntity.ok(projectMemberService.updateMemberRole(projectId,request,memberId));

    }

    @DeleteMapping("/{memberId}")
    public ResponseEntity<MemberResponse> deleteProjectMember(
            @PathVariable Long projectId,
            @PathVariable Long memberId
    ){
        Long UserId= 1L;
        return ResponseEntity.ok(projectMemberService.deleteProjectMember(projectId,memberId,UserId));
    }




}
