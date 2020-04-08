package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateOptimisticLockingFailureException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;
import com.app.validator.OrderMethodValidator;
import com.app.view.OrderMethodExcelView;
import com.app.view.OrderMethodPdfView;

@Controller
@RequestMapping("/ordermethod")
public class OrderMethodController {
	@Autowired
	private IOrderMethodService service;
	@Autowired
	private OrderMethodValidator validator;

	// 1 to display order method page
	@RequestMapping("/create")
	public String showCreateOrder(ModelMap map) {
		map.addAttribute("ordermethod", new OrderMethod());
		return "OrderMethodCreate";
	}

	// 2 onclick on submit button
	@RequestMapping(value = "/insert", method = RequestMethod.POST)
	public String saveOrderData(@ModelAttribute("ordermethod") OrderMethod orMethod, Errors errors, ModelMap map) {
		validator.validate(orMethod, errors);
		if (!errors.hasErrors()) {
			Integer orderId = service.saveOrderMethod(orMethod);
			String msg = "Order Method '" + orderId + "' saved";
			map.addAttribute("ordermethod", new OrderMethod());
			map.addAttribute("message", msg);
		}
		return "OrderMethodCreate";
	}

	// 3 get data from db to ui
	@RequestMapping("/all")
	public String showOrderData(ModelMap map) {
		List<OrderMethod> orMethods = service.getAllOrderMethods();
		map.addAttribute("list", orMethods);
		return "OrderMethodData";
	}

	// 4 delete order by id
	@RequestMapping("/delete")
	public String deleteOrderMethod(@RequestParam("id")Integer orderId,ModelMap map) {
		String msg=null;
		try {
		service.deleteOrderMethod(orderId);
		msg="Order Method '"+orderId+"' deleted";
		
		}catch (HibernateOptimisticLockingFailureException e) {
			msg="Order Method '"+orderId+"' not found";
		}
		
		List<OrderMethod> orMethods=service.getAllOrderMethods();
		map.addAttribute("message",msg);
		map.addAttribute("list",orMethods);
		return "OrderMethodData";
	}

	// 5 show edit page
	@RequestMapping("/edit")
	public String showOrderEdit(@RequestParam("id") Integer orderId, ModelMap map) {
		OrderMethod orMethod = service.getOneOrderMethod(orderId);
		map.addAttribute("ordermethod", orMethod);
		return "OrderMethodEdit";
	}

	// 6 do update operation
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String doUpdateOrderData(@ModelAttribute OrderMethod orMethod, ModelMap map) {
		service.updateOrderMethod(orMethod);
		String msg = "Order Method '" + orMethod.getOrderId() + "' Updated";
		List<OrderMethod> orMethods = service.getAllOrderMethods();
		map.addAttribute("list", orMethods);
		map.addAttribute("message", msg);
		return "OrderMethodData";
	}

	// 7 export to excel
	@RequestMapping("/excel")
	public ModelAndView showExcel() {
		List<OrderMethod> orMethods = service.getAllOrderMethods();
		ModelAndView mav = new ModelAndView();
		mav.setView(new OrderMethodExcelView());
		mav.addObject("orMethods", orMethods);
		return mav;
	}

	// 8 export to pdf
	@RequestMapping("/pdf")
	public ModelAndView showPdf() {
		List<OrderMethod> orMethods = service.getAllOrderMethods();
		ModelAndView mav = new ModelAndView();
		mav.setView(new OrderMethodPdfView());
		mav.addObject("orMethods", orMethods);
		return mav;
	}

}
