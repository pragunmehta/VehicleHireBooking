/**
 * @author PragunMehta
 * 
 */
package com.demo.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.model.Vehicle;

/**
 * Vehicle Service class 
 *
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public Optional<Vehicle> findByRegistrationNumber(String registrationNumber);
	
	public List<Vehicle> findByCustomer(String customer);

}
