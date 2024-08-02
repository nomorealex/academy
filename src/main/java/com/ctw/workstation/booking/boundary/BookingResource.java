package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.control.RackService;
import com.ctw.workstation.rack.entity.Rack;
import com.ctw.workstation.teammember.boundary.TeamMemberResource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.UUID;

@Path("/bookings")
@RequestScoped
public class BookingResource {

    Logger logger = Logger.getLogger(BookingResource.class);

    @Inject
    BookingService bookingService;

    @GET
    public Response getAllRacks(){
        List<Booking> listOfBookings = bookingService.findAllBookings();
        return Response.status(Response.Status.OK).entity(listOfBookings).build();
    }

    @GET
    @Path("/{id}")
    public Response getBookingById(@PathParam("id") UUID uuidBooking){
        Booking booking = bookingService.findBookingById(uuidBooking);
        return Response.status(Response.Status.OK).entity(booking).build();
    }


    @POST
    public Response addBooking(Booking booking){
        bookingService.addBooking(booking);
        return Response.status(Response.Status.CREATED).entity(booking).build();
    }

    @DELETE
    @Path("{id}")
    public Response removeBooking(@PathParam("id") UUID uuidBooking){
        bookingService.removeBooking(uuidBooking);
        return Response.status(Response.Status.ACCEPTED).build();
    }


}