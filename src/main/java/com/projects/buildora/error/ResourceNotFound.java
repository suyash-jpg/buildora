package com.projects.buildora.error;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;

@FieldDefaults(makeFinal = true,level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@Getter
public class ResourceNotFound extends RuntimeException {

    String resourceName;
    String resourceId;
}
