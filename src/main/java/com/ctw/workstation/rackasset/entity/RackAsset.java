package com.ctw.workstation.rackasset.entity;

import com.ctw.workstation.rack.entity.Rack;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_RACK_ASSET")
public class RackAsset {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackAssetIdGenerator")
    @SequenceGenerator(name = "rackAssetIdGenerator", sequenceName = "SEQ_RACK_ASSET_ID")
    private Long id;

    @Column(name = "ASSET_TAG", length = 10, nullable = false)
    private String assetTag;

    @Column(name = "RACK_ID", nullable = false)
    private Long rackId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "RACK_ID", updatable = false, insertable = false, nullable = false)
    public Rack rack;

    public RackAsset() {
    }

    public RackAsset(Long id, String assetTag, Long rackId) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((assetTag == null) ? 0 : assetTag.hashCode());
        result = prime * result + ((rackId == null) ? 0 : rackId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        RackAsset other = (RackAsset) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (assetTag == null) {
            if (other.assetTag != null)
                return false;
        } else if (!assetTag.equals(other.assetTag))
            return false;
        if (rackId == null) {
            if (other.rackId != null)
                return false;
        } else if (!rackId.equals(other.rackId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "RackAsset [id=" + id + ", assetTag=" + assetTag + ", rackId=" + rackId + "]";
    }

}
