package com.apps.quantitymeasurementapp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuantityMeasurementMainTest {

	@Test
	public void testEquality_SameValue()  {
		Feet feet1 = new Feet(10.1);
		Feet feet2 = new Feet(10.1);
		assertTrue(feet1.equals(feet2));
	}
	
	@Test
	public void testEquality_DifferentValue() {
		Feet feet1 = new Feet(10.1);
		Feet feet2 = new Feet(1.1);
		assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testEquality_NullComparison() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = null;
		assertFalse(feet1.equals(feet2));;
	}
	
	@Test
	public void testEquality_NonNumericInput() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new Feet(Double.NaN);
		});
	}
	
	@Test
	public void testEquality_SameReference() {
		Feet feet1 = new Feet(1.0);
		Feet feet2 = feet1;
		assertTrue(feet1.equals(feet2));
	}
}
