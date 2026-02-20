package com.apps.quantitymeasurementapp;
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.FeetEquality; 
import com.apps.quantitymeasurementapp.QuantityMeasurementApp.InchEquality;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class QuantityMeasurementMainTest {
	
	Length len1;
	Length len2;
	
	//Feet
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
	
	//Inch

	@Test
	public void testInchEquality_SameValue()  {
		InchEquality Inch1 = new InchEquality(10.1);
		InchEquality Inch2 = new InchEquality(10.1);
		assertTrue(Inch1.equals(Inch2));
	}
	
	@Test
	public void testInchEquality_DifferentValue() {
		InchEquality Inch1 = new InchEquality(10.1);
		InchEquality Inch2 = new InchEquality(1.1);
		assertFalse(Inch1.equals(Inch2));
	}

	@Test
	public void testInchEquality_NullComparison() {
		InchEquality Inch1 = new InchEquality(1.0);
		InchEquality Inch2 = null;
		assertFalse(Inch1.equals(Inch2));;
	}
	
	@Test
	public void testInchEquality_NonNumericInput() {
		assertThrows(IllegalArgumentException.class, ()-> {
			new InchEquality(Double.NaN);
		});
	}
	
	@Test
	public void testInchEquality_SameReference() {
		InchEquality Inch1 = new InchEquality(1.0);
		InchEquality Inch2 = Inch1;
		assertTrue(Inch1.equals(Inch2));
	}
	
	//Length
	@Test
	public void testFeetEquality() {
		len1 = new Length(1,Length.LengthUnit.FEET);
		len2 = new Length(1,Length.LengthUnit.FEET);
		assertTrue(len1.equals(len1));
	}
	
	@Test
	public void testInchEquality() {
		len1 = new Length(11,Length.LengthUnit.INCHES);
		len2 = new Length(11,Length.LengthUnit.INCHES);
		assertTrue(len1.equals(len1));
	}
	
	@Test
	public void testFeetInchesComparison() {
		len1 = new Length(1,Length.LengthUnit.FEET);
		len2 = new Length(12,Length.LengthUnit.INCHES);
		assertTrue(len1.equals(len1));
	}
	
	@ParameterizedTest
	@ValueSource(doubles = {1,2,3,4})
	public void testMultipleFeetComparison(double feet) {
		len1 = new Length(feet,Length.LengthUnit.FEET);
		len2 = new Length(feet*12,Length.LengthUnit.INCHES);
		assertTrue(len1.equals(len1));
	}
}
