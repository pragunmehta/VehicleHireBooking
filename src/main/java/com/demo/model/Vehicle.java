/**
 * @author PragunMehta
 * 
 */
package com.demo.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Vehicle Entity class 
 *
 */
@Entity
@Table(name = "VEHICLE")
public class Vehicle {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "REGISTRATION_NUMBER", unique = true, nullable = false)
	private String registrationNumber;

	@Column(name = "MAKE", nullable = false)
	private String make;

	@Column(name = "MODEL", nullable = false)
	private String model;

	@Column(name = "FUEL", nullable = false)
	private String fuel;

	@Column(name = "CATEGORY", nullable = false)
	private String category;

	@Column(name = "PRICE_PER_DAY", nullable = false)
	private BigDecimal pricePerDay;

	@Column(name = "CUSTOMER")
	private String customer;

	@Column(name = "HIRE_START_DATE")
	private LocalDate hireStartDate;

	@Column(name = "HIRE_END_DATE")
	private LocalDate hireEndDate;

	/**
	 * Default Constructor
	 */
	public Vehicle() {
	}
	
	/**
	 * @param id
	 * @param registrationNumber
	 * @param make
	 * @param model
	 * @param fuel
	 * @param category
	 * @param pricePerDay
	 * @param customer
	 * @param hireStartDate
	 * @param hireEndDate
	 */
	public Vehicle(Long id, String registrationNumber, String make, String model, String fuel, String category,
			BigDecimal pricePerDay, String customer, LocalDate hireStartDate, LocalDate hireEndDate) {
		super();
		this.id = id;
		this.registrationNumber = registrationNumber;
		this.make = make;
		this.model = model;
		this.fuel = fuel;
		this.category = category;
		this.pricePerDay = pricePerDay;
		this.customer = customer;
		this.hireStartDate = hireStartDate;
		this.hireEndDate = hireEndDate;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param Long the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the registrationNumber
	 */
	public String getRegistrationNumber() {
		return registrationNumber;
	}

	/**
	 * @param String the registrationNumber to set
	 */
	public void setRegistrationNumber(String registrationNumber) {
		this.registrationNumber = registrationNumber;
	}

	/**
	 * @return the make
	 */
	public String getMake() {
		return make;
	}

	/**
	 * @param String the make to set
	 */
	public void setMake(String make) {
		this.make = make;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param String the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the fuel
	 */
	public String getFuel() {
		return fuel;
	}

	/**
	 * @param String the fuel to set
	 */
	public void setFuel(String fuel) {
		this.fuel = fuel;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param String the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the pricePerDay
	 */
	public BigDecimal getPricePerDay() {
		return pricePerDay;
	}

	/**
	 * @param BigDecimal the price to set
	 */
	public void setPricePerDay(BigDecimal pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	/**
	 * @return the customer
	 */
	public String getCustomer() {
		return customer;
	}

	/**
	 * @param String the customer to set
	 */
	public void setCustomer(String customer) {
		this.customer = customer;
	}

	/**
	 * @return the hireStartDate
	 */
	public LocalDate getHireStartDate() {
		return hireStartDate;
	}

	/**
	 * @param Date the hireStartDate to set
	 */
	public void setHireDate(LocalDate hireStartDate) {
		this.hireStartDate = hireStartDate;
	}

	/**
	 * @return the hireEndDate
	 */
	public LocalDate getHireEndDate() {
		return hireEndDate;
	}

	/**
	 * @param Date the hireEndDate to set
	 */
	public void setHireEndDate(LocalDate hireEndDate) {
		this.hireEndDate = hireEndDate;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", " + "registrationNumber=" + registrationNumber + ", " + "make=" + make
				+ ", " + "model=" + model + ", " + "fuel=" + fuel + ", " + "category=" + category + ", " + "customer="
				+ customer + ", " + "hireStartDate=" + hireStartDate + ", " + "hireEndDate=" + hireEndDate.toString()
				+ "]";
	}

}
