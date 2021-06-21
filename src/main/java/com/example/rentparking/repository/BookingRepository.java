package com.example.rentparking.repository;

import com.example.rentparking.entity.Booking;
import com.example.rentparking.entity.data.BookingStatus;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByBookingStatusAndParking_Location_Name(BookingStatus bookingStatus, String name);
    List<Booking> findAllByBookingStatusAndParking_Location_City(BookingStatus bookingStatus, String city);
}