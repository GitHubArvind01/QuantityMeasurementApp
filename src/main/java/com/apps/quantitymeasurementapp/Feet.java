package com.apps.quantitymeasurementapp;

public class Feet {

	private final double value;
	
	public Feet(Double value) {
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("Invalid input!");
		}
		this.value = value;
	}
	public Double getValue() {
		return value;
	}
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		return Double.compare(this.value, ((Feet)obj).getValue())==0;
	}
}