package com.ctw.workstation.booking.boundary;

import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.repository.mapper.BookingMapper;
import com.ctw.workstation.shared.exception.CustomNotFoundException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

import java.util.List;
import java.util.UUID;

@Path("bookings")
public class BookingResource {

    Logger logger = Logger.getLogger(BookingResource.class.getName());

    @Inject
    BookingService bookingService;

    @Inject
    BookingMapper bookingMapper;

    @GET
    public List<BookingDTO> getAllBookings() {
        String name = "test";
        logger.info("Get all books for " + name);
        logger.infov("Get all books for {0}", name);
        UUID requesterId = UUID.randomUUID();
        MDC.put("requestId", requesterId.toString());

        List<Booking> bookings = bookingService.findAll();

        return bookingMapper.EntityToDto(bookings);

    }

    @POST
    public Response add(BookingDTO bookingDTO) {
        Booking booking = bookingMapper.dtoToEntity(bookingDTO);
        bookingService.add(booking);

        return Response.status((Response.Status.CREATED)).entity(booking).build();

    }

    @GET
    @Path("/{id}")
    public Response getBookingsById(@PathParam("id") Long id) {
        Booking booking = bookingService.findById(id).orElse(null);

        if (booking != null) {
            BookingDTO bookingDTO = bookingMapper.EntityToDto(booking);

            return Response.status(Response.Status.OK).entity(bookingDTO).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response updateBookingById(@PathParam("id") Long id, BookingDTO bookingDTO) {
        Booking foundBooking = bookingService.findById(id).orElse(null);
        if (foundBooking == null) {
            throw new CustomNotFoundException(Booking.class.getName());
        }

        Booking booking = bookingMapper.dtoToEntity(bookingDTO);
        bookingService.update(booking);

        return Response.status(Response.Status.OK).entity(booking).build();

    }

    @DELETE
    @Path("/{id}")
    public Response deleteBookingById(@PathParam("id") Long id) {
        Booking foundBooking = bookingService.findById(id).orElse(null);
        if (foundBooking == null) {
            throw new CustomNotFoundException(Booking.class.getName());
        }

        bookingService.delete(foundBooking);

        return Response.status(Response.Status.OK).build();
    }

}
