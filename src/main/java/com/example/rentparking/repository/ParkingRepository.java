package com.example.rentparking.repository;

import com.example.rentparking.entity.Parking;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface ParkingRepository extends JpaRepository<Parking, Integer> {

}