package com.ctw.workstation.rack.boundary;

import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.rackasset.entity.RackAsset;
import com.ctw.workstation.teammember.boundary.TeamMemberResource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/racks")
@RequestScoped
public class RackResource {

    Logger logger = Logger.getLogger(RackResource.class);

    @Inject
    RackService rackService;

    @GET
    public Response getAllRacks(){
        List<Rack> listOfRacks = rackService.findAllRacks();
        return Response.status(Response.Status.OK).entity(listOfRacks).build();
    }

    @GET
    @Path("/{id}")
    public Response getRackById(@PathParam("id") UUID uuidRack){
        Rack rackAsset = rackService.findRackById(uuidRack);
        return Response.status(Response.Status.OK).entity(rackAsset).build();
    }

    @POST
    public Response addRack(Rack rack){
        rackService.addRack(rack);
        return Response.status(Response.Status.CREATED).entity(rack).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeRack(@PathParam("id") UUID uuidRack){
        rackService.removeRack(uuidRack);
        return Response.status(Response.Status.ACCEPTED).build();
    }
}
