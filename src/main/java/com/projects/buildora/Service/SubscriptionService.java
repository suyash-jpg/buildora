package com.projects.buildora.Service;

import com.projects.buildora.dto.Subcription.CheckoutRequest;
import com.projects.buildora.dto.Subcription.CheckoutResponse;
import com.projects.buildora.dto.Subcription.PortalResponse;
import com.projects.buildora.dto.Subcription.SubscriptionResponse;

public interface SubscriptionService {

    SubscriptionResponse getCurrentSubscription(Long userId);
    CheckoutResponse createCheckoutSessionUrl(Long userId, CheckoutRequest request);


    PortalResponse openCustomerPortal(Long userId);
}
