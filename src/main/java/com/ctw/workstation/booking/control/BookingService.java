package com.ctw.workstation.booking.control;

import java.util.List;
import java.util.Optional;

import com.ctw.workstation.booking.entity.Booking;
import com.ctw.workstation.booking.repository.BookingRepository;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
@Transactional
public class BookingService {

    @Inject
    BookingRepository bookingRepository;

    public List<Booking> findAll() {
        return bookingRepository.listAll();
    }

    public void add(Booking Booking) {
        bookingRepository.persist(Booking);
    }

    public Optional<Booking> findById(Long id) {
        return Optional.of(bookingRepository.findById(id));
    }

    public Booking update(Booking booking) {
        Booking existedBookingOpt = Optional.of(bookingRepository.findById(booking.getId())).orElse(null);

        if (existedBookingOpt != null) {

            existedBookingOpt.setBookFrom(booking.getBookFrom());
            existedBookingOpt.setBookTo(booking.getBookTo());
            existedBookingOpt.setRackId(booking.getRackId());
            existedBookingOpt.setRequesterId(booking.getRequesterId());
            bookingRepository.persist(existedBookingOpt);

            return existedBookingOpt;
        }
        return null;
    }

    public void delete(Booking Booking) {
        bookingRepository.delete(Booking);
    }
}