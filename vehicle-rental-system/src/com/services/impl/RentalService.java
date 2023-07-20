package com.services.impl;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import com.main.Customer;
import com.main.Rental;
import com.services.RentalCostCalculator;
import com.services.Vehicle;

public class RentalService implements RentalCostCalculator{
	private List<Vehicle> vehicles;
    private List<Rental> rentals;
    
    public RentalService()
    {
    	vehicles = new ArrayList<>();
    	rentals = new ArrayList<>();
    }
    
	//calculate rental cost
	@Override
	public BigDecimal calculateRentalCost(Rental rental) {
		int costPerHour = rental.getRentedVehicle().getCostPerHour();
		LocalDateTime startTime = rental.getStartTime();
		LocalDateTime endTime = rental.getEndTime();
		long hours = Duration.between(startTime, endTime).toHours();
		BigDecimal hours_bigDecimal = BigDecimal.valueOf(hours);
		
		BigDecimal costPerHour_bigDecimal = BigDecimal.valueOf((long)costPerHour);
		BigDecimal cost = hours_bigDecimal.multiply(costPerHour_bigDecimal);
		return cost;
	}

	//add a vehicle
	public void addVehicle(Vehicle vehicle)
	{
		vehicles.add(vehicle);
		System.out.println("vehicle added successfully!!");
		return;
	}
	
	//display all the vehicles;
	public List<Vehicle> listOfAvailableVehicles()
	{
		List<Vehicle> listOfAvailableVehicle = new ArrayList<>();
		for(Vehicle vehicle : vehicles)
		{
			if(vehicle.isAvailable())
			{
				listOfAvailableVehicle.add(vehicle);
			}
		}
		return listOfAvailableVehicle;
	}
	
    // Rent a vehicle
    public Rental rentVehicle(Customer customer, Vehicle vehicle, LocalDateTime startTime, LocalDateTime endTime) {
    	Rental rental = new Rental();
    	rental.setCustomer(customer);
    	rental.setRentedVehicle(vehicle);
    	rental.setStartTime(startTime);
    	rental.setEndTime(endTime);
    	
    	rentals.add(rental);
    	System.out.println("Rented successfully!!");
    	return null;
    }
    
    //return list of rented vehicles;
    public List<Rental> listOfRentals()
    {
    	List<Rental> listOfRentedVehicle = new ArrayList<>();
    	for(Rental rental : rentals)
    	{
    		if(!rental.getRentedVehicle().isAvailable())
    		{
    			listOfRentedVehicle.add(rental);
    		}
    	}
    	return listOfRentedVehicle;
    }
    
    // Return a rented vehicle
    public boolean returnVehicle(Rental rental) {
    	System.out.println("rental from rentalService : "+rental);
        rental.getRentedVehicle().setAvailable(true);
        BigDecimal calculatedRentalCost = calculateRentalCost(rental);
        System.out.println("please pay : "+calculatedRentalCost);
        return true;
    }
    
    
}
