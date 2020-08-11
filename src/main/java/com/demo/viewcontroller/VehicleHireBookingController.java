/**
 * 
 */
package com.demo.viewcontroller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author PragunMehta
 *
 */

@Controller
public class VehicleHireBookingController {

	@GetMapping("/")
	public String vehicleHireBooking() {
		return "VehicleHireBooking";
	}

}
