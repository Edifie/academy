package com.ctw.workstation.rackasset.boundary;

public class RackAssetDTO {

    private Long id;
    private String assetTag;
    private Long rackId;

    public RackAssetDTO() {
    }

    public RackAssetDTO(Long id, String assetTag, Long rackId) {
        this.id = id;
        this.assetTag = assetTag;
        this.rackId = rackId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAssetTag() {
        return assetTag;
    }

    public void setAssetTag(String assetTag) {
        this.assetTag = assetTag;
    }

    public Long getRackId() {
        return rackId;
    }

    public void setRackId(Long rackId) {
        this.rackId = rackId;
    }

}
