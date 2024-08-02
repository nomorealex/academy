package com.ctw.workstation.team.boundary;

import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.testconfig.CommonProfile;
import com.ctw.workstation.testconfig.TestConfig;
import com.ctw.workstation.testconfig.WireMockResourceConfig;
import com.github.tomakehurst.wiremock.WireMockServer;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.common.http.TestHTTPEndpoint;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import io.restassured.http.ContentType;
import jakarta.json.bind.Jsonb;
import jakarta.json.bind.JsonbBuilder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

import static io.restassured.RestAssured.*;

@QuarkusTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestHTTPEndpoint(TeamResource.class)
@TestProfile(CommonProfile.class)
//@QuarkusTestResource(TestConfig.class)
//@QuarkusTestResource(WireMockResourceConfig.class)
public class TeamResourceIT {

    //TODO mockar os comportamentos
    WireMockServer wireMockServer = new WireMockServer(8999);

    private static final Jsonb JSONB = JsonbBuilder.create();

    private Team team;

    @BeforeAll
    void setUp() {
        team = new Team();
        team.setName("team A");
        this.team.setProduct("product");
        this.team.setDefault_location("LISBON");
    }

    @Test
    void shouldRetrieveAllTeams(){

        stubFor(get(urlEqualTo("/external/hello"))
                .willReturn(aResponse()
                        .withHeader("Content-Type","application/json")
                        .withStatus(200)
                        .withBody("{\"message\":\"Hello\"}")
                ));


        when().get()
                .then()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    void shouldRetrieveTeamById(){

    }

    @Test
    void shouldCreateTeam() {
        //RequestSpecification request = RestAssured.given();

        // when
        given()
                .contentType(ContentType.JSON)
                .body(JSONB.toJson(this.team))
                .when()
                .post()
                .then()
                .log()
                .all()
                .statusCode(201)
                .extract().as(Team.class);

        // then
        //this.team = response.body().as(Team.class);
        //assertEquals(CREATED.getStatusCode(), response.getStatusCode());

    }

    @Test
    void shouldDeleteTeamById(){

    }
}




