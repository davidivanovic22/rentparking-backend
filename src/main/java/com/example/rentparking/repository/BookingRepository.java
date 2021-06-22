package com.example.rentparking.repository;

import com.example.rentparking.entity.Booking;
import com.example.rentparking.entity.data.domen.BookingStatus;
import com.example.rentparking.repository.views.BookingDTOView;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {
    List<Booking> findAllByBookingStatusAndParking_Location_Name(BookingStatus bookingStatus, String name);
    List<Booking> findAllByBookingStatusAndParking_Location_City(BookingStatus bookingStatus, String city);
    List<Booking> findAllByParking_Location_City(String city);

    @Query(value = "select p.parking_id, b.booking_id from booking b\n" +
            "right join parking p on p.parking_id = b.parking_id\n" +
            "join location l on p.location_id = l.location_id\n" +
            "where l.city like :city", nativeQuery = true)
    List<BookingDTOView> findAllBookingDTOByCity(String city);


}