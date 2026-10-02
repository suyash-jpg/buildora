package com.projects.buildora.dto.Subcription;

public record PlanLimitResponse(
        String planName,
        Integer maxTokenPerDay,
        Integer maxProjects,
        Boolean unlimitedAi
) {

}
