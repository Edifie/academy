package com.ctw.workstation.rack.entity;

import java.time.LocalDateTime;

import com.ctw.workstation.shared.event.EventListener;
import com.ctw.workstation.team.entity.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_RACK")
@EntityListeners(EventListener.class)
public class Rack {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rackIdGenerator")
    @SequenceGenerator(name = "rackIdGenerator", sequenceName = "SEQ_RACK_ID")
    private Long id;

    @Column(name = "SERIAL_NUMBER", length = 20, nullable = false)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "TEAM_ID", nullable = true)
    private Long teamId;

    @Column(name = "MODIFIED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime modifiedAt;

    @Column(name = "CREATED_AT", columnDefinition = "TIMESTAMP")
    private LocalDateTime createdAt;

    @Column(name = "DEFAULT_LOCATION", nullable = false)
    private String defaultLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    public Rack() {
    }

    public Rack(Long id, String serialNumber, Status status, Long teamId, LocalDateTime modifiedAt,
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
