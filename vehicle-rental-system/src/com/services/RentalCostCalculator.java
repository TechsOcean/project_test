package com.services;

import java.math.BigDecimal;

import com.main.Rental;

public interface RentalCostCalculator {
	BigDecimal calculateRentalCost(Rental rental);
}
