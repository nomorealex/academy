package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import io.quarkus.logging.Log;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusMock;
import io.quarkus.test.junit.QuarkusTest;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

@QuarkusTest
//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class TeamResourceTest {
    private static final Logger log = LoggerFactory.getLogger(TeamResourceTest.class);

    //@InjectMock
    //TeamService teamService;

    @Inject
    TeamResource teamResource;

    //@BeforeAll
    //void setup(){}

    @Test
    @DisplayName("validate the search of all teams")
    void shouldGetAllTeams() {

        //QuarkusMock.installMockForType();
        //QuarkusMock.installMockForInstance();

        //Given
        List<Team> listTeamsMocked = getTeams();

        TeamService teamServiceMocked = Mockito.mock(TeamService.class);

        Mockito.when(teamServiceMocked.findAllTeams())
                .thenReturn(listTeamsMocked);
        QuarkusMock.installMockForType(teamServiceMocked, TeamService.class);


        // Act
        Response response = teamResource.getAllTeams();

        Log.infov("ContentLenght {0} and entity is {1}",
                response.getEntity().getClass(),
                response.getEntity()
        );

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertInstanceOf(List.class, response.getEntity());

        List<Team> entityList = (List<Team>) response.getEntity();

        Log.infov("List -> {0}", entityList);

    }

    private static List<Team> getTeams() {
        Team teamA = new Team();
        teamA.setId(UUID.randomUUID());
        teamA.setName("Team A");
        Team teamB = new Team();
        teamB.setId(UUID.randomUUID());
        teamB.setName("Team B");
        return Arrays.asList(teamA,teamB);
    }

    @Test
    @DisplayName("validate the search of a team by it's id")
    void shouldGetTeamById() {
        UUID targetUuid = UUID.randomUUID();
        Team targetTeam = new Team();
        targetTeam.setId(targetUuid);
        targetTeam.setName("targetTeam");

        TeamService teamServiceMocked = Mockito.mock(TeamService.class);
        Mockito.when(teamServiceMocked.findTeamById(targetUuid))
                .thenReturn(new Team());

        // Act
        Response response = teamResource.getTeamById(targetUuid);

        Log.infov("Response {0}", response.getEntity());
        //QuarkusMock.installMockForType();
        //QuarkusMock.installMockForInstance();

        // Assert
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());

    }

    /*
    @Test
    @DisplayName("validate the creation of a team")
    void shouldCreateTeam() {
    }

    @Test
    @DisplayName("validate the removal of a team")
    void shouldRemoveTeam() {
    }

     */
}