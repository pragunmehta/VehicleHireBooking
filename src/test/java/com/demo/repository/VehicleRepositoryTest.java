/**
 * 
 */
package com.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.demo.model.Vehicle;

/**
 * @author PragunMehta
 *
 */

@ExtendWith(MockitoExtension.class)
@DataJpaTest
public class VehicleRepositoryTest {
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	/**
	 * Test VehicleRepository method findAll()
	 */
	@Test
	@DisplayName("Test VehicleRepository.findAll()")
	public void testFindAll() {
		List<Vehicle> vehicles = vehicleRepository.findAll();
		assertEquals(9, vehicles.size());
	}
	
	/**
	 * Test VehicleRepository method findByRegistrationNumber()
	 */
	@Test
	@DisplayName("Test VehicleRepository.findByRegistrationNumber()")
	public void testFindByRegistrationNumber() {
		Optional<Vehicle> foundVehicle = vehicleRepository.findByRegistrationNumber("REG-5");
		assertEquals("BMW", foundVehicle.get().getMake());
		assertEquals("Gran Tourer", foundVehicle.get().getModel());
	}
	
	/**
	 * Test VehicleRepository method findByCustomer()
	 */
	@Test
	@DisplayName("Test VehicleRepository.findByCustomer()")
	public void testfindByCustomer() {
		List<Vehicle> vehicles = vehicleRepository.findByCustomer("Company_A");
		assertEquals(3, vehicles.size());
	}

}
