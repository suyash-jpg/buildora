package com.projects.buildora.mapper;


import com.projects.buildora.dto.project.ProjectResponse;
import com.projects.buildora.dto.project.ProjectSummaryResponse;
import com.projects.buildora.entity.Project;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProjectMapper {

    ProjectResponse toProjectResponse(Project project);

    List<ProjectSummaryResponse> toListOfProjectSummaryResponses(List<Project> projects);

}
