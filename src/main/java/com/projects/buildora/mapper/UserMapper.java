package com.projects.buildora.mapper;


import com.projects.buildora.dto.auth.SignupRequest;
import com.projects.buildora.dto.auth.UserProfileResponse;
import com.projects.buildora.entity.User;
import jakarta.validation.constraints.Min;
import org.mapstruct.Mapper;
import org.springframework.security.core.userdetails.UserDetails;

@Mapper(componentModel = "spring")
public interface UserMapper {

    User toEntity(SignupRequest signupRequest);
    UserProfileResponse toUserProfileResponse(User user);

}
