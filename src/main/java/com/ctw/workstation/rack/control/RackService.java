package com.ctw.workstation.rack.control;

import java.util.List;
import java.util.Optional;

import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rack.entity.Status;
import com.ctw.workstation.rack.repository.RackRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class RackService {

    @Inject
    RackRepository rackRepository;

    public List<Rack> findAll() {
        return rackRepository.listAll();
    }

    public void add(Rack rack) {
        rackRepository.persist(rack);
    }

    public Optional<Rack> findById(Long id) {
        return Optional.of(rackRepository.findById(id));
    }

    public List<Rack> findByStatus(Status status) {
        return rackRepository.findByStatus(status);
    }

    public List<Rack> findByTeamId(Long id) {
        return rackRepository.findByTeamId(id);
    }

    public Rack update(Rack rack) {
        Rack existedRackOpt = Optional.of(rackRepository.findById(rack.getId())).orElse(null);

        if (existedRackOpt != null) {

            existedRackOpt.setCreatedAt(rack.getCreatedAt());
            existedRackOpt.setDefaultLocation(rack.getDefaultLocation());
            existedRackOpt.setSerialNumber(rack.getSerialNumber());
            existedRackOpt.setStatus(rack.getStatus());
            existedRackOpt.setTeamId(rack.getTeamId());

            rackRepository.persist(existedRackOpt);

            return existedRackOpt;
        }
        return null;
    }

    public void delete(Rack rack) {
        rackRepository.delete(rack);
    }

}
