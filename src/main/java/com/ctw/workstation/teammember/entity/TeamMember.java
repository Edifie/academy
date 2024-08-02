package com.ctw.workstation.teammember.entity;

import java.time.LocalDateTime;

import com.ctw.workstation.shared.event.EventListener;
import com.ctw.workstation.team.entity.Team;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name = "T_TEAM_MEMBER")
@EntityListeners(EventListener.class)
public class TeamMember {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teamMemberIdGenerator")
    @SequenceGenerator(name = "teamMemberIdGenerator", sequenceName = "SEQ_TEAM_MEMBER_ID")
    private Long id;

    @Column(name = "TEAM_ID")
    private Long teamId;

    @Column(name = "CTW_ID", nullable = false)
    private String ctwId;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CREATED_AT")
    private LocalDateTime createdAt;

    @Column(name = "MODIFIED_AT")
    private LocalDateTime modifiedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TEAM_ID", updatable = false, insertable = false, nullable = false)
    public Team team;

    public TeamMember() {
    }

    public TeamMember(Long id, Long teamId, String ctwId, String name, LocalDateTime createdAt,
            LocalDateTime modifiedAt, Team team) {
        this.id = id;
        this.teamId = teamId;
        this.ctwId = ctwId;
        this.name = name;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
        this.team = team;
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

}
