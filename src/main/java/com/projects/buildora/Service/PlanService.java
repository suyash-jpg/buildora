package com.projects.buildora.Service;

import com.projects.buildora.dto.Subcription.PlanResponse;

import java.util.List;

public interface PlanService {


    List<PlanResponse> getAllActivePlans();
}
