package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.PlanService;
import com.projects.buildora.dto.Subcription.PlanResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanServiceImpl implements PlanService {
    @Override
    public List<PlanResponse> getAllActivePlans() {
        return List.of();
    }
}
