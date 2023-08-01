package com.main;

import java.time.LocalDateTime;

import com.services.Vehicle;

public class Rental {
	private Vehicle rentedVehicle;
    private Customer customer;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    
    
    
    //getters and setters
	public Vehicle getRentedVehicle() {
		return rentedVehicle;
	}
	public void setRentedVehicle(Vehicle rentedVehicle) {
		this.rentedVehicle = rentedVehicle;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public LocalDateTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}
	public LocalDateTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}
	
	
	@Override
	public String toString() {
		return "Rental [rentedVehicle=" + rentedVehicle + ", customer=" + customer + ", startTime=" + startTime
				+ ", endTime=" + endTime + "]";
	}
    
	
	
    
}
