package com.ctw.workstation.rackasset.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ctw.workstation.rackasset.boundary.RackAssetDTO;
import com.ctw.workstation.rackasset.entity.RackAsset;

@Mapper(componentModel = "cdi")
public interface RackAssetMapper {

    RackAsset dtoToEntity(RackAssetDTO rackAssetDTO);

    List<RackAsset> dtoToEntity(List<RackAssetDTO> rackAssetDTO);

    RackAssetDTO entityToDto(RackAsset rackAsset);

    List<RackAssetDTO> entityToDto(List<RackAsset> rackAsset);
}
