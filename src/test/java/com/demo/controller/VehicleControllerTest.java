/**
 * @author PragunMehta
 * 
 */
package com.demo.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.model.Vehicle;
import com.demo.service.VehicleService;

/**
 * Vehicle Hire Booking Test class
 *
 */
@ExtendWith(MockitoExtension.class)
class VehicleControllerTest {

	private static final String JSON_RESPONSE_GET_VEHICLE_COST = 
			"{\"Make\":\"BMW\",\"Model\":\"Z4\",\"Fuel\":\"Petrol\",\"Category\":\"Small car\","
			+ "\"Registration Number\":\"REG-7\",\"From Date\":\"2020-01-01\",\"To Date\":\"2020-01-31\","
			+ "\"TOTAL COST\":\"£750\"}";
	private static final String JSON_RESPONSE_GET_VEHICLE_BY_REGISTRATION_NUMBER = 
			"{\"id\":7,\"registrationNumber\":\"REG-7\",\"make\":\"BMW\",\"model\":\"Z4\","
			+ "\"fuel\":\"Petrol\",\"category\":\"Small car\",\"pricePerDay\":25,"
			+ "\"customer\":\"Individual_B\",\"hireStartDate\":[2020,2,21],\"hireEndDate\":[2020,2,25]}";
	private static final String JSON_RESPONSE_GET_ALL_VEHICLES = 
			"[{\"id\":1,\"registrationNumber\":\"REG-1\",\"make\":\"BMW\",\"model\":\"Z4\","
			+ "\"fuel\":\"Petrol\",\"category\":\"Small car\",\"pricePerDay\":25,"
			+ "\"customer\":\"Individual_A\",\"hireStartDate\":[2020,7,21],\"hireEndDate\":[2020,7,25]},"
			+ "{\"id\":2,\"registrationNumber\":\"REG-2\",\"make\":\"BMW\",\"model\":\"Gran Tourer\","
			+ "\"fuel\":\"Diesel\",\"category\":\"Van\",\"pricePerDay\":50,"
			+ "\"customer\":\"Company_A\",\"hireStartDate\":[2020,3,1],\"hireEndDate\":[2020,3,31]},"
			+ "{\"id\":3,\"registrationNumber\":\"REG-3\",\"make\":\"BMW\",\"model\":\"X5\","
			+ "\"fuel\":\"Diesel\",\"category\":\"Estate car\",\"pricePerDay\":35,"
			+ "\"customer\":\"\",\"hireStartDate\":null,\"hireEndDate\":null}]";
	private static final String JSON_RESPONSE_GET_ALL_VEHICLES_TO_HIRE = 
			"[{\"id\":4,\"registrationNumber\":\"REG-4\",\"make\":\"BMW\",\"model\":\"Z4\","
			+ "\"fuel\":\"Petrol\",\"category\":\"Small car\",\"pricePerDay\":25,"
			+ "\"customer\":\"\",\"hireStartDate\":null,\"hireEndDate\":null},"
			+ "{\"id\":5,\"registrationNumber\":\"REG-5\",\"make\":\"BMW\",\"model\":\"Gran Tourer\","
			+ "\"fuel\":\"Diesel\",\"category\":\"Van\",\"pricePerDay\":50,"
			+ "\"customer\":\"\",\"hireStartDate\":null,\"hireEndDate\":null},"
			+ "{\"id\":6,\"registrationNumber\":\"REG-6\",\"make\":\"BMW\",\"model\":\"X5\","
			+ "\"fuel\":\"Diesel\",\"category\":\"Estate car\",\"pricePerDay\":35,"
			+ "\"customer\":\"\",\"hireStartDate\":null,\"hireEndDate\":null}]";

	private MockMvc mockMvc;

	@InjectMocks
	private VehicleController controller;

	@Mock
	private VehicleService service;

	@BeforeEach
	void setUp() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(this.controller).build();
	}

	/**
	 * Test VehicleController method getAllVehicles()
	 */
	@Test
	@DisplayName("Test VehicleController.getAllVehicles()")
	void testGetAllVehicles() throws Exception {
		when(service.getAllVehicles()).thenReturn(createAllVehicles());
		mockMvc.perform(get("/vehicles/all"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andDo(print())
			.andExpect(content().json(JSON_RESPONSE_GET_ALL_VEHICLES));
	}

	/**
	 * Test VehicleController method getVehicleByRegistrationNumber()
	 */
	@Test
	@DisplayName("Test VehicleController.getVehicleByRegistrationNumber()")
	void testGetVehicleByRegistrationNumber() throws Exception {
		when(service.getVehicleByRegistrationNumber("REG-7")).thenReturn(createVehicle());
		mockMvc.perform(get("/vehicles/REG-7"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andDo(print())
			.andExpect(content().json(JSON_RESPONSE_GET_VEHICLE_BY_REGISTRATION_NUMBER));
	}

	/**
	 * Test VehicleController method getAllVehiclesToHire()
	 */
	@Test
	@DisplayName("Test VehicleController.getAllVehiclesToHire() thros VehicleNotFoundException")
	void testGetByRegistrationNumberVehicleNotFoundException() throws Exception {
		when(service.getVehicleByRegistrationNumber("XXX-X")).thenReturn(Optional.empty());
		mockMvc.perform(get("/vehicles/XXX-X")).andExpect(status().isNotFound());
	}

	/**
	 * Test VehicleController method getVehicleCostToHire()
	 */
	@Test
	@DisplayName("Test VehicleController.getVehicleCostToHire()")
	void testGetVehicleCostToHire() throws Exception {
		when(service.getVehicleByRegistrationNumber("REG-7")).thenReturn(createVehicle());
		mockMvc.perform(get("/vehicles/REG-7/2020-01-01/2020-01-31"))
			.andExpect(status().isOk())
			.andDo(print())
			.andExpect(content().string(JSON_RESPONSE_GET_VEHICLE_COST));
	}

	/**
	 * Test VehicleController method getAllVehiclesToHire()
	 */
	@Test
	@DisplayName("Test VehicleController.getAllVehiclesToHire()")
	void testGetAllVehiclesToHire() throws Exception {
		when(service.getVehiclesToHire()).thenReturn(createVehiclesToHire());
		mockMvc.perform(get("/vehicles/hire"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
			.andDo(print())
			.andExpect(content().json(JSON_RESPONSE_GET_ALL_VEHICLES_TO_HIRE));
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
