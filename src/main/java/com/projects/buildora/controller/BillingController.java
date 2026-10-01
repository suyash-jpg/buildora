package com.projects.buildora.controller;

import com.projects.buildora.Service.PlanService;
import com.projects.buildora.Service.SubscriptionService;
import com.projects.buildora.dto.Subcription.PlanResponse;
import com.projects.buildora.entity.Plan;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BillingController {
    private final PlanService planService;
    private final SubscriptionService subscriptionService;

    @GetMapping("/api/plan")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {

        return ResponseEntity.ok(planService.getAllActivePlans());

    }

    @GetMapping("/api/me/subsription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){


    }

}
