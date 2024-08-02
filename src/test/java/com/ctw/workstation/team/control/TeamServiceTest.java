package com.ctw.workstation.team.control;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mockito;

import com.ctw.workstation.CommonProfile;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.TeamRepository;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.quarkus.test.junit.mockito.InjectSpy;
import jakarta.inject.Inject;

@QuarkusTest
@TestProfile(CommonProfile.class)
class TeamServiceTest {

    @Inject
    TeamService teamService;

    @InjectSpy
    TeamRepository teamRepository;

    @Test
    void findAll() {
    }

    @Test
    void add() {
    }

    @Test
    void findById() {
    }

    @Test
    void findByStatus() {
    }

    @Test
    void update_when_existedTeamOpt_is_null() {
        // given
        Team team = new Team(2L, "Test", "TestProduct", "Lisbon");
        Team existedTeam = new Team(2L, "Test", "ExampleProduct", "Lisbon");
        // when
        Mockito.when(teamRepository.findById(team.getId())).thenReturn(existedTeam);
        Mockito.doNothing().when(teamRepository).persist(any(Team.class));
        Mockito.doReturn(team).when(teamRepository).findById(team.getId());

        Team updatedTeam = teamService.update(existedTeam);
        // assert
        assertNotNull(updatedTeam);
        assertEquals(updatedTeam.getName(), team.getName());
        assertEquals(updatedTeam.getProduct(), team.getProduct());
        assertEquals(updatedTeam.getDefaultLocation(), team.getDefaultLocation());
    }

//    @Test
//    void testUpdateTeamExists() {
//        when(teamRepository.findById(team.getId())).thenReturn(existingTeam);
//
//        Team updatedTeam = teamService.update(team);
//
//        assertNotNull(updatedTeam);
//        assertEquals(team.getName(), updatedTeam.getName());
//        assertEquals(team.getDefaultLocation(), updatedTeam.getDefaultLocation());
//        assertEquals(team.getProduct(), updatedTeam.getProduct());
//
//        verify(teamRepository, times(1)).persist(existingTeam);
//    }
    void update_when_existedTeamOpt_is_not_null() {
    }

    @Test
    void delete() {
    }

}
