package com.apps.quantitymeasurementapp.service;

import com.apps.quantitymeasurementapp.entity.QuantityDTO;
import com.apps.quantitymeasurementapp.entity.QuantityMeasurementEntity;
import com.apps.quantitymeasurementapp.entity.QuantityModel;
import com.apps.quantitymeasurementapp.quantity.Quantity;
import com.apps.quantitymeasurementapp.repository.IQuantityMeasurementRepository;
import com.apps.quantitymeasurementapp.unit.IMeasurable;
import com.apps.quantitymeasurementapp.unit.LengthUnit;
import com.apps.quantitymeasurementapp.unit.TemperatureUnit;
import com.apps.quantitymeasurementapp.unit.VolumeUnit;
import com.apps.quantitymeasurementapp.unit.WeightUnit;

public class QuantityMeasurementServiceImpl implements IQuantityMeasurementService{
	
	private IQuantityMeasurementRepository repository;
	
	//constructor
	public QuantityMeasurementServiceImpl(IQuantityMeasurementRepository repository) {
		this.repository = repository;
	}

	@Override
	public boolean compare(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
		
        return true;
	}
	
	@Override
	public QuantityDTO convert(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
		return null;
	}

	@Override
	public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
		 // 1. Convert QuantityDTO instances to QuantityModel instances (Mapping Strings to Objects)
        QuantityModel<IMeasurable> model1 = mapToModel(thisQuantityDTO);
        QuantityModel<IMeasurable> model2 = mapToModel(thatQuantityDTO);

        // 2. Validate operands (non-null, same category, finite)
        validateModels(model1, model2);

        // 3. Create Quantity<IMeasurable> objects from the QuantityModel instances
        // This is where the business logic from UC14 resides
        Quantity<IMeasurable> q1 = new Quantity<>(model1.getValue(), model1.getUnit());
        Quantity<IMeasurable> q2 = new Quantity<>(model2.getValue(), model2.getUnit());

        // 4. Call q1.add(q2)
        Quantity<IMeasurable> resultQuantity = q1.add(q2);

        // 5. Extract result value and unit
        double resultValue = resultQuantity.getValue();
        String resultUnitName = resultQuantity.getUnit().toString();

        // 6. Store in repository as QuantityMeasurementEntity
        QuantityMeasurementEntity entity = new QuantityMeasurementEntity(
        		thisQuantityDTO.getValue(), 
        		thisQuantityDTO.getUnit(), 
        		thisQuantityDTO.getMeasurementType(),
        		thatQuantityDTO.getValue(), 
        		thatQuantityDTO.getUnit(), 
        		thatQuantityDTO.getMeasurementType(),
                "ADD",
                resultValue, resultUnitName, thisQuantityDTO.getMeasurementType()
        );
        repository.save(entity);

        // 7. Return new QuantityDTO for the response
        return new QuantityDTO(resultValue, resultUnitName, thisQuantityDTO.getMeasurementType());
	}

	@Override
	public QuantityDTO add(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
		return null;
	}

	@Override
	public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
		return null;
	}

	@Override
	public QuantityDTO subtract(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO, QuantityDTO targetUnitDTO) {
		return null;
	}

	@Override
	public QuantityDTO divide(QuantityDTO thisQuantityDTO, QuantityDTO thatQuantityDTO) {
		return null;
	}
	
	  /**
     * Helper to map DTO (Strings) to Model (Actual Unit Enums)
     */
    private QuantityModel<IMeasurable> mapToModel(QuantityDTO dto) {
        String type = dto.getMeasurementType().toUpperCase();
        String unitName = dto.getUnit().toUpperCase();
        IMeasurable unit;

        switch (type) {
            case "LENGTH": unit = LengthUnit.valueOf(unitName); break;
            case "VOLUME": unit = VolumeUnit.valueOf(unitName); break;
            case "WEIGHT": unit = WeightUnit.valueOf(unitName); break;
            case "TEMPERATURE": unit = TemperatureUnit.valueOf(unitName); break;
            default: throw new IllegalArgumentException("Unknown Measurement Type: " + type);
        }
        return new QuantityModel<>(dto.getValue(), unit);
    }
    

    /**
     * Validation logic as requested in the flow diagram
     */
    private void validateModels(QuantityModel<?> m1, QuantityModel<?> m2) {
        if (m1 == null || m2 == null) 
            throw new IllegalArgumentException("Operands cannot be null");
        
        if (m1.getUnit().getClass() != m2.getUnit().getClass())
            throw new IllegalArgumentException("Cannot perform operation on different categories");

        if (!Double.isFinite(m1.getValue()) || !Double.isFinite(m2.getValue()))
            throw new IllegalArgumentException("Values must be finite");
    }
}