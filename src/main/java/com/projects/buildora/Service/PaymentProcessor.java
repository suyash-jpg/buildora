package com.projects.buildora.Service;

import com.projects.buildora.dto.Subcription.CheckoutRequest;
import com.projects.buildora.dto.Subcription.CheckoutResponse;
import com.projects.buildora.dto.Subcription.PortalResponse;
import com.razorpay.RazorpayException;

public interface PaymentProcessor {

    public CheckoutResponse createCheckoutSessionUrl(CheckoutRequest request);
    public PortalResponse openCustomerPortal(Long userId);
}
