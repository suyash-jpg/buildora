package com.projects.buildora.Service.impl;
import com.projects.buildora.Service.ProjectService;
import com.projects.buildora.dto.project.ProjectRequest;
import com.projects.buildora.dto.project.ProjectResponse;
import com.projects.buildora.dto.project.ProjectSummaryResponse;
import com.projects.buildora.entity.Project;
import com.projects.buildora.entity.ProjectMember;
import com.projects.buildora.entity.ProjectMemberId;
import com.projects.buildora.entity.User;
import com.projects.buildora.enums.ProjectRole;
import com.projects.buildora.error.ResourceNotFound;
import com.projects.buildora.mapper.ProjectMapper;
import com.projects.buildora.repository.ProjectMemberRepository;
import com.projects.buildora.repository.ProjectRepository;
import com.projects.buildora.repository.UserRepository;
import com.projects.buildora.security.AuthUtil;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;
import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Transactional
public class ProjectServiceImpl implements ProjectService {

    ProjectRepository projectRepository;
    UserRepository userRepository;
    ProjectMapper projectMapper;
    ProjectMemberRepository projectMemberRepository;
    AuthUtil authUtil;

    @Override
    public ProjectResponse createProject(ProjectRequest request) {
        Long userId=authUtil.getCurrentUserId();

//        User owner = userRepository.findById(userId).orElseThrow(() ->
//                new ResourceNotFound("User",userId.toString()));


        // to avoid database call use hibernate reference
        User owner = userRepository.getReferenceById(userId);

        Project project =Project.builder()
                .name(request.name())
                .isPublic(false)
                .build();
        project= projectRepository.save(project);

        ProjectMemberId projectMemberId = new ProjectMemberId(project.getId(), userId);

        ProjectMember projectMember = ProjectMember.builder()
                .id(projectMemberId)
                .projectRole(ProjectRole.OWNER)
                .user(owner)
                .acceptedAt(Instant.now())
                .invitedAt(Instant.now())
                .project(project)
                .build();
        projectMemberRepository.save(projectMember);
        return projectMapper.toProjectResponse(project);

    }


    @Override
    public List<ProjectSummaryResponse> getUserProjects() {
        Long userId=authUtil.getCurrentUserId();
        var projects=projectRepository.findAllAccessibleByUser(userId);

        return projectMapper.toListOfProjectSummaryResponses(projects);
    }


    @Override
    @PreAuthorize("@security.canViewProject(#projectId)")
    public ProjectResponse getUserProjectsById(Long projectId) {
        Long userId=authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);

        return   projectMapper.toProjectResponse(project);
    }


    @Override
    @PreAuthorize("@security.canEditProject(#projectId)")
    public ProjectResponse updateProject(Long projectId, ProjectRequest request) {
        Long userId=authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);
        assert project != null;
        project .setName(request.name());
        project= projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    @PreAuthorize("@security.canDeleteProject(#projectId)")
    public void softDelete(Long projectId) {
        Long userId=authUtil.getCurrentUserId();
        Project project = getAccessibleProjectById(projectId,userId);
        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }


    public Project getAccessibleProjectById(Long id, Long userId) {

        return projectRepository.findAccessibleProjectById(id,userId).orElseThrow(()-> new ResourceNotFound("Project" ,id.toString()));
    }
}
