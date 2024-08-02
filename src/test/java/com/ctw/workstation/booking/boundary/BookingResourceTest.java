package com.ctw.workstation.booking.boundary;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.ctw.workstation.CommonProfile;
import com.ctw.workstation.booking.control.BookingService;
import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.repository.BookingRepository;

import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.TestProfile;
import jakarta.inject.Inject;

@QuarkusTest
@TestMethodOrder(MethodOrderer.MethodName.class)
@TestProfile(CommonProfile.class)
class BookingResourceTest {

    @Inject
    BookingService bookingService;

    @InjectMock
    BookingRepository bookingRepository;

    @BeforeEach
    void addBooking() {

        Booking booking = new Booking(null, 2L, 3L, LocalDateTime.now(), LocalDateTime.now(), null, null);
        bookingService.add(booking);

    }

    @Test
    @Order(1)
    void getBooking() {
        List<Booking> booking = bookingService.findAll();
        System.out.println(booking);
    }

//
//    @Test
//    void get_booking_by_id_returns_200() {
//        List<Team> teams = teamRepository.
//        when().get("/bookings/{id}", 3).
//                then().statusCode(200).body("rackId", equalTo(11));
//    }
//
//    @Test
//    void get_booking_by_id_returns_404() {
//
//        when().get("/bookings/{id}", 3).
//
//
//                then().statusCode(404);
//    }
//
//    @Test
    void getAllBookings() {
    }

    @Test
    void add() {
    }

    @Test
    void updateBookingById() {
    }

    @Test
    void deleteBookingById() {
    }
}
