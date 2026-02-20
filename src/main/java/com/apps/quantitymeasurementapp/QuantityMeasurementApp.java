package com.apps.quantitymeasurementapp;

public class QuantityMeasurementApp {
	

	public static class FeetEquality {

		private final double value;
		
		public FeetEquality(Double value) {
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
			return Double.compare(this.value, ((FeetEquality)obj).getValue())==0;
		}
	}
	
	public static void main(String[] args) {
		FeetEquality feet1 = new FeetEquality(23.2);
		FeetEquality feet2 = new FeetEquality(23.2);
		System.out.println(feet1.equals(feet2));
	}
}