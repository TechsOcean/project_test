package com.main;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import com.services.Vehicle;
import com.services.impl.RentalService;

public class VehicleMainApplication {
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
		VehicleServices vehicleService = new VehicleServices();
		RentalService rentalService = new RentalService();
		
		int choice = -1;
		do {
			System.out.println("1. Add Vehicle");
			System.out.println("2. List Of Availale Vehicles");
			System.out.println("3. Rent a Vehicle");
			System.out.println("4. Show Rented Vechicle");
			System.out.println("5. Return Vehicle and pay");
			System.out.println("6. Exit");
			
			try {
				System.out.print("Enter your choice : ");
				choice = sc.nextInt();
			}
			catch(InputMismatchException exc)
			{
				System.out.println("please select a valid number...");
			}
			
			switch(choice)
			{
			//add a vehicle;
			case 1:
				Vehicle vehicle = vehicleService.selectVehicle();
				vehicle = vehicleService.inputVehicleDetails(vehicle);
				rentalService.addVehicle(vehicle);
				break;
			
			//list of available vehicles;
			case 2:
				List<Vehicle> listOfAvailableVehicles = rentalService.listOfAvailableVehicles();
				vehicleService.printAvailableVehicle(listOfAvailableVehicles);
				break;
				
			//rent a vehicle;
			case 3:
				//selecting the vehicle object from the listOfAvailableVehicles;
				List<Vehicle> listOfAvailableVehicles2 = rentalService.listOfAvailableVehicles();
				if(listOfAvailableVehicles2.isEmpty())
				{
					System.out.println("no vehicle available for rent");
					break;
				}
				vehicleService.printAvailableVehicle(listOfAvailableVehicles2);
				Vehicle selectedVehicle = vehicleService.selectVehicle(listOfAvailableVehicles2);
				selectedVehicle.setAvailable(false);
				
				//creating a customer object
				Customer customer2 = vehicleService.inputCustomerDetails();
				
				//inputing start time;
				System.out.println("start from time");
				LocalDateTime startDateTime = vehicleService.inputTime();
				
				//inputing return time;
				System.out.println("return time");
				LocalDateTime endDateTime = vehicleService.inputTime();
				
				rentalService.rentVehicle(customer2, selectedVehicle, startDateTime, endDateTime);
				break;
			
			//show  rented vehicles;
			case 4:
				List<Rental> listOfRentals = rentalService.listOfRentals();
				if(listOfRentals.isEmpty())
				{
					System.out.println("no vehicle is rented yet.");
					break;
				}
				vehicleService.printRentedVehicle(listOfRentals);
				break;
			
			//return a vehicle;
			case 5:
				List<Rental> listOfRentals2= rentalService.listOfRentals(); 
				List<Rental> listOfRentalsAssociatedWithCustomer = vehicleService.listOfRentalsAssociatedToCustomer(listOfRentals2);
				if(listOfRentalsAssociatedWithCustomer.isEmpty())
				{
					System.out.println("you haven't rented any vehicle yet.");
					break;
				}
				int i=0;
				for(Rental rental : listOfRentalsAssociatedWithCustomer) 
				{
					System.out.println(++i +".) "+rental);
				}
				System.out.print("enter choice : ");
				int choice2 = sc.nextInt();
				Rental selectedRental = listOfRentalsAssociatedWithCustomer.get(choice2-1);
				rentalService.returnVehicle(selectedRental);
				break;
				
			//clean up code, and exit message.
			case 6:
				sc.close();
				System.out.println("Visit again!!");
				break;
				
			default:
				System.out.println("Enter a valid choice");
				break;
			}
			System.out.println("------------------------------------------------------------------------");
			System.out.println("");
		}
		while(choice>0 && choice<=6);
	}
}
