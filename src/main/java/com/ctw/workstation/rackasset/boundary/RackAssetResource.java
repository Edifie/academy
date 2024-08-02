package com.ctw.workstation.rackasset.boundary;

import java.util.List;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.rackasset.repository.mapper.RackAssetMapper;
import com.ctw.workstation.shared.exception.CustomNotFoundException;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Response;

@Path("rackassets")
public class RackAssetResource {
    @Inject
    RackAssetService rackAssetService;

    @Inject
    RackAssetMapper rackAssetMapper;

    @GET
    public List<RackAssetDTO> getAllTeamMembers() {

        List<RackAsset> RackAssets = rackAssetService.findAll();

        return rackAssetMapper.entityToDto(RackAssets);

    }

    @POST
    public Response add(RackAssetDTO RackAssetDTO) {
        RackAsset RackAsset = rackAssetMapper.dtoToEntity(RackAssetDTO);
        rackAssetService.add(RackAsset);

        return Response
                .status((Response.Status.CREATED))
                .entity(RackAsset)
                .build();

    }

    @GET
    @Path("/{id}")
    public Response getTeamMemberById(@PathParam("id") Long id) {
        RackAsset RackAsset = rackAssetService.findById(id).orElse(null);

        RackAssetDTO RackAssetDTO = rackAssetMapper.entityToDto(RackAsset);

        return Response
                .status(Response.Status.OK)
                .entity(RackAssetDTO)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateTeamMemberById(@PathParam("id") Long id, RackAssetDTO RackAssetDTO) {
        RackAsset foundRackAsset = rackAssetService.findById(id).orElse(null);
        if (foundRackAsset == null) {
            throw new CustomNotFoundException(RackAsset.class.getName());
        }

        RackAsset RackAsset = rackAssetMapper.dtoToEntity(RackAssetDTO);
        RackAsset.setId(id);
        rackAssetService.update(RackAsset);

        return Response
                .status(Response.Status.OK)
                .entity(RackAsset)
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteTeamMemberById(@PathParam("id") Long id) {
        RackAsset foundRackAsset = rackAssetService.findById(id).orElse(null);
        if (foundRackAsset == null) {
            throw new CustomNotFoundException(RackAsset.class.getName());
        }

        rackAssetService.delete(foundRackAsset);

        return Response
                .status(Response.Status.OK)
                .build();
    }

}
