package com.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Vehicle;
import com.Services.VehicleTrackService;

@RestController
@RequestMapping("/vehicle-tracks")
public class VehicleTrackController {

	@Autowired
	private VehicleTrackService vehicleTrackService;
	
	@PostMapping("/register-vehicle")
    public ResponseEntity<Vehicle> registerVehicleWithTrackSystem(@RequestParam String vehicleId,@RequestParam String location,@RequestParam Long trackingSystemId) {
        Vehicle registeredVehicle = vehicleTrackService.registerVehicleWithTrackSystem(vehicleId, location, trackingSystemId);
        return new ResponseEntity<>(registeredVehicle, HttpStatus.CREATED);
    }
	
	@GetMapping("/get-vehicles/{trackingSystemId}")
    public ResponseEntity<List<Vehicle>> getAllVehiclesByTrackingSystem(@PathVariable Long trackingSystemId) {
        List<Vehicle> vehicles = vehicleTrackService.getAllVehiclesByTrackingSystem(trackingSystemId);
        return new ResponseEntity<>(vehicles, HttpStatus.OK);
    }
	@GetMapping("/get-vehicle/{vehicleId}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable Long vehicleId) {
        Optional<Vehicle> vehicle = vehicleTrackService.getVehicleById(vehicleId);
        return vehicle.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
	@PutMapping("/update-location/{vehicleId}")
    public ResponseEntity<Void> updateVehicleLocation(@PathVariable Long vehicleId,@RequestParam String newLocation) {
        vehicleTrackService.updateVehicleLocation(vehicleId, newLocation);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/delete-vehicle/{vehicleId}")
    public ResponseEntity<Void> deleteVehicle(@PathVariable Long vehicleId) {
        vehicleTrackService.deleteVehicle(vehicleId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
