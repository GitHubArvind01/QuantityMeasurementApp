package com.apps.quantitymeasurementapp.controller;

import com.apps.quantitymeasurementapp.entity.QuantityDTO;
import com.apps.quantitymeasurementapp.service.IQuantityMeasurementService;
import com.apps.quantitymeasurementapp.service.QuantityMeasurementServiceImpl;

public class QuantityMeasurementController {

	private IQuantityMeasurementService quantityMeasurementService;

	public QuantityMeasurementController(QuantityMeasurementServiceImpl quantityMeasurementService) {
		this.quantityMeasurementService = quantityMeasurementService;
	}

	public QuantityDTO performAddition(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
		return quantityMeasurementService.add(thisQuantityDTO, thatQuantityDTO);
	}
}