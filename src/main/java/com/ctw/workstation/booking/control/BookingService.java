package com.ctw.workstation.booking.control;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.rack.entity.Rack;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class BookingService implements PanacheRepositoryBase<Booking, UUID> {

    public Booking findBookingById(UUID bookingUUID){
        return findById(bookingUUID);
    }

    public List<Booking> findAllBookings(){
        return listAll();
    }

    @Transactional
    public Booking addBooking(Booking booking){
        //Maybe we should make some validations in order to see if the user sends the UUID field.
        persist(booking);
        return booking;
    }

    @Transactional
    public void removeBooking(UUID uuidBooking){
        this.listAll().removeIf(n -> n.getId().equals(uuidBooking));
    }


}
