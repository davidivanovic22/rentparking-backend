package com.example.rentparking.repository.views;

import org.springframework.beans.factory.annotation.Value;

public interface BookingDTOView {
    @Value("#{target.booking_id}")
    Integer getBookingId();
    @Value("#{target.parking_id}")
    Integer getParkingId();
}
