package com.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Vehicle;
import com.Entity.VehicleTrack;
import com.Repository.VehicleRepository;
import com.Repository.VehicleTrackRepository;

@Service
public class VehicleTrackService {

	@Autowired
    private VehicleRepository vehicleRepository;
	
	@Autowired
    private VehicleTrackRepository vehicleTrackingRepository;

	public Vehicle registerVehicleWithTrackSystem(String vehicleId, String location, Long trackingSystemId) {
        // Find the tracking system by its ID
        VehicleTrack trackingSystem = vehicleTrackingRepository.findById(trackingSystemId)
                .orElseThrow(() -> new IllegalArgumentException("Tracking system with id " + trackingSystemId + " not found"));
     
        // Create a new vehicle object
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleId(vehicleId);
        vehicle.setLocation(location);
        vehicle.setTracking(trackingSystem);
        
        return vehicleRepository.save(vehicle);
    }
	public List<Vehicle> getAllVehiclesByTrackingSystem(Long trackingSystemId) {
        // Find the tracking system by its ID
        VehicleTrack trackingSystem = vehicleTrackingRepository.findById(trackingSystemId)
                .orElseThrow(() -> new IllegalArgumentException("Tracking system with id " + trackingSystemId + " not found"));

        // Return all vehicles associated with the tracking system
        return trackingSystem.getVehicles();
    }
	public Optional<Vehicle> getVehicleById(Long vehicleId) {
       
        return vehicleRepository.findById(vehicleId);
    }
	public void updateVehicleLocation(Long vehicleId, String newLocation) {
        // Find the vehicle by its ID
        Vehicle vehicle = vehicleRepository.findById(vehicleId)
                .orElseThrow(() -> new IllegalArgumentException("Vehicle with id " + vehicleId + " not found"));

        // Update the location of the vehicle
        vehicle.setLocation(newLocation);

        vehicleRepository.save(vehicle);
    }
	public void deleteVehicle(Long vehicleId) {
       
        vehicleRepository.deleteById(vehicleId);
    }
}
