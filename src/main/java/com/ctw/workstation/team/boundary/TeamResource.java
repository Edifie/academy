package com.ctw.workstation.team.boundary;

import java.util.List;
import java.util.Optional;

import com.ctw.workstation.shared.exception.CustomNotFoundException;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.mapper.TeamMapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("/teams")
public class TeamResource {

    @Inject
    TeamService teamService;

    @Inject
    TeamMapper teamMapper;

    @GET
    public List<TeamDTO> getAllTeams() {

        List<Team> teams = teamService.findAll();

        return teamMapper.EntityToDto(teams);
    }

    @POST
    public Response add(TeamDTO teamDTO) {
        Team team = teamMapper.dtoToEntity(teamDTO);
        teamService.add(team);

        return Response.status((Response.Status.CREATED)).entity(team).build();

    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") Long id) {
        Optional<Team> team = teamService.findById(id);

        if (team.isPresent()) {
            TeamDTO teamDTO = teamMapper.EntityToDto(team.get());
            return Response.status(Response.Status.OK).entity(teamDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }

    }

    @PUT
    @Path("/{id}")
    public Response updateTeamById(@PathParam("id") Long id, TeamDTO teamDTO) {
        Team foundTeam = teamService.findById(id).orElse(null);
        if (foundTeam == null) {
            throw new CustomNotFoundException(Team.class.getName());
        }

        Team team = teamMapper.dtoToEntity(teamDTO);
        team.setId(id);
        teamService.update(team);

        return Response.status(Response.Status.OK).entity(team).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamById(@PathParam("id") Long id) {
        Team foundTeam = teamService.findById(id).orElse(null);
        if (foundTeam == null) {
            throw new CustomNotFoundException(Team.class.getName());
        }

        teamService.delete(foundTeam);

        return Response.status(Response.Status.OK).build();
    }
}
