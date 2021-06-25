package com.example.rentparking.entity.data.dto;

import com.example.rentparking.entity.Booking;
import com.example.rentparking.entity.Parking;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingDTO {
    Parking parking;
    Booking booking;
}
