package com.app.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;

import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
@Component
public class PurchaseOrderUtil {
	@Autowired
	private IShipmentTypeService stservice;
	@Autowired
	private IWhUserTypeService venService;
	
	public void addUiComponents(ModelMap map) {
		List<ShipmentType> sTypes=stservice.getShipmentTypes("Yes");
		map.addAttribute("sTypes",sTypes);
		
		List<WhUserType> userTypes=venService.getWhUserTypeByType("Vendor");
		map.addAttribute("userTypes",userTypes);
	}

}
