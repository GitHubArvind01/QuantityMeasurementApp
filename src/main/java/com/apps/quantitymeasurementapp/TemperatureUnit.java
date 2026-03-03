package com.apps.quantitymeasurementapp;

import java.util.function.Function;

public enum TemperatureUnit implements IMeasurable{
	CELISUS(false),
	FAHRENHEIT(true);
	private boolean isFahrenheit;
	
	//function for FAHRENHEIT to CELISUS 
	final Function<Double, Double> FAHRENHEIT_TO_CELISUS = (fahrenheit)-> (fahrenheit-30)*5/9;
	final Function<Double, Double> CELISUS_TO_CELISUS = (celisus)-> celisus;
	
	Function<Double,Double> conversionValue;
	
	SupportsArithmetic supportsArithmetic = ()-> false;
	
	TemperatureUnit(boolean isFahrenheit){
		this.isFahrenheit = isFahrenheit;
	}
	
	public boolean getFahrenheit() {
		return isFahrenheit;
	}

	@Override
	public double getConversionFactor() {
		return 1.0;
	}

	@Override
	public double convertToBaseUnit(double value) {
		return conversionValue.apply(value);
	}

	@Override
	public double convertFromBaseUnit(double baseValue) {
		return 0;
	}

	@Override
	public String getUnitName() {
		return this.getUnitName();
	}	
	
	public boolean supportsArithmetic() {
		return supportsArithmetic.isSupported();
	}
	
	@Override
	public void validateOperationSupport(String operation) {
		if(!supportsArithmetic.isSupported()) {
			String message = this.name()+" does not support "+operation+" operations!";
			throw new UnsupportedOperationException(message);
		}
	}
	public static void main(String args[]) {
		
	}
}