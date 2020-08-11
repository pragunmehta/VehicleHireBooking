/**
 * @author PragunMehta
 * 
 */
package com.demo.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.exception.RecordNotFoundException;
import com.demo.model.Vehicle;
import com.demo.service.VehicleService;

/**
 * Vehicle Controller class
 *
 */
@RestController
@RequestMapping("/vehicles")
public class VehicleController {

	private VehicleService vehicleService;

	/**
	 * @param VehicleService vehicleService
	 */
	public VehicleController(VehicleService vehicleService) {
		this.vehicleService = vehicleService;
	}

	/**
	 * @return the List of all Vehicles
	 */
	@GetMapping("/all")
	public ResponseEntity<List<Vehicle>> getAllVehicles() {
		List<Vehicle> allVehicles = vehicleService.getAllVehicles();
		if (CollectionUtils.isEmpty(allVehicles)) {
			throw new RecordNotFoundException("No Vehicle found.");
		}
		return new ResponseEntity<List<Vehicle>>(allVehicles, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * @return the List of all Vehicles to hire
	 * @throws RecordNotFoundException
	 */
	@GetMapping("/hire")
	public ResponseEntity<List<Vehicle>> getAllVehiclesToHire() {
		List<Vehicle> vehiclesToHire = vehicleService.getVehiclesToHire();
		if (CollectionUtils.isEmpty(vehiclesToHire)) {
			throw new RecordNotFoundException("No Vehicle is available to hire.");
		}
		return new ResponseEntity<List<Vehicle>>(vehiclesToHire, new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * @return the Vehicle by Registration Number
	 */
	@GetMapping("/{registrationNumber}")
	public ResponseEntity<Vehicle> getVehicleByRegistrationNumber(
			@PathVariable("registrationNumber") String registrationNumber) {
		// get Vehicle
		Optional<Vehicle> vehicle = vehicleService.getVehicleByRegistrationNumber(registrationNumber);
		if (vehicle.isEmpty()) {
			throw new RecordNotFoundException(
					String.format("Vehicle with Registration Number %s not found", registrationNumber));
		}
		return new ResponseEntity<Vehicle>(vehicle.get(), new HttpHeaders(), HttpStatus.OK);
	}

	/**
	 * @return the cost of Vehicle by Registration Number during requested date range
	 */
	@GetMapping("/{registrationNumber}/{fromDate}/{toDate}")
	public String getVehicleCost(@PathVariable("registrationNumber") String registrationNumber,
			@PathVariable("fromDate") String fromDate, @PathVariable("toDate") String toDate) {
		// get Vehicle
		Optional<Vehicle> vehicleByRegistrationNumber = vehicleService.getVehicleByRegistrationNumber(registrationNumber);
		if (vehicleByRegistrationNumber.isEmpty()) {
			throw new RecordNotFoundException(
					String.format("Vehicle with Registration Number %s not found", registrationNumber));
		}
		// calculate cost for requested date range
		Vehicle vehicle = vehicleByRegistrationNumber.get();
		long daysToHire = LocalDate.parse(fromDate).datesUntil(LocalDate.parse(toDate)).count();
		BigDecimal vehicleHireCost = vehicle.getPricePerDay().multiply(new BigDecimal(daysToHire));
		return String.format(
				"The Vehicle %s %s %s %s Registration Number %s hiring cost for the %s days "
						+ "from date %s to date %s is £%s",
				vehicle.getMake(), vehicle.getModel(), vehicle.getFuel(), vehicle.getCategory(), registrationNumber,
				daysToHire, fromDate, toDate, vehicleHireCost);
	}

}
