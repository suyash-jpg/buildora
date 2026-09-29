package com.projects.buildora.entity;


import com.projects.buildora.enums.PreviewStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
public class Preview {
    Long id;

    Project project;

    String spaceName;

    String podName;

    String previewUrl;

    PreviewStatus status;

    Instant createdAt;

    Instant startedAt;

    Instant terminatedAt;




}
