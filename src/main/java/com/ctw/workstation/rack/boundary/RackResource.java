package com.ctw.workstation.rack.boundary;

import java.util.List;

import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.rack.repository.mapper.RackMapper;
import com.ctw.workstation.shared.exception.CustomNotFoundException;

import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

@Path("racks")
public class RackResource {

    @Inject
    RackService rackService;

    @Inject
    RackMapper rackMapper;

    @GET
    public List<RackDTO> getAllRacks(@QueryParam("status") Status status) {

        if (status != null) {
            List<Rack> filteredRacks = rackService.findByStatus(status);

            return rackMapper.EntityToDto(filteredRacks);
        } else {
            List<Rack> racks = rackService.findAll();

            return rackMapper.EntityToDto(racks);
        }

    }

    @POST
    public Response add(RackDTO rackDTO) {

        rackDTO.setDefaultLocation("Lisbon");
        Rack rack = rackMapper.dtoToEntity(rackDTO);

        rackService.add(rack);

        return Response
                .status(Response.Status.CREATED)
                .entity(rack)
                .build();

    }

    @GET
    @Path("/{id}")
    public Response getRackById(@PathParam("id") Long id) {
        Rack rack = rackService.findById(id).orElse(null);

        RackDTO rackDTO = rackMapper.EntityToDto(rack);

        return Response
                .status(Response.Status.OK)
                .entity(rackDTO)
                .build();
    }

    @PUT
    @Path("/{id}")
    public Response updateRackById(@PathParam("id") Long id, RackDTO rackDTO) {
        Rack foundRack = rackService.findById(id).orElse(null);
        if (foundRack == null) {
            throw new CustomNotFoundException(Rack.class.getName());
        }

        Rack rack = rackMapper.dtoToEntity(rackDTO);
        rack.setId(id);
        rackService.update(rack);

        return Response
                .status(Response.Status.OK)
                .entity(rack)
                .build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteRackById(@PathParam("id") Long id) {
        Rack foundRack = rackService.findById(id).orElse(null);
        if (foundRack == null) {
            throw new CustomNotFoundException(Rack.class.getName());
        }

        rackService.delete(foundRack);

        return Response
                .status(Response.Status.OK)
                .build();
    }

}
