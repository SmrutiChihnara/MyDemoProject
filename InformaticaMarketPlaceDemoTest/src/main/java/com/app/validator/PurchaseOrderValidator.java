package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.PurchaseOrder;
@Component
public class PurchaseOrderValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return PurchaseOrder.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		PurchaseOrder po=(PurchaseOrder) target;
		
		if(!Pattern.compile("[A-Z]{4,10}").matcher(po.getOrderCode()).matches()) {
			errors.rejectValue("orderCode",null,"Enter Valid Code[4 to 10 Uppercase letter]");
		}
		if(po.getShipmentcode()==null||po.getShipmentcode().getShipmentTypeId()==null) {
			errors.rejectValue("shipmentcode",null,"Please Choose One");
		}
		if(po.getVendor()==null||po.getVendor().getUserId()==null) {
			errors.rejectValue("vendor",null,"Please Choose One");
		}
		
		if("".equals(po.getReferenceNo())) {
			errors.rejectValue("referenceNo",null,"Enter Valid Ref No");
		}
		if(po.getQualityCheck()==null||"".equals(po.getQualityCheck())) {
			errors.rejectValue("qualityCheck",null,"Please Choose One");
		}
		if("".equals(po.getDsc())) {
			errors.rejectValue("dsc",null,"Please Enter Description");
		}

	}

}
