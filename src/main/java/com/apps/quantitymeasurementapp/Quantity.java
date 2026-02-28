package com.apps.quantitymeasurementapp;

import java.util.function.DoubleBinaryOperator;

public class Quantity<U extends IMeasurable> {
	private double value;
	private U unit;
	
	public Quantity(double value, U unit) {
		if(Double.isNaN(value)) {
			throw new IllegalArgumentException("Nan value!");
		}
		if(unit==null) {
			throw new IllegalArgumentException("Nan value!");			
		}
		this.value = value;
		this.unit = unit;
	}

	public double getValue() {
		return value;
	}

	public U getUnit() {
		return unit;
	}
	
	public double convertTo(U targetUnit) {
		//convert to base unit
		double baseUnit = this.unit.convertToBaseUnit(value);
		//convert to target unit
		double targetUnits = targetUnit.convertFromBaseUnit(baseUnit);
		return targetUnits;
		
	}
	
	//add
	public Quantity<U> add(Quantity<U> other){
		this.validateArithmeticOperands(other, null, false);
		double part1 = this.convertTo(this.unit);
		double part2 = other.convertTo(this.unit);
		return new Quantity<>((part1+part2),this.unit);
	}
	//add with target unit
	public Quantity<U> add(Quantity<U> other, U targetUnit){
		double part1 = this.convertTo(targetUnit);
		double part2 = other.convertTo(targetUnit);
		return new Quantity<>((part1+part2),targetUnit);
	}
	
	//subtract method
	public Quantity<U> subtract(Quantity<U> other){
		this.validateArithmeticOperands(other, null, false);
		double part1 = this.unit.convertToBaseUnit(this.value);
		double part2 = other.unit.convertToBaseUnit(other.value);
		
		double baseResult = part1-part2;
		double finalResult = this.unit.convertFromBaseUnit(baseResult);
		return new Quantity<>(finalResult,this.unit);
	}
	
	//subtract method for specific unit
	public Quantity<U> subtract(Quantity<U> other, U targetUnit){
		double part1 = this.unit.convertToBaseUnit(this.value);
		double part2 = other.unit.convertToBaseUnit(other.value);
		
		double baseResult = part1-part2;
		double finalResult = targetUnit.convertFromBaseUnit(baseResult);
		return new Quantity<>(finalResult,targetUnit);
	}
	
	//division
	public double divide(Quantity<U> other){
		this.validateArithmeticOperands(other, null, false);
		double part1 = this.unit.convertToBaseUnit(this.value);
		double part2 = other.unit.convertToBaseUnit(other.value);
		if (part2 == 0) {
	        throw new ArithmeticException("Cannot divide by zero");
		}
		double baseResult = part1/part2;
		return baseResult;
	}
	
	//equals
	@Override
	public boolean equals(Object obj) {
		if(this==obj) {
			return true;
		}
		
		if(obj==null || obj.getClass()!=this.getClass()) {
			return false;
		}
		
		// Generic cast (Suppressed warning because we checked getClass() above)
	    @SuppressWarnings("unchecked")
	    Quantity<U> other = (Quantity<U>) obj;

	    // Conversion Logic: Convert both to their Base Unit for comparison
	    double baseValue1 = this.unit.convertToBaseUnit(this.value);
	    double baseValue2 = other.unit.convertToBaseUnit(other.value);

	    // Value comparison with a small delta for double precision errors
	    return Math.abs(baseValue1 - baseValue2) < 0.0001;
	}
	
	@Override
	public String toString() {
		return "Quantity [value=" + value + ", unit=" + unit + "]";
	}
	private void validateArithmeticOperands(Quantity<U> other, U targetUnit, boolean targetUnitRequired) {
		if (other == null)
            throw new IllegalArgumentException("Operand cannot be null");

        if (this.unit.getClass() != other.unit.getClass())
            throw new IllegalArgumentException("Incompatible unit categories");

        if (!Double.isFinite(this.value) || !Double.isFinite(other.value))
            throw new IllegalArgumentException("Values must be finite");

        if (targetUnitRequired && targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");
	}
	
	private double performBaseArithmetic(Quantity<U> other,  ArithmeticOperation operation) {
		double temp = other.convertTo(this.getUnit());
    	double result = operation.compute(this.getValue(),temp);
    	return result;
	}
	private enum ArithmeticOperation{
		ADD((a,b)-> a+b),
		SUBTRACT((a,b)-> a-b),
		DIVIDE((a,b)-> {
			if(b==0)throw new ArithmeticException();
			return a/b;
		});
		
		private final DoubleBinaryOperator operation;
		
		ArithmeticOperation(DoubleBinaryOperator operation) {
			this.operation = operation;
		}
		
		public double compute(double thisBase, double otherBase) {
			return operation.applyAsDouble(thisBase, otherBase);
		}
	}
}
