package com.ctw.workstation.rack.repository;

import java.util.List;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.Status;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RackRepository implements PanacheRepository<Rack> {

    public List<Rack> findByStatus(Status status) {
        return list("status", status);
    }

    public List<Rack> findByTeamId(Long id) {
        return list("teamId", id);
    }

}
