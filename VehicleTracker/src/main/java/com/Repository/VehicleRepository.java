package com.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
}
