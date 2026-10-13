package com.projects.buildora.mapper;

import com.projects.buildora.dto.member.MemberResponse;
import com.projects.buildora.entity.ProjectMember;
import com.projects.buildora.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;



@Mapper(componentModel = "spring")
public interface ProjectMemberMapper {


    @Mapping(target = "userId",source = "id")
    @Mapping(target = "projectRole" , constant= "OWNER")
    MemberResponse toProjectMemberResponseFromOwner(User owner);


    @Mapping(target ="userId" , source = "user.id")
    @Mapping(target = "email",source="user.email")
    @Mapping(target = "name",source = "user.name")
    MemberResponse toProjectMemberResponseFromMember(ProjectMember projectMember);
}
