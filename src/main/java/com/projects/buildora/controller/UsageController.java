package com.projects.buildora.controller;

import com.projects.buildora.Service.UsageService;
import com.projects.buildora.dto.Subcription.PlanLimitResponse;
import com.projects.buildora.dto.Subcription.UsageTodayResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/usage")
@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
public class UsageController {

    UsageService usageService;

    @GetMapping("/api/usage")
    public ResponseEntity<UsageTodayResponse>getTodayUsage(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getTodayUsageOfUser(userId));
    }


    @GetMapping("/limits")
    public ResponseEntity<PlanLimitResponse>getPlanLimits(){
        Long userId=1L;
        return ResponseEntity.ok(usageService.getCurrentSubscriptionLimitsOfUser(userId));
    }


}
