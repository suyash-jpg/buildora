package com.projects.buildora.security;

import org.springframework.security.core.GrantedAuthority;

import java.util.List;

public record JwtUserPrinciple(
    Long userId,
    String UserName,
    List<GrantedAuthority>authorities
){
}
