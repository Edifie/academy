package com.ctw.workstation.teammember.boundary;

import java.time.LocalDateTime;

public class TeamMemberDTO {
    private Long id;
    private Long teamId;
    private String ctwId;
    private String name;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public TeamMemberDTO() {
    }

    public TeamMemberDTO(Long id, Long teamId, String ctwId, String name, LocalDateTime createdAt,
            LocalDateTime modifiedAt) {
        this.id = id;
        this.teamId = teamId;
        this.ctwId = ctwId;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getTeamId() {
        return teamId;
    }

    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }

    public String getCtwId() {
        return ctwId;
    }

    public void setCtwId(String ctwId) {
        this.ctwId = ctwId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public void setModifiedAt(LocalDateTime modifiedAt) {
        this.modifiedAt = modifiedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}