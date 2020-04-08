package com.app.controller;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Item;
import com.app.service.IItemService;
import com.app.util.ItemUtil;
import com.app.validator.ItemValidator;

@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private IItemService service;
	@Autowired
	private ItemValidator validator;
	@Autowired
	private ItemUtil util;

	@RequestMapping("/register")
	public String regItem(ModelMap map) {
		map.addAttribute("item",new Item());
		util.addUiComponents(map);
		return "ItemRegister";
	}

	@RequestMapping(value = "/insert", method = POST)
	public String saveItem(@ModelAttribute Item item, Errors errors, ModelMap map) {
		validator.validate(item, errors);
		if(!errors.hasErrors()) {
			Integer id=service.saveItem(item) ;
			map.addAttribute("message","Item created with Id:"+id);
			map.addAttribute("item",new Item()) ;
		}
		util.addUiComponents(map);

		return "ItemRegister";
	}

	@RequestMapping(value = "/update",method = POST)
	public String updateItem(@ModelAttribute Item item, Errors errors, ModelMap map) {
		validator.validate(item, errors);
		if(!errors.hasErrors()) {
			service.updateItem(item);
			String msg="Item '"+item.getId()+"' Updated";
			map.addAttribute("message",msg);
			List<Item> items=service.getAllItems();
			map.addAttribute("items", items);
		}
		return "ItemData";
	}

	@RequestMapping("/delete")
	public String deleteItem(@RequestParam Integer id,ModelMap map) {
		service.deleteItem(id);
		List<Item> items=service.getAllItems();
		map.addAttribute("items", items);
		return "ItemData";
	}

	@RequestMapping("/edit")
	public String editItem(@RequestParam Integer id, ModelMap map) {
		Item ob=service.getOneItem(id);
		map.addAttribute("item",ob);
		util.addUiComponents(map);
		return "ItemEdit";
	}

	@RequestMapping("/getAll")
	public String getAllItems(ModelMap map) {
		List<Item> items=service.getAllItems();
		map.addAttribute("items", items);
		return "ItemData";
	}
}
