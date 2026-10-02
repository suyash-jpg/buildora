package com.projects.buildora.controller;

import com.projects.buildora.Service.ProjectService;
import com.projects.buildora.dto.project.ProjectRequest;
import com.projects.buildora.dto.project.ProjectResponse;
import com.projects.buildora.dto.project.ProjectSummaryResponse;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)

public class ProjectController {

    ProjectService projectService;


    @GetMapping
    public ResponseEntity<List<ProjectSummaryResponse>> getAllProjects() {
        Long userId=1L;

        return ResponseEntity.ok(projectService.getUserProjects(userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProjectResponse> getProjectById(@PathVariable Long id) {

        Long userId=1L;
        return ResponseEntity.ok(projectService.getUserProjectsById(id,userId));

    }

    @PostMapping
    public ResponseEntity<ProjectResponse> createProject(@RequestBody ProjectRequest request){
        Long userId=1L;
        return ResponseEntity.status(HttpStatus.CREATED).body(projectService.createProject(request,userId));

    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProjectResponse> updateProject(@PathVariable Long id, @RequestBody ProjectRequest request){
        Long userId=1L;
        return ResponseEntity.ok(projectService.updateProject(id,request,userId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable Long id){
        Long userId=1L;
        projectService.softDelete(id,userId);
        return ResponseEntity.noContent().build();
    }
}
