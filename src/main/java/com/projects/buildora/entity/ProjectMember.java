package com.projects.buildora.entity;


import com.projects.buildora.enums.ProjectRole;
import jakarta.persistence.EmbeddedId;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class ProjectMember {

    @EmbeddedId
    ProjectMemberId Id;

    Project project;

    User user;

    ProjectRole projectRole;

    Instant invitedAt;

    Instant acceptedAt;


}
