package com.ctw.workstation.rack.boundary;

import java.time.LocalDateTime;

import com.ctw.workstation.rack.entity.Status;

public class RackDTO {

    private Long id;
    private String serialNumber;
    private Status status;
    private Long teamId;
    private LocalDateTime modifiedAt;
    private LocalDateTime createdAt;
    private String defaultLocation;

    public RackDTO() {
    }

    public RackDTO(Long id, String serialNumber, Status status, Long teamId, LocalDateTime modifiedAt,
            LocalDateTime createdAt, String defaultLocation) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.status = status;
        this.teamId = teamId;
        this.modifiedAt = modifiedAt;
        this.createdAt = createdAt;
        this.defaultLocation = defaultLocation;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getDefaultLocation() {
        return defaultLocation;
    }

    public void setDefaultLocation(String defaultLocation) {
        this.defaultLocation = defaultLocation;
    }

}
