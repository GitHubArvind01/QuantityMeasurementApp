package com.apps.quantitymeasurementapp;

public class Length {
	private double value;
	private LengthUnit len;
	
	public enum LengthUnit{
		FEET(12.0),
		INCHES(1.0);
		
		private double conversion;
		
		LengthUnit(double conversion){
			this.conversion = conversion;
		}
		
		public double getConversion() {
			return conversion;
		}
	}
	
	public Length(double value, LengthUnit len) {
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("Invalid value!");
		}
		this.value = value;
		this.len = len;
	}
	
	private double toInches() {
		return this.value*this.len.getConversion();
	}
	
	public boolean compare(Length len) {
		return Double.compare(this.toInches(), len.toInches())==0;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		
		return this.compare((Length)obj);
	}
	
	public static void main(String args[]) {
		Length len1 = new Length(1,Length.LengthUnit.INCHES);
		Length len2 = new Length(1,Length.LengthUnit.INCHES);
		System.out.println(len1.equals(len2));
	}
}
