package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Uom;
@Component
public class UomValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Uom.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Uom uom=(Uom)target;
		
		if("".equals(uom.getUomType())) {
			errors.rejectValue("uomType", null, "Please choose one Type");
		}
		if(!Pattern.compile("[A-Z]{4,10}").matcher(uom.getUomModel()).matches()) {
			errors.rejectValue("uomModel",null,"Enter Valid Model[4 to 10 Uppercase letter only]");
		}
		if("".equals(uom.getDsc().trim())) {
			errors.rejectValue("dsc",null,"Please Enter Description");
		}

	}

}
