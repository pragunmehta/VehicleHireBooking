/**
 * @author PragunMehta
 * 
 */
package com.mod.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mod.model.Vehicle;

/**
 * Vehicle Service class 
 *
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
	
	public Vehicle findByRegistrationNumber(String registrationNumber);

}
