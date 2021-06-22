package com.example.rentparking.repository;

import com.example.rentparking.entity.Parking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {
    List<Parking> findAllByLocation_City(String city);
}