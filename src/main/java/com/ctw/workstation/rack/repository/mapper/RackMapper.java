package com.ctw.workstation.rack.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ctw.workstation.rack.boundary.RackDTO;
import com.ctw.workstation.rack.entity.Rack;

@Mapper(componentModel = "cdi")
public interface RackMapper {

    Rack dtoToEntity(RackDTO rackDTO);

    List<Rack> dtoToEntity(List<RackDTO> rackDTO);

    RackDTO EntityToDto(Rack rack);

    List<RackDTO> EntityToDto(List<Rack> rack);

}
