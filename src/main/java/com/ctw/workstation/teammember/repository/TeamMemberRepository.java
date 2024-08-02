package com.ctw.workstation.teammember.repository;

import java.util.List;

import com.ctw.workstation.teammember.entity.TeamMember;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamMemberRepository implements PanacheRepository<TeamMember> {

    public List<TeamMember> findByName(String name) {
        return list("name", name);
    }

    public List<TeamMember> findByTeamId(Long teamId) {
        return list("teamId", teamId);
    }

}
