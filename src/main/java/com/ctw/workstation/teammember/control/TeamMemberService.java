package com.ctw.workstation.teammember.control;

import java.util.List;
import java.util.Optional;

import com.ctw.workstation.teammember.entity.TeamMember;
import com.ctw.workstation.teammember.repository.TeamMemberRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class TeamMemberService {
    @Inject
    TeamMemberRepository teamMemberRepository;

    public List<TeamMember> findAll() {
        return teamMemberRepository.listAll();
    }

    @Transactional
    public void add(TeamMember TeamMember) {
        teamMemberRepository.persist(TeamMember);
    }

    public Optional<TeamMember> findById(Long id) {
        return Optional.of(teamMemberRepository.findById(id));
    }

    public List<TeamMember> findByName(String name) {
        return teamMemberRepository.findByName(name);
    }

    public List<TeamMember> findByTeamId(Long id) {
        return teamMemberRepository.findByTeamId(id);
    }

    @Transactional
    public TeamMember update(TeamMember teamMember) {
        TeamMember existedTeamMemberOpt = Optional.of(teamMemberRepository.findById(teamMember.getId())).orElse(null);

        if (existedTeamMemberOpt != null) {

            existedTeamMemberOpt.setCtwId(teamMember.getCtwId());
            existedTeamMemberOpt.setTeamId(teamMember.getTeamId());
            existedTeamMemberOpt.setName(teamMember.getName());

            teamMemberRepository.persist(existedTeamMemberOpt);

            return existedTeamMemberOpt;
        }
        return null;
    }

    public void delete(TeamMember TeamMember) {
        teamMemberRepository.delete(TeamMember);
    }

}
