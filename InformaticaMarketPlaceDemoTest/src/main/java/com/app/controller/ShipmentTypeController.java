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
import org.springframework.web.servlet.ModelAndView;

import com.app.model.ShipmentType;
import com.app.service.IShipmentTypeService;
import com.app.validator.ShipmentTypeValidator;
import com.app.view.ShipmentTypeExcelView;
import com.app.view.ShipmentTypePdfView;

@Controller
@RequestMapping("/shipmenttype")
public class ShipmentTypeController {
	@Autowired
	private IShipmentTypeService service;
	@Autowired
	private ShipmentTypeValidator validator;
	
	//1 show create page
	@RequestMapping("/create")
	public String showCreatePage(ModelMap map) {
		map.addAttribute("sType",new ShipmentType());
		return "ShipmentTypeCreate";
	}
	
	//2 onclick ons ubmit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveShipmentTypeData(@ModelAttribute("sType") ShipmentType sType,Errors errors,ModelMap map) {
		validator.validate(sType, errors);
		if(!errors.hasErrors()) {
		Integer shipmentTypeId=service.saveShipmentType(sType);
		String msg="Shipment Type '"+shipmentTypeId+"' saved";
		map.addAttribute("sType", new ShipmentType());
		map.addAttribute("message",msg);
		}
		return "ShipmentTypeCreate";
	}
	
	//3 get data from db to ui
	@RequestMapping("/all")
	public String showShipmentData(ModelMap map) {
		List<ShipmentType> sTypes=service.getAllShipmentTypes();
		map.addAttribute("list",sTypes);
		return "ShipmentTypeData";
	}
	
	//4 delete Shipment by id
	@RequestMapping("/delete")
	public String deleteShipmentType(@RequestParam("id")Integer shipmentTypeId,ModelMap map) {
		service.deleteShipmentType(shipmentTypeId);
		String msg="Shipment Type '"+shipmentTypeId+"' deleted";
		List<ShipmentType> sTypes=service.getAllShipmentTypes();
		map.addAttribute("list",sTypes);
		map.addAttribute("message",msg);
		return "ShipmentTypeData";
	}
	
	//5 show edit page
	@RequestMapping("/edit")
	public String showShipmentEdit(@RequestParam("id")Integer shipmentTypeId,ModelMap map) {
		ShipmentType sType=service.getOneShipmentType(shipmentTypeId);
		map.addAttribute("sType", sType);	
		return "ShipmentTypeEdit";
	}
	
	//6 do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateShipment(@ModelAttribute ShipmentType sType,ModelMap map) {
		service.updateShipmentType(sType);
		String msg="Shipment Type '"+sType.getShipmentTypeId()+"' Updated";
		List<ShipmentType> sTypes=service.getAllShipmentTypes();
		map.addAttribute("list", sTypes);
		map.addAttribute("message", msg);
		return "ShipmentTypeData";
	}
	
	//7 export to excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<ShipmentType> sTypes=service.getAllShipmentTypes();
		ModelAndView mav=new ModelAndView();
		mav.setView(new ShipmentTypeExcelView());
		mav.addObject("sTypes", sTypes);
		return mav;
	}
	
	//8 export to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<ShipmentType> sTypes=service.getAllShipmentTypes();
		ModelAndView mav=new ModelAndView();
		mav.setView(new ShipmentTypePdfView());
		mav.addObject("sTypes", sTypes);
		return mav;
	}

}
