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
import com.projects.buildora.mapper.ProjectMemberMapper;
import com.projects.buildora.repository.ProjectMemberRepository;
import com.projects.buildora.repository.ProjectRepository;
import com.projects.buildora.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
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
    @Override
    public ProjectResponse createProject(ProjectRequest request, Long userId) {
        User owner = userRepository.findById(userId).orElseThrow(() ->
                new ResourceNotFound("User",userId.toString()));

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
    public List<ProjectSummaryResponse> getUserProjects(Long userId) {

        var projects=projectRepository.findAllAccessibleByUser(userId);

        return projectMapper.toListOfProjectSummaryResponses(projects);
    }


    @Override
    public ProjectResponse getUserProjectsById(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);

        return   projectMapper.toProjectResponse(project);
    }


    @Override
    public ProjectResponse updateProject(Long id, ProjectRequest request, Long userId) {

        Project project = getAccessibleProjectById(id,userId);
        assert project != null;
        project .setName(request.name());
        project= projectRepository.save(project);
        return projectMapper.toProjectResponse(project);
    }

    @Override
    public void softDelete(Long id, Long userId) {

        Project project = getAccessibleProjectById(id,userId);

        project.setDeletedAt(Instant.now());
        projectRepository.save(project);
    }


    public Project getAccessibleProjectById(Long id, Long userId) {

        return projectRepository.findAccessibleProjectById(id,userId).orElseThrow(()-> new ResourceNotFound("Project" ,id.toString()));
    }
}
