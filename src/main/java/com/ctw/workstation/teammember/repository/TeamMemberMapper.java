package com.ctw.workstation.teammember.repository;

import java.util.List;

import org.mapstruct.Mapper;

import com.ctw.workstation.teammember.boundary.TeamMemberDTO;
import com.ctw.workstation.teammember.entity.TeamMember;

@Mapper(componentModel = "cdi")
public interface TeamMemberMapper {
    TeamMember dtoToEntity(TeamMemberDTO TeamMemberDTO);

    List<TeamMember> dtoToEntity(List<TeamMemberDTO> TeamMemberDTO);

    TeamMemberDTO EntityToDto(TeamMember TeamMember);

    List<TeamMemberDTO> EntityToDto(List<TeamMember> Team);
}
