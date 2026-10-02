package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.UsageService;
import com.projects.buildora.dto.Subcription.PlanLimitResponse;
import com.projects.buildora.dto.Subcription.UsageTodayResponse;
import org.springframework.stereotype.Service;

@Service
public class UsageServiceImpl implements UsageService {
    @Override
    public UsageTodayResponse getTodayUsageOfUser(Long userId) {
        return null;
    }

    @Override
    public PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId) {
        return null;
    }
}
