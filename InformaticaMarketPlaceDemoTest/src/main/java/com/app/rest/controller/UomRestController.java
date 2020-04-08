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
import org.springframework.web.client.RestOperationsExtensionsKt;

import com.app.model.Uom;
import com.app.service.IUomService;

@RestController
@RequestMapping("/rest/uom")
public class UomRestController {
	@Autowired
	private IUomService service;
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> message=null;
		List<Uom> uoms=service.getAllUoms();
		if(uoms==null || uoms.isEmpty()) {
			//data not found
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<List<Uom>>(uoms,HttpStatus.OK);
		}
		return message;
	}
	
	//get data by id
	@GetMapping("/get/{uomId}")
	public ResponseEntity<?> getOne(@PathVariable Integer uomId){
		ResponseEntity<?> message=null;
		Uom uom=service.getOneUom(uomId);
		if(uom==null) {
			message=new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}else {
			message=new ResponseEntity<Uom>(uom,HttpStatus.OK);
		}
		return message;
	}
	
	//delete data by id
	@DeleteMapping("/delete/{uomId}")
	public ResponseEntity<String> delete(@PathVariable Integer uomId){
		ResponseEntity<String> message=null;
		try {
			service.deleteUom(uomId);
			message=new ResponseEntity<String>("Uom deleted successfully",HttpStatus.OK);
		}catch(Exception e) {
			message=new ResponseEntity<String>("Uom not Found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
	
	//save data
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Uom uom){
		ResponseEntity<String> message=null;
		try {
			Integer uomId=service.saveUom(uom);
			message=new ResponseEntity<String>("Saved with id :"+uomId,HttpStatus.OK);
		}catch (Exception e) {
			message=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return message;
	}
	
	//update data
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody Uom uom){
		ResponseEntity<String> message=null;
		try {
			service.updateUom(uom);
			message=new ResponseEntity<String>("Uom Updated :"+uom.getUomId(),HttpStatus.OK);
		}catch (Exception e) {
			message=new ResponseEntity<String>("Uom "+uom.getUomId()+"not found",HttpStatus.BAD_REQUEST);
		}
		return message;
	}
}
