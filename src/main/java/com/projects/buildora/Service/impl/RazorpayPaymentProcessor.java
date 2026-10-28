
package com.projects.buildora.Service.impl;

import com.projects.buildora.Service.PaymentProcessor;
import com.projects.buildora.dto.Subcription.CheckoutRequest;
import com.projects.buildora.dto.Subcription.CheckoutResponse;
import com.projects.buildora.dto.Subcription.PortalResponse;
import com.projects.buildora.entity.Plan;
import com.projects.buildora.error.ResourceNotFound;
import com.projects.buildora.repository.PlanRepository;
import com.projects.buildora.security.AuthUtil;

import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Subscription;

import lombok.RequiredArgsConstructor;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RazorpayPaymentProcessor implements PaymentProcessor {

    private final AuthUtil authUtil;
    private final PlanRepository planRepository;
    private final RazorpayClient razorpayClient;

    @Override
    public CheckoutResponse createCheckoutSessionUrl(
            CheckoutRequest request
    ) {

        Long userId = authUtil.getCurrentUserId();

        Plan plan = planRepository.findById(request.planId())
                .orElseThrow(() ->
                        new ResourceNotFound(
                                "Plan not found",
                                request.planId().toString()
                        )
                );

        String razorpayPlanId = plan.getRazorpayPriceId();

        if (razorpayPlanId == null || razorpayPlanId.isBlank()) {
            throw new IllegalStateException(
                    "Razorpay plan ID is missing for plan: "
                            + request.planId()
            );
        }

        JSONObject subscriptionRequest = new JSONObject();

        subscriptionRequest.put("plan_id", razorpayPlanId);
        subscriptionRequest.put("total_count", 1200);
        subscriptionRequest.put("quantity", 1);
        subscriptionRequest.put("customer_notify", true);

        JSONObject notes = new JSONObject();
        notes.put("user_id", userId.toString());
        notes.put("plan_id", request.planId().toString());

        subscriptionRequest.put("notes", notes);

        try {
            Subscription subscription =
                    razorpayClient.subscriptions.create(subscriptionRequest);

            String checkoutUrl = subscription.get("short_url");

            if (checkoutUrl == null || checkoutUrl.isBlank()) {
                throw new IllegalStateException(
                        "Razorpay did not return a checkout URL"
                );
            }

            return new CheckoutResponse(checkoutUrl);

        } catch (RazorpayException e) {
            throw new RuntimeException(
                    "Failed to create Razorpay subscription",
                    e
            );
        }
    }

    @Override
    public PortalResponse openCustomerPortal(Long userId) {
        return null;
    }
}
