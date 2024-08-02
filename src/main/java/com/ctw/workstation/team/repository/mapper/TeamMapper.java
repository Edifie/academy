package com.ctw.workstation.team.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ctw.workstation.team.boundary.TeamDTO;
import com.ctw.workstation.team.entity.Team;

@Mapper(componentModel = "cdi")
public interface TeamMapper {

    Team dtoToEntity(TeamDTO TeamDTO);

    List<Team> dtoToEntity(List<TeamDTO> TeamDTO);

    TeamDTO EntityToDto(Team Team);

    List<TeamDTO> EntityToDto(List<Team> Team);
}
