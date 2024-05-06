package com.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class VehicleTrack {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @OneToMany(mappedBy = "tracking", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Vehicle> vehicles;

	    @Column(nullable = false)
	    private String trackingSystemName;

		public VehicleTrack() {
			super();
			// TODO Auto-generated constructor stub
		}

		public VehicleTrack(Long id, List<Vehicle> vehicles, String trackingSystemName) {
			super();
			this.id = id;
			this.vehicles = vehicles;
			this.trackingSystemName = trackingSystemName;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public List<Vehicle> getVehicles() {
			return vehicles;
		}

		public void setVehicles(List<Vehicle> vehicles) {
			this.vehicles = vehicles;
		}

		public String getTrackingSystemName() {
			return trackingSystemName;
		}

		public void setTrackingSystemName(String trackingSystemName) {
			this.trackingSystemName = trackingSystemName;
		}

		@Override
		public String toString() {
			return "VehicleTrack [id=" + id + ", vehicles=" + vehicles + ", trackingSystemName=" + trackingSystemName
					+ "]";
		}

}
