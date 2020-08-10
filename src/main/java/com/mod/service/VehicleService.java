/**
 * @author PragunMehta
 * 
 */
package com.mod.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mod.model.Vehicle;

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
