package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.ShipmentType;
@Component
public class ShipmentTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return ShipmentType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		ShipmentType shipmentType=(ShipmentType) target;
		
		if("".equals(shipmentType.getShipmentTypeMode())) {
			errors.rejectValue("shipmentTypeMode",null,"Please Select One Model");
		}
		if(!Pattern.compile("[A-Z]{3,7}").matcher(shipmentType.getShipmentTypeCode()).matches()) {
			errors.rejectValue("shipmentTypeCode",null,"Enter Valid Code[3 to 7 Uppercase letter only]");
		}
		if(shipmentType.getEnableShipment()==null||"".equals(shipmentType.getEnableShipment())) {
			errors.rejectValue("enableShipment",null,"Please Choose");
		}
		if(shipmentType.getGrade()==null||"".equals(shipmentType.getGrade())) {
			errors.rejectValue("grade",null,"Please Choose One Grade");
		}
		if("".equals(shipmentType.getDsc())) {
			errors.rejectValue("dsc",null,"Please Enter Description");
		}

	}

}
