package com.ctw.workstation.team.repository;

import java.util.List;

import com.ctw.workstation.team.entity.Team;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TeamRepository implements PanacheRepository<Team> {

    public List<Team> findByName(String name) {
        return list("name", name);
    }

}
