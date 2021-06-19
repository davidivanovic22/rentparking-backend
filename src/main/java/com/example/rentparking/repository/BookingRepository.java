package com.example.rentparking.repository;

import com.example.rentparking.entity.Booking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer> {

}