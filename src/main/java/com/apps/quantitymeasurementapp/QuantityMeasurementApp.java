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

		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			
			if(obj==null || obj.getClass()!=this.getClass()) {
				return false;
			}
			return Double.compare(this.value, ((FeetEquality)obj).value)==0;
		}
	}
	
	public static class InchEquality{
		private final double value;

		public InchEquality(double value) {
			if(Double.isNaN(value)) {
				throw new IllegalArgumentException("Invalid input!");
			}
			this.value = value;
		}
		
		@Override
		public boolean equals(Object obj) {
			if(this==obj) {
				return true;
			}
			if(obj==null || obj.getClass()!=this.getClass()) {
				return false;
			}
			return Double.compare(this.value, ((InchEquality)obj).value)==0;
		}
	}
	
	public static boolean domonstrateInchEquality() {
		InchEquality inch1 = new InchEquality(23.2);
		InchEquality inch2 = new InchEquality(23.2);
		return inch1.equals(inch2);
	}
	public static boolean domonstrateFeetEquality() {
		FeetEquality feet1 = new FeetEquality(34.2);
		FeetEquality feet2 = new FeetEquality(34.2);
		return feet1.equals(feet2);
	}
	public static void main(String[] args) {
		domonstrateFeetEquality();
		domonstrateInchEquality();
	}
}