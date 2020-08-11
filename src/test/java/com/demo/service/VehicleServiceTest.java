/**
 * 
 */
package com.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.model.Vehicle;
import com.demo.repository.VehicleRepository;
import com.demo.service.impl.VehicleServiceImpl;

/**
 * @author PragunMehta
 *
 */

@ExtendWith(MockitoExtension.class)
public class VehicleServiceTest {

	@Mock
	private VehicleRepository vehicleRepository;
	
	@InjectMocks
	private VehicleService vehicleService = new VehicleServiceImpl();
	
	/**
	 * Test VehicleService method getAllVehicles()
	 */
	@Test
	@DisplayName("Test VehicleService.getAllVehicles()")
	void testGetAllVehicles() {
		when(vehicleRepository.findAll()).thenReturn(createAllVehicles());
		List<Vehicle> vehicles = vehicleService.getAllVehicles();
		assertEquals(3, vehicles.size());
		assertEquals("REG-1", vehicles.get(0).getRegistrationNumber());
		assertEquals("REG-2", vehicles.get(1).getRegistrationNumber());
		assertEquals("REG-3", vehicles.get(2).getRegistrationNumber());
	}
	
	/**
	 * Test VehicleService method getVehicleByRegistrationNumber()
	 */
	@Test
	@DisplayName("Test VehicleService.getVehicleByRegistrationNumber()")
	void testGetVehicleByRegistrationNumber() {
		when(vehicleRepository.findByRegistrationNumber("REG-7")).thenReturn(createVehicle());
		Optional<Vehicle> vehicles = vehicleService.getVehicleByRegistrationNumber("REG-7");
		assertEquals("BMW", vehicles.get().getMake());
		assertEquals("Z4", vehicles.get().getModel());
		assertEquals("REG-7", vehicles.get().getRegistrationNumber());
	}
	
	/**
	 * Test VehicleService method getVehiclesToHire()
	 */
	@Test
	@DisplayName("Test VehicleService.getVehiclesToHire()")
	void testGetVehiclesToHire() {
		when(vehicleRepository.findByCustomer(null)).thenReturn(createVehiclesToHire());
		List<Vehicle> vehicles = vehicleService.getVehiclesToHire();
		assertEquals(3, vehicles.size());
		assertEquals("REG-4", vehicles.get(0).getRegistrationNumber());
		assertEquals("REG-5", vehicles.get(1).getRegistrationNumber());
		assertEquals("REG-6", vehicles.get(2).getRegistrationNumber());
	}

	/**
	 * @return List of Vehicle
	 */
	private List<Vehicle> createAllVehicles() {
		List<Vehicle> allVehicleList = List.of(
				new Vehicle(1L, "REG-1", "BMW", "Z4", "Petrol", "Small car", new BigDecimal(25), "Individual_A",
						LocalDate.parse("2020-07-21"), LocalDate.parse("2020-07-25")),
				new Vehicle(2L, "REG-2", "BMW", "Gran Tourer", "Diesel", "Van", new BigDecimal(50), "Company_A",
						LocalDate.parse("2020-03-01"), LocalDate.parse("2020-03-31")),
				new Vehicle(3L, "REG-3", "BMW", "X5", "Diesel", "Estate car", new BigDecimal(35), "", null, null));
		return allVehicleList;
	}
	
	/**
	 * @return List of Vehicle
	 */
	private List<Vehicle> createVehiclesToHire() {
		List<Vehicle> allVehiclesToHire = List.of(
				new Vehicle(4L, "REG-4", "BMW", "Z4", "Petrol", "Small car", new BigDecimal(25), "", null, null),
				new Vehicle(5L, "REG-5", "BMW", "Gran Tourer", "Diesel", "Van", new BigDecimal(50), "", null, null),
				new Vehicle(6L, "REG-6", "BMW", "X5", "Diesel", "Estate car", new BigDecimal(35), "", null, null));
		return allVehiclesToHire;
	}
	
	/**
	 * @return Vehicle
	 */
	private Optional<Vehicle> createVehicle() {
		return Optional.of(new Vehicle(7L, "REG-7", "BMW", "Z4", "Petrol", "Small car", new BigDecimal(25),
				"Individual_B", LocalDate.parse("2020-02-21"), LocalDate.parse("2020-02-25")));
	}
	
}
