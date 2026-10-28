package com.projects.buildora.Service;


import com.projects.buildora.dto.Subcription.SubscriptionResponse;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription(Long userId);
}
