package com.app.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.OrderMethod;
import com.app.service.IOrderMethodService;

@RestController
@RequestMapping("/rest/ordermethod")
public class OrderMethodRestController {
	@Autowired
	private IOrderMethodService service;
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<OrderMethod> orMethods=service.getAllOrderMethods();
		if(orMethods==null || orMethods.isEmpty()) {
			//data not found
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<OrderMethod>>(orMethods,HttpStatus.OK);
		}
		return message;
	}
	
	//get data by id
	@GetMapping("/get/{orderId}")
	public ResponseEntity<?> getOne(@PathVariable Integer orderId){
		ResponseEntity<?> message=null;
		OrderMethod orMethod=service.getOneOrderMethod(orderId);
		if(orMethod==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<OrderMethod>(orMethod,HttpStatus.OK);
		}
		return message;
	}
	
	//delete data by id
	@DeleteMapping("/delete/{orderId}")
	public ResponseEntity<String> delete(@PathVariable Integer orderId){
		ResponseEntity<String> message=null;
		try {
			service.deleteOrderMethod(orderId);
			message=new ResponseEntity<String>("Om deleted successfully",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("Om not Found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	//save data
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody OrderMethod orMethod){
		ResponseEntity<String> message=null;
		try {
			Integer orderId=service.saveOrderMethod(orMethod);
			message=new ResponseEntity<String>("Saved with id :"+orderId,HttpStatus.OK);
		}catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	//update data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody OrderMethod orMethod){
		ResponseEntity<String> message=null;
		try {
			service.updateOrderMethod(orMethod);
			message=new ResponseEntity<String>("Om Updated :"+orMethod.getOrderId(),HttpStatus.OK);
		}catch (Exception e) {
			message=new ResponseEntity<String>("Om "+orMethod.getOrderId()+"not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}

}
