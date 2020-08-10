/**
 * @author PragunMehta
 * 
 */
package com.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.demo.model.Vehicle;

/**
 * Vehicle Service class
 *
 */
@Service
public interface VehicleService {

	/**
	 * @return the List of all the Vehicles
	 */
	public List<Vehicle> getAllVehicles();

	/**
	 * @return the List of all the Vehicles available to Hire
	 */
	public List<Vehicle> getAllVehiclesToHire();

	/**
	 * @return the Vehicle by registration number
	 */
	public Vehicle getVehicleByRegistrationNumber(String registrationNumber);

}
