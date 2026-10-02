package com.projects.buildora.Service;

import com.projects.buildora.dto.Subcription.PlanLimitResponse;
import com.projects.buildora.dto.Subcription.UsageTodayResponse;

public interface UsageService {
    UsageTodayResponse getTodayUsageOfUser(Long userId);

    PlanLimitResponse getCurrentSubscriptionLimitsOfUser(Long userId);
}
