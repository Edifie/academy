package com.ctw.workstation.teammember.boundary;

import java.util.List;

import com.ctw.workstation.shared.exception.CustomNotFoundException;
import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.repository.TeamMemberMapper;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("teamMembers")
public class TeamMemberResource {
    @Inject
    TeamMemberService teamMemberService;

    @Inject
    TeamMemberMapper teamMemberMapper;

    @GET
    public List<TeamMemberDTO> getAllTeamMembers() {

        List<TeamMember> TeamMembers = teamMemberService.findAll();

        return teamMemberMapper.EntityToDto(TeamMembers);

    }

    @POST
    public Response add(TeamMemberDTO TeamMemberDTO) {

        TeamMember TeamMember = teamMemberMapper.dtoToEntity(TeamMemberDTO);
        teamMemberService.add(TeamMember);

        return Response
                .status(Response.Status.CREATED)
                .entity(TeamMember)
                .build();

    }

    @GET
    @Path("/{id}")
    public Response getTeamMemberById(@PathParam("id") Long id) {
        TeamMember TeamMember = teamMemberService.findById(id).orElse(null);

        TeamMemberDTO TeamMemberDTO = teamMemberMapper.EntityToDto(TeamMember);

        return Response
                .status(Response.Status.OK)
                .entity(TeamMemberDTO)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMemberById(@PathParam("id") Long id, TeamMemberDTO TeamMemberDTO) {
        TeamMember foundTeamMember = teamMemberService.findById(id).orElse(null);
        if (foundTeamMember == null) {
            throw new CustomNotFoundException(TeamMember.class.getName());
        }

        TeamMember TeamMember = teamMemberMapper.dtoToEntity(TeamMemberDTO);
        TeamMember.setId(id);
        teamMemberService.update(TeamMember);

        return Response
                .status(Response.Status.OK)
                .entity(TeamMember)
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMemberById(@PathParam("id") Long id) {
        TeamMember foundTeamMember = teamMemberService.findById(id).orElse(null);
        if (foundTeamMember == null) {
            throw new CustomNotFoundException(TeamMember.class.getName());
        }

        teamMemberService.delete(foundTeamMember);

        return Response
                .status(Response.Status.OK)
                .build();
    }

}
