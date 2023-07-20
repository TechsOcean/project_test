package com.services;

public abstract class Vehicle implements VechicleOperations {
	private String vehicleType;
	private String licensePlate;
    private String make;
    private String model;
    private boolean isAvailable;
    private int costPerHour;
    

	//abstract method to test which subclass object is created.
    public abstract void pingHello();
    
	@Override
	public boolean isAvailable() {
		return this.isAvailable;
	}
	
	@Override
	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	
	@Override
	public String toString() {
		return "Vehicle [vehicleType=" + vehicleType + ", licensePlate=" + licensePlate + ", make=" + make + ", model="
				+ model + ", costPerHour=" + costPerHour + "]";
	}
	
	
	//Getters and setters;
	public String getLicensePlate() {
		return licensePlate;
	}
	public void setLicensePlate(String licensePlate) {
		this.licensePlate = licensePlate;
	}
	public String getMake() {
		return make;
	}
	public void setMake(String make) {
		this.make = make;
	}
	public String getModel() {
		return model;
	}
	public void setModel(String model) {
		this.model = model;
	}
	public int getCostPerHour() {
		return costPerHour;
	}
	public void setCostPerHour(int costPerHour) {
		this.costPerHour = costPerHour;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public void setVehicleType(String vehicleType) {
		this.vehicleType = vehicleType;
	}
}
