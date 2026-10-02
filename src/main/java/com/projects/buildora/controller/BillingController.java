package com.projects.buildora.controller;

import com.projects.buildora.Service.PlanService;
import com.projects.buildora.Service.SubscriptionService;
import com.projects.buildora.dto.Subcription.*;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class BillingController {

    PlanService planService;
    SubscriptionService subscriptionService;

    @GetMapping("/api/plan")
    public ResponseEntity<List<PlanResponse>> getAllPlans() {

        return ResponseEntity.ok(planService.getAllActivePlans());

    }

    @GetMapping("/api/me/subsription")
    public ResponseEntity<SubscriptionResponse> getMySubscription(){
        Long userId=1L;
        return ResponseEntity.ok(subscriptionService.getCurrentSubscription(userId));
    }


    @PostMapping("/api/stripe/checkout")
    public ResponseEntity<CheckoutResponse>createCheckoutResponse(
            @RequestBody CheckoutRequest request
    ){
        Long userId=1L;
        return  ResponseEntity.ok(subscriptionService.createCheckoutSessionUrl(userId,request));

    }


    @PostMapping("/api/stripe/portal")
    public ResponseEntity<PortalResponse>openCustomerPortal(){
        Long userId=1L;
        return ResponseEntity.ok(subscriptionService.openCustomerPortal(userId));
    }


}
