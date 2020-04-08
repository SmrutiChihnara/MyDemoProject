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

import com.app.model.WhUserType;
import com.app.service.IWhUserTypeService;
import com.app.validator.WhUserTypeValidator;
import com.app.view.WhUserTypeExcelView;
import com.app.view.WhUserTypePdfView;

@Controller
@RequestMapping("/whuser")
public class WhUserTypeController {
	@Autowired
	private IWhUserTypeService service;
	@Autowired
	private WhUserTypeValidator validator; 
	//1 to show create user page
	@RequestMapping("/create")
	public String showCreateUser(ModelMap map) {
		map.addAttribute("userType", new WhUserType());
		return "WhUserCreate";
	}
	
	//2 onclick on submit button
	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public String saveUserData(@ModelAttribute("userType") WhUserType userType,Errors errors,ModelMap map) {
		validator.validate(userType, errors);
		if(!errors.hasErrors()) {
		Integer userId=service.saveWhUser(userType);
		String msg="Wh User '"+userId+"' saved";
		map.addAttribute("userType", new WhUserType());
		map.addAttribute("message", msg);
		}
		return "WhUserCreate";
	}
	
	//3 get data from db to ui
	@RequestMapping("/all")
	public String showUserData(ModelMap map) {
		List<WhUserType> userTypes=service.getAllWhUsers();
		map.addAttribute("list",userTypes);
		return "WhUserData";
	}
	
	//4 delete whuser by id
	@RequestMapping("/delete")
	public String deleteUser(@RequestParam("id")Integer userId,ModelMap map) {
		service.deleteWhUser(userId);
		String msg="Wh User '"+userId+"' deleted";
		List<WhUserType> userTypes=service.getAllWhUsers();
		map.addAttribute("list", userTypes);
		map.addAttribute("message",msg);
		return "WhUserData";
	}
	
	//5 show edit page
	@RequestMapping("/edit")
	public String showUserEdit(@RequestParam("id")Integer userId,ModelMap map) {
		WhUserType userType=service.getOneWhUser(userId);
		map.addAttribute("whuser", userType);
		return "WhUserEdit";
	}
	
	//6 do update operation
	@RequestMapping(value="/update",method=RequestMethod.POST)
	public String doUpdateUserData(@ModelAttribute WhUserType userType,ModelMap map) {
		service.updateWhUser(userType);
		String msg="Wh User '"+userType.getUserId()+"' Updated";
		List<WhUserType> userTypes=service.getAllWhUsers();
		map.addAttribute("list", userTypes);
		map.addAttribute("message", msg);
		return "WhUserData";
	}
	
	//7 export to excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<WhUserType> userTypes=service.getAllWhUsers();
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypeExcelView());
		mav.addObject("userTypes",userTypes);
		return mav;
	}
	
	//8 export to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<WhUserType> userTypes=service.getAllWhUsers();
		ModelAndView mav=new ModelAndView();
		mav.setView(new WhUserTypePdfView());
		mav.addObject("userTypes",userTypes);
		return mav;
	}

}
