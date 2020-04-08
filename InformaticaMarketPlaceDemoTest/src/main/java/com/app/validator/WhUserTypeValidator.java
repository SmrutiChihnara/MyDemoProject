package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.WhUserType;
@Component
public class WhUserTypeValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return WhUserType.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		WhUserType userType=(WhUserType) target;
		
		if(userType.getUserType()== null || "".equals(userType.getUserType())) {
			errors.rejectValue("userType", null,"Please choose one User Type");
		}
		
		if(!Pattern.compile("[A-Z]{4,6}").matcher(userType.getUserCode()).matches()) {
			errors.rejectValue("userCode", null,"Please Enter Valid User code");
		}
		
		if(!Pattern.compile("[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}").matcher(userType.getUserEmail()).matches()) {
			errors.rejectValue("userEmail", null,"Please Enter Valid Email");
		}
		if(!Pattern.compile("((\\+){1}91){1}[1-9]{1}[0-9]{9}").matcher(userType.getUsercontact()).matches()) {
			errors.rejectValue("usercontact", null,"Please Enter Valid Contact");
		}
	
		if("".equals(userType.getIdType())) {
			errors.rejectValue("idType", null,"Please choose one User Id Type");
		}else if("OTHER".equals(userType.getIdType()) && "".equals(userType.getIfOther())) {
			errors.rejectValue("ifOther", null,"Please Enter Other Type");
		}
		if("".equals(userType.getIdNum())) {
			errors.rejectValue("idNum", null,"Please Enter User Id");
		}

	}

}
