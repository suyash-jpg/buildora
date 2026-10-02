package com.projects.buildora.dto.Subcription;


import java.time.Instant;

public record SubscriptionResponse (
    PlanResponse plan,
    String status,
    Instant periodEnd,
    Long tokenUsedThisCycle

) {

}
