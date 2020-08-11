/**
 * @author PragunMehta
 * 
 */
package com.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepository;
import com.demo.service.VehicleService;

/**
 * Vehicle Service Implementation class
 *
 */
@Service
public class VehicleServiceImpl implements VehicleService {

	@Autowired
	VehicleRepository vehicleRepository;

	/**
	 * @return the List of all the Vehicles
	 */
	@Override
	public List<Vehicle> getAllVehicles() {
		return vehicleRepository.findAll();
	}

	/**
	 * @return the Vehicle by registration number
	 */
	@Override
	public Optional<Vehicle> getVehicleByRegistrationNumber(String registrationNumber) {
		return vehicleRepository.findByRegistrationNumber(registrationNumber);
	}

	/**
	 * @return the List of all the Vehicles available to Hire
	 */
	@Override
	public List<Vehicle> getVehiclesToHire() {
		return vehicleRepository.findByCustomer(null);
	}

}
