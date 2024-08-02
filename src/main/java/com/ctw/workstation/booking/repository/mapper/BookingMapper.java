package com.ctw.workstation.booking.repository.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.ctw.workstation.booking.boundary.BookingDTO;
import com.ctw.workstation.booking.entity.Booking;

@Mapper(componentModel = "cdi")
public interface BookingMapper {

    Booking dtoToEntity(BookingDTO bookingDTO);

    List<Booking> dtoToEntity(List<BookingDTO> bookingDTO);

    BookingDTO EntityToDto(Booking booking);

    List<BookingDTO> EntityToDto(List<Booking> booking);
}
