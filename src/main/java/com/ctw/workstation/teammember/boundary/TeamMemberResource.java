package com.ctw.workstation.teammember.boundary;

import com.ctw.workstation.team.boundary.TeamResource;
import com.ctw.workstation.teammember.control.TeamMemberService;
import com.ctw.workstation.teammember.entity.TeamMemberDTO;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.slf4j.LoggerFactory;


import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Path("/teammembers")
@RequestScoped
public class TeamMemberResource {

    Logger logger = Logger.getLogger(TeamMemberResource.class);

    @Inject
    TeamMemberService teamMemberService;

    @GET
    public Response getAllTeamsMembers(){
        try {
            List<TeamMemberDTO> listOfTeamMembersDTO = teamMemberService.findAllTeamMembers();

            return listOfTeamMembersDTO.isEmpty() ? Response.status(Response.Status.NO_CONTENT).build() :
                    Response.status(Response.Status.OK)
                    .entity(listOfTeamMembersDTO.toArray())
                    .build();
        }catch(BadRequestException | NotFoundException exception){
            return exception.getResponse();
        }
    }

    @GET
    @Path("/{id}")
    public Response getTeamMemberById(@PathParam("id") UUID uuidTeamMember){
        try {
            TeamMemberDTO teamMemberDTO = teamMemberService.findTeamMemberById(uuidTeamMember);

            return Response.status(Response.Status.OK)
                    .entity(teamMemberDTO)
                    .build();
        }catch(BadRequestException | NotFoundException exception){
            return exception.getResponse();
        }
    }

    @POST
    public Response addTeamMember(@Valid TeamMemberDTO teamMemberDTO){
        try {
            TeamMemberDTO teamMemberDTOReturned = teamMemberService.addTeamMember(teamMemberDTO);

            return Response.status(Response.Status.CREATED)
                    .entity(teamMemberDTOReturned)
                    .build();
        }catch(BadRequestException exception){
            return exception.getResponse();
        }
    }

    @DELETE
    @Path("{id}")
    public Response removeTeamMember(@PathParam("id") UUID uuidTeamMember){
        return teamMemberService.removeTeamMember(uuidTeamMember) ?
                Response.status(Response.Status.ACCEPTED).build() :
                Response.status(Response.Status.NOT_FOUND).build();
    }

    /*
    @PUT
    public Response updateTeamMember(TeamMemberDTO teamMemberDTO){
        TeamMemberDTO teamMemberDTOReturned = teamMemberService.updateTeamMember(teamMemberDTO);

        return Response.status(Response.Status.ACCEPTED)
                .entity(teamMemberDTOReturned)
                .build();
    }
     */


}
