package com.ctw.workstation.team.control;

import java.util.List;
import java.util.Optional;

import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.TeamRepository;
import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMember;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TeamService {

    @Inject
    TeamRepository teamRepository;

    @Inject
    RackService rackService;

    @Inject
    TeamMemberService teamMemberService;

    public List<Team> findAll() {
        return teamRepository.listAll();
    }

    public void add(Team team) {
        teamRepository.persist(team);
    }

    public Optional<Team> findById(Long id) {
        return teamRepository.findByIdOptional(id);
//        return Optional.ofNullable(teamRepository.indById(id));
    }

    public List<Team> findByStatus(String name) {
        return teamRepository.findByName(name);
    }

    public Team update(Team team) {
        Optional<Team> existedteamOpt = Optional.ofNullable(teamRepository.findById(team.getId()));

        Team teamOpt = existedteamOpt.orElse(null);

        if (existedteamOpt.isPresent()) {

            teamOpt.setDefaultLocation(team.getDefaultLocation());
            teamOpt.setName(team.getName());
            teamOpt.setProduct(team.getProduct());

            teamRepository.persist(teamOpt);

            return teamOpt;
        }
        return null;
    }

    public void delete(Team team) {
        List<Rack> racksBelongsToTeam = rackService.findByTeamId(team.getId());
        for (Rack rack : racksBelongsToTeam) {
            rack.setTeamId(null);
            rack.setTeam(null);
        }

        List<TeamMember> teamMemberBelongsToTeam = teamMemberService.findByTeamId(team.getId());

        for (TeamMember teamMember : teamMemberBelongsToTeam) {
            teamMember.setTeamId(null);
            teamMember.setTeam(null);
        }

        teamRepository.delete(team);
    }

}
