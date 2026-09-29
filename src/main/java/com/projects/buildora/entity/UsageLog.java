package com.projects.buildora.entity;


import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UsageLog {
     Long id;

     User user;

     Project project;

     String  action;

     Instant createdAt;

     Integer tokenUsed;

     Integer durationMs;

     String metaData;



}
