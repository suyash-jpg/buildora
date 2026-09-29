package com.projects.buildora.entity;


import com.projects.buildora.enums.SubscriptionStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Subscription{

    Long id;


    User user;

    Plan plan;

    SubscriptionStatus status;

    String stripeCustomerId;

    String stripeSubscriptionId;

    Instant currentPeriodStart;

    Instant currentPeriodEnd;

    Boolean cancelAtPeriodEnd = false;

    Instant createdAt;

    Instant updatedAt;

}
