package com.apps.quantitymeasurementapp;
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.FeetEquality;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QuantityMeasurementMainTest {

	@Test
	public void testFeetEquality_SameValue()  {
		FeetEquality feet1 = new FeetEquality(10.1);
		FeetEquality feet2 = new FeetEquality(10.1);
		assertTrue(feet1.equals(feet2));
	}
	
	@Test
	public void testFeetEquality_DifferentValue() {
		FeetEquality feet1 = new FeetEquality(10.1);
		FeetEquality feet2 = new FeetEquality(1.1);
		assertFalse(feet1.equals(feet2));
	}

	@Test
	public void testFeetEquality_NullComparison() {
		FeetEquality feet1 = new FeetEquality(1.0);
		FeetEquality feet2 = null;
		assertFalse(feet1.equals(feet2));;
	}
	
	@Test
	public void testFeetEquality_NonNumericInput() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new FeetEquality(Double.NaN);
		});
	}
	
	@Test
	public void testFeetEquality_SameReference() {
		FeetEquality feet1 = new FeetEquality(1.0);
		FeetEquality feet2 = feet1;
		assertTrue(feet1.equals(feet2));
	}
}
