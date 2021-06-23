package com.example.rentparking.service.impl;

import com.example.rentparking.entity.*;
import com.example.rentparking.entity.data.domen.BookingStatus;
import com.example.rentparking.entity.data.dto.BookingDTO;
import com.example.rentparking.repository.BookingRepository;
import com.example.rentparking.repository.views.BookingDTOView;
import com.example.rentparking.service.BookingService;

import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

import com.example.rentparking.service.ParkingService;
import com.example.rentparking.util.DateUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {
    private final BookingRepository bookingRepository;
    private final ParkingService parkingService;

    @Override
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Override
    public Booking findById(Integer bookingId) {
        return bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NoSuchElementException("BookingService.notFound"));
    }

    @Override
    public List<Booking> findAllByUserId(Integer userId) {
        return bookingRepository.findAllByUser_id(userId);
    }

    @Override
    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void automaticChangeBookingStatus() {
        List<Booking> bookingList = findAll();
        LocalDateTime now = LocalDateTime.now();
        bookingList.forEach(booking -> {
            System.out.println(now.withNano(0).isAfter(booking.getTo()));
            if (now.withNano(0).isAfter(booking.getTo())) {
                booking.setBookingStatus(BookingStatus.FREE);
                System.out.println(booking.getTo());
                System.out.println(booking.getFrom());
                save(booking);
            }
        });
    }

    @Override
    public Booking update(Booking booking) {
        return bookingRepository.save(booking);
    }

    @Override
    public void deleteById(Integer bookingId) {
        bookingRepository.deleteById(bookingId);
    }

    @Override
    public List<Booking> findAllByBookingStatusAndLocationName(BookingStatus bookingStatus, String name) {
        return bookingRepository.findAllByBookingStatusAndParking_Location_Name(bookingStatus, name);
    }

    @Override
    public List<Booking> findAllByBookingStatusAndLocationCity(BookingStatus bookingStatus, String city) {
        return bookingRepository.findAllByBookingStatusAndParking_Location_City(bookingStatus, city);
    }

    @Override
    public List<BookingDTO> findAllBookingDTO(String city, LocalDateTime from, LocalDateTime to) {
        List<BookingDTOView> bookingDTOViews = bookingRepository.findAllBookingDTOByCity(city);
        List<BookingDTO> bookingDTOList = new ArrayList<>();
        List<BookingDTO> bookingDTOList1 = new ArrayList<>();

        bookingDTOViews.forEach(bookingDTOView -> {
            BookingDTO bookingDTO = new BookingDTO();
            if (bookingDTOView.getBookingId() != null) {
                bookingDTO.setBooking(findById(bookingDTOView.getBookingId()));
            }
            bookingDTO.setParking(parkingService.findById(bookingDTOView.getParkingId()));
            bookingDTOList.add(bookingDTO);

        });
        if (from != null && to != null) {
            bookingDTOList.forEach(bookingDTO1 -> {
                if (bookingDTO1.getBooking() != null) {
                    if (DateUtil.compareFromToDateTime(bookingDTO1, from, to)) {
                        bookingDTOList1.add(bookingDTO1);
                    }
                }

                if (bookingDTO1.getBooking() == null) {
                    bookingDTOList1.add(bookingDTO1);
                }
            });
            return bookingDTOList1;
        } else {
            return bookingDTOList;
        }
    }
}