package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.OrderMethod;
@Component
public class OrderMethodValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return OrderMethod.class.equals(clazz);
	}

	
	@Override
	public void validate(Object target, Errors errors) {
		OrderMethod orMethod=(OrderMethod) target;
		
		if(orMethod.getOrderMode()==null||"".equals(orMethod.getOrderMode())) {
			errors.rejectValue("orderMode",null,"Please Choose One Mode");
		}
		if(!Pattern.compile("[A-Z]{3,7}").matcher(orMethod.getOrderCode()).matches()) {
			errors.rejectValue("orderCode",null,"Enter Valid Code[3 to 7 Uppercase letter only]");
		}
		if("".equals(orMethod.getOrderMethod())) {
			errors.rejectValue("orderMethod",null,"Please Choose One Method");
		}
		if(orMethod.getOrderAccept()==null||orMethod.getOrderAccept().isEmpty()) {
			errors.rejectValue("orderAccept",null,"Please Choose atleast One Option");
		}
		if("".equals(orMethod.getDsc())) {
			errors.rejectValue("dsc",null,"Please Enter Description");
		}
		
	}
}
