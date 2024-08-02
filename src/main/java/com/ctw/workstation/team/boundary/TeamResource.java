package com.ctw.workstation.team.boundary;

import com.ctw.workstation.ExternalApi;
import com.ctw.workstation.ExternalRequest;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.entity.TeamMember;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

@Path("/teams")
@RequestScoped
public class TeamResource {

    Logger logger = Logger.getLogger(TeamResource.class);

    @Inject
    TeamService teamService;

    /*
    @RestClient
    ExternalApi externalApi;
*/


    @GET
    public Response getAllTeams(){
        logger.info("Fetching all Teams");

        //externalApi.hello();

        List<Team> listOfTeams = teamService.findAllTeams();
        //return Response.status(Response.Status.OK).entity(listOfTeams).build();
        return Response.status(Response.Status.OK).entity(listOfTeams).build();
    }

    @GET
    @Path("{id}")
    public Response getTeamById(@PathParam("id") UUID uuidTeam){
        int id = 2;
        UUID request = UUID.randomUUID();
        //MDC.put("request", request.toString()); // change the que log format in the application.properties
        logger.info("Fetching team with id:" + uuidTeam);
        logger.infof("Fetching team with %s and %s", uuidTeam, id);
        logger.infov("Fetching team with {0}", uuidTeam);


        Team team = teamService.findTeamById(uuidTeam);
        return Response.status(Response.Status.OK).entity(team).build();
    }

    @POST
    public Response addTeam(@Valid Team team){
        logger.infov("Entrei na team post");
        teamService.addTeam(team);
        return Response.status(Response.Status.CREATED).entity(team).build();
    }

    @PUT
    @Path("{id}")
    public Response updateTeam(@PathParam("id") UUID uuidTeam, @Valid Team team){
        logger.infov("Entrei no put com a team: "+team);
        teamService.updateTeam(uuidTeam, team);
        return Response.status(Response.Status.ACCEPTED).entity(team).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeTeam(@PathParam("id") UUID uuidTeam){
        logger.infov("entrei com id"+uuidTeam);
        teamService.deleteTeam(uuidTeam);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}