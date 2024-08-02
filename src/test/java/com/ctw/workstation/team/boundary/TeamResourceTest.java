package com.ctw.workstation.team.boundary;

import com.ctw.workstation.CommonProfile;
import com.ctw.workstation.DatabaseTestResource;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.team.repository.TeamRepository;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.client.WireMock.*;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import com.github.tomakehurst.wiremock.client.WireMock.*;

import java.util.List;

//import static com.github.tomakehurst.wiremock.client.WireMock.stubFor;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.equalTo;


//@(DatabaseTestResource.class)
//@QuarkusTestResource(WiremockResource.class)
@QuarkusTest
@TestHTTPEndpoint(TeamResource.class)
@TestProfile(CommonProfile.class)
class TestResourceTest {
    @Inject
    TeamRepository teamRepository;

    @BeforeEach
    @Transactional
    void persistTeam() {
        deleteTeam();
        Team team = new Team(null, "test", "test", "lisbon");
        teamRepository.persist(team);
    }

    //    @AfterEach
//    @Transactional
    void deleteTeam() {
        teamRepository.deleteAll();
    }

    static TeamDTO teamDTO() {
        return new TeamDTO(null, "test", "test", "lisbon");
    }

//    @Test
//    void get_team_by_id_returns_200() {
//        //                .contentType(ContentType.JSON).pathParam("id", 1).
//        List<Team> teams = teamRepository.findAll().stream().toList();
//
//        WireMock.stubFor(WireMock.get(WireMock.urlEqualTo("/external/hello")).willReturn(WireMock.aResponse().withHeader("Content-Type", "application/json").withStatus(200).withBody("{ \"message\":\"Hello Rennan\"}")));
//
//        when().get("/teams/{id}", 1).then().statusCode(200).body("name", equalTo("test"));
//    }

    @Test
    void get_team_by_id_returns_404() {
        when().get("/teams/{id}", 7).then().statusCode(404);
    }

//    @Test
//    void add_team() {
//        TeamDTO teamDTO = new TeamDTO(null, "test", "test", "lisbon");
//
//        given().contentType(ContentType.JSON).body(teamDTO).when().post("/teams").then().statusCode(201);
//    }


}