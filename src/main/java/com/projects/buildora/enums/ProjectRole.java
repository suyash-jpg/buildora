package com.projects.buildora.enums;


import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Set;

import static com.projects.buildora.enums.ProjectPermission.*;

@RequiredArgsConstructor
@Getter
public enum ProjectRole {
    EDITOR(Set.of(EDIT,DELETE,VIEW,VIEW_MEMBERS)),
    VIEWER(Set.of(VIEW,VIEW_MEMBERS)),
    OWNER(Set.of(VIEW, EDIT,DELETE,MANAGE_MEMBERS,VIEW_MEMBERS)),;

    private final Set<ProjectPermission> permission;
}
