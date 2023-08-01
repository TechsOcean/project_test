package com.main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.services.Vehicle;
import com.services.impl.Bicycle;
import com.services.impl.Car;
import com.services.impl.MotorCycle;
import com.services.impl.RentalService;

public class VehicleServices {
	
	Scanner sc = new Scanner(System.in);
	private static int customerId=0;
	RentalService rentalService = new RentalService();
	
	// return the vehicle object after taking vehicle detaisl from user;
	public Vehicle inputVehicleDetails(Vehicle vehicle)
	{
		System.out.print("Enter license plate : ");
		String  licencePlate = sc.next();
		System.out.print("Enter vehicle make : ");
		String  make = sc.next();
		System.out.print("Enter vehicle model : ");
		String mode = sc.next();
		System.out.print("Enter cost per hour : ");
		int costPerHour = sc.nextInt();
		
		vehicle.setLicensePlate(licencePlate);
		vehicle.setMake(make);
		vehicle.setModel(mode);
		vehicle.setAvailable(true);
		vehicle.setCostPerHour(costPerHour);
		return vehicle;
	}
	
	/*
	 * instantiate vehicle object from one of the subclass(car,bicycle,motorcycle)
	 * based on user input
	 */
	public Vehicle selectVehicle()
	{
		int vehicleChoice;
		System.out.println("Availale Vehicles: ");
		System.out.println("   1. Car");
		System.out.println("   2. Bicycle");
		System.out.println("   3. MotorCycle");
		
		System.out.print("which vehicle you like to add (1-3): ");
		vehicleChoice = sc.nextInt();
		Vehicle vehicle=null;
		
		switch(vehicleChoice)
		{
		case 1:
			vehicle = new Car();
			vehicle.setVehicleType("Car");
			return vehicle;
		case 2:
			vehicle = new Bicycle();
			vehicle.setVehicleType("Bicycle");
			return vehicle;
		case 3:
			vehicle = new MotorCycle();
			vehicle.setVehicleType("MotorCycle");
			return vehicle;
		default:
			System.out.println("invalid selection");
		}
		
		return vehicle;
	}
	
//	take list of available vehicle and print them.
	public void printAvailableVehicle(List<Vehicle> vehicles)
	{
		int noOfVehicles = vehicles.size();
		if(noOfVehicles == 0)
		{
			System.out.println("No Vehicle is available");
			return;
		}
		for(int i=0;i<noOfVehicles;i++)
		{
			System.out.println((i+1)+".) "+vehicles.get(i));
		}
//		for(Vehicle vehicle : vehicles) System.out.println(vehicle);
		return;
	}
	
//	return a customer object, after taking customer details
	public Customer inputCustomerDetails()
	{
		Customer customer = new Customer();
		System.out.print("Enter first name : ");
		String firstName = sc.next();
		
		System.out.print("Enter last name : ");
		String lastName = sc.next();
		
		int Id = customerId++;
		String cusId = "CUSTOMER_"+Integer.toString(Id);
		
		customer.setFirstName(firstName);
		customer.setLastName(lastName);
		customer.setId(cusId);
		
		return customer;
	}
	
	public Vehicle selectVehicle(List<Vehicle> vehicles)
	{
		System.out.println("which vehicle you would like to rent, select from the above list : ");
		int idx = sc.nextInt();
		idx--;
		int noOfVehicles = vehicles.size();
		Vehicle vehicle = null;
		
		if(idx>=0 && idx<noOfVehicles)
		{
			vehicle = vehicles.get(idx);
		}
		else {
			System.out.println("please enter a valid numer");
		}
		return vehicle;
	}
	
	public LocalDateTime inputTime()
	{
		System.out.println("please enter date time in this format : YYYY-MM-DD'T'HH:mm:ss");
		String dateTime=sc.next();
		LocalDateTime localDateTime = LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss"));
		return localDateTime;
	}
	
	public void printRentedVehicle(List<Rental> rentals)
	{
		for(Rental rental : rentals)
		{
			System.out.println(rental);
		}
	}
	
	public String[] getCustomerName()
	{
		System.out.print("Enter first name : ");
		String firstName = sc.next();
		System.out.print("Enter last name : ");
		String lastName = sc.next();
		
		String[] name = {firstName,lastName};
		return name;
	}
	
	public List<Rental> listOfRentalsAssociatedToCustomer(List<Rental> rentals)
	{
		String[] name = this.getCustomerName();
		List<Rental> listOfRentalsAssociatedWithCustomer = new ArrayList<>();
		for(Rental rental : rentals)
		{
			if(rental.getCustomer().getFirstName().equals(name[0]) && rental.getCustomer().getLastName().equals(name[1]))
			{
				listOfRentalsAssociatedWithCustomer.add(rental);
			}
		}
		return listOfRentalsAssociatedWithCustomer;
	}
}
