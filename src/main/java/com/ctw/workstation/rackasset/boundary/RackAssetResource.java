package com.ctw.workstation.rackasset.boundary;

import com.ctw.workstation.rackasset.control.RackAssetService;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.team.control.TeamService;
import com.ctw.workstation.team.entity.Team;
import com.ctw.workstation.teammember.boundary.TeamMemberResource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/rackasset")
@RequestScoped
public class RackAssetResource {

    Logger logger = Logger.getLogger(RackAssetResource.class);

    @Inject
    RackAssetService rackAssetService;

    @GET
    public Response getAllRackAssets(){
        List<RackAsset> listOfRackAssets = rackAssetService.findAllRackAssets();
        return Response.status(Response.Status.OK).entity(listOfRackAssets.toArray()).build();
    }

    @GET
    @Path("/{id}")
    public Response getTeamById(@PathParam("id") UUID uuidRackAsset){
        RackAsset rackAsset = rackAssetService.findRackAssetById(uuidRackAsset);
        return Response.status(Response.Status.OK).entity(rackAsset).build();
    }

    @POST
    public Response addRackAsset(RackAsset rackAsset){
        rackAssetService.addRackAsset(rackAsset);
        return Response.status(Response.Status.CREATED).entity(rackAsset).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeRackAsset(@PathParam("id") UUID uuidRackAsset){
        rackAssetService.removeRackAsset(uuidRackAsset);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}