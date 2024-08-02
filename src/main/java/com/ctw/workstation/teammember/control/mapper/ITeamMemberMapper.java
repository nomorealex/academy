package com.ctw.workstation.teammember.control.mapper;

import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import jakarta.enterprise.context.RequestScoped;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "cdi")
public interface ITeamMemberMapper {

    @Mapping(target = "teamId", source = "teamId")
    @Mapping(target = "ctwId", source = "ctwId")
    @Mapping(target = "name", source = "name")
    TeamMemberDTO toDTO(TeamMember teamMember);

    @Mapping(target = "teamId", source = "teamId")
    @Mapping(target = "ctwId", source = "ctwId")
    @Mapping(target = "name", source = "name")
    TeamMember toEntity(TeamMemberDTO teamMemberDTO);
}
