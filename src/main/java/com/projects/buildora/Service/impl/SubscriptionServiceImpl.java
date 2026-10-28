package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.SubscriptionService;
import com.projects.buildora.dto.Subcription.CheckoutRequest;
import com.projects.buildora.dto.Subcription.CheckoutResponse;
import com.projects.buildora.dto.Subcription.PortalResponse;
import com.projects.buildora.dto.Subcription.SubscriptionResponse;
import org.springframework.stereotype.Service;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {
    @Override
    public SubscriptionResponse getCurrentSubscription(Long userId) {
        return null;
    }
}
