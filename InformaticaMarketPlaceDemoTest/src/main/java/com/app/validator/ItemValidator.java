package com.app.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.app.model.Item;

@Component
public class ItemValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return Item.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Item item=(Item) target;
		
		if(!Pattern.compile("[A-Z]{4,8}").matcher(item.getItemCode()).matches()) {
			errors.rejectValue("itemCode", null, "Enter Valid code(4 to 8 Uppercase only)");
		}

		if(item.getItemLen() <= 0 || item.getItemHght() <= 0 || item.getItemWdth() <= 0) {
			errors.rejectValue("itemLen", null, "Enter Valid dimensions");
		}
		if(item.getBaseCost() <= 0 ) {
			errors.rejectValue("baseCost", null, "Enter Valid Base Cost");
		}
		
		if("".equals(item.getBaseCurrecy())) {
			errors.rejectValue("baseCurrecy", null, "Please choose Currency");
		}
		
		if(item.getUom() == null || item.getUom().getUomId() ==null) {
			errors.rejectValue("uom", null, "Please choose one Uom");
		}
		
		if(item.getSaleType() == null || item.getSaleType().getOrderId() ==null) {
			errors.rejectValue("saleType", null, "Please choose one Sale Type");
		}
		
		if(item.getPurchaseType() == null || item.getPurchaseType().getOrderId() ==null) {
			errors.rejectValue("purchaseType", null, "Please choose one Purchase Type");
		}
		
		if(item.getVenUsers() == null || item.getVenUsers().isEmpty()) {
			errors.rejectValue("venUsers", null, "Please choose atleast one Vendor");
		}
		
		if(item.getCustUsers() == null || item.getCustUsers().isEmpty()) {
			errors.rejectValue("custUsers", null, "Please choose one Customer");
		}
		

		if("".equals(item.getItemDsc().trim())) {
			errors.rejectValue("itemDsc", null, "Please enter Description");
		}
	}
}












