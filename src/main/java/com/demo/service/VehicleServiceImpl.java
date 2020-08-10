/**
 * @author PragunMehta
 * 
 */
package com.demo.service;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepository;

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
	public Vehicle getVehicleByRegistrationNumber(String registrationNumber) {
		return vehicleRepository.findByRegistrationNumber(registrationNumber);
	}

	/**
	 * @return the List of all the Vehicles available to Hire
	 */
	@Override
	public List<Vehicle> getAllVehiclesToHire() {
		List<Vehicle> vehicleList = getAllVehicles();
		Predicate<Vehicle> predicate = vehicle -> vehicle.getCustomer() == null;
		Stream<Vehicle> stream = vehicleList.stream().filter(predicate);
		return stream.collect(Collectors.toList());
	}

}
