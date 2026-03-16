package com.app.quantitymeasurementapp;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import com.app.quantitymeasurementapp.controller.QuantityMeasurementController;
import com.app.quantitymeasurementapp.entity.QuantityDTO;
import com.app.quantitymeasurementapp.entity.QuantityModel;
import com.app.quantitymeasurementapp.exception.CategoryMismatchException;
import com.app.quantitymeasurementapp.exception.QuantityMeasurementException;
import com.app.quantitymeasurementapp.unit.IMeasurable;
import com.app.quantitymeasurementapp.unit.LengthUnit;
import com.app.quantitymeasurementapp.unit.VolumeUnit;
import com.app.quantitymeasurementapp.unit.WeightUnit;

public class QuantityMeasurementAppTest {
	
}