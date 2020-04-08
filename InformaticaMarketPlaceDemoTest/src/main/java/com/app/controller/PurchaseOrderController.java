package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.PurchaseOrder;
import com.app.model.ShipmentType;
import com.app.model.WhUserType;
import com.app.service.IPurchaseOrderService;
import com.app.service.IShipmentTypeService;
import com.app.service.IWhUserTypeService;
import com.app.util.PurchaseOrderUtil;
import com.app.validator.PurchaseOrderValidator;

@Controller
@RequestMapping("/po")
public class PurchaseOrderController {
	@Autowired
	private IPurchaseOrderService service;
	@Autowired
	private IShipmentTypeService stservice;
	@Autowired
	private PurchaseOrderValidator validator;
	@Autowired
	private IWhUserTypeService venService;
	@Autowired
	private PurchaseOrderUtil util;
	
	@RequestMapping("/create")
	public String showOrderPage(ModelMap map) {
		util.addUiComponents(map);
		List<ShipmentType> sTypes=stservice.getShipmentTypes("Yes");
		map.addAttribute("sTypes",sTypes);
		List<WhUserType> userTypes=venService.getWhUserTypeByType("Vendor");
		map.addAttribute("userTypes",userTypes);
		map.addAttribute("po",new PurchaseOrder());
		return "PurchaseOrderCreate";
	}
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveData(@ModelAttribute("po") PurchaseOrder po,Errors errors,ModelMap map) {
		validator.validate(po, errors);
		if(!errors.hasErrors()) {
			Integer poId=service.savePurchaseOrder(po);
			String msg="PurchaseOrder '"+poId+"' saved";
			map.addAttribute("po",new PurchaseOrder());
			map.addAttribute("message",msg);
			List<ShipmentType> sTypes=stservice.getShipmentTypes("Yes");
			map.addAttribute("sTypes",sTypes);
			List<WhUserType> userTypes=venService.getWhUserTypeByType("Vendor");
			map.addAttribute("userTypes",userTypes);
		}
		util.addUiComponents(map);
		return "PurchaseOrderCreate";
	}
	@RequestMapping("/all")
	public String showData(ModelMap map) {
		List<PurchaseOrder> pos=service.getAllPurchaseOrder();
		map.addAttribute("list",pos);
		return "PurchaseOrderData";
	}
	@RequestMapping("/delete")
	public String deletePurchaseOrder(@RequestParam("id")Integer poId,ModelMap map) {
		service.deletePurchaseOrder(poId);
		String msg="PurchaseOrder '"+poId+"' deleted";
		List<PurchaseOrder> pos=service.getAllPurchaseOrder();
		map.addAttribute("list",pos);
		map.addAttribute("message",msg);
		return "PurchaseOrderData";
	}
	@RequestMapping("/edit")
	public String showEdit(@RequestParam("id")Integer poId,ModelMap map) {
		PurchaseOrder po=service.getOnePurchaseOrder(poId);
		map.addAttribute("po",po);
		List<ShipmentType> sTypes=stservice.getShipmentTypes("Yes");
		map.addAttribute("sTypes",sTypes);
		List<WhUserType> userTypes=venService.getWhUserTypeByType("Vendor");
		map.addAttribute("userTypes",userTypes);
		util.addUiComponents(map);
		return "PurchaseOrderEdit";
	}
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateData(@ModelAttribute PurchaseOrder po,Errors errors,ModelMap map) {
		validator.validate(po, errors);
		if(!errors.hasErrors()) {
		service.updatePurchaseOrder(po);
		String msg="PurchaseOrder '"+po.getPoId()+"' updated";
		List<PurchaseOrder> pos=service.getAllPurchaseOrder();
		map.addAttribute("list",pos);
		map.addAttribute("message",msg);
		}
		return "PurchaseOrderData";
	}

}
