package com.jspiders.cardekho_case_study_springrest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_springrest.POJO.AdminPOJO;
import com.jspiders.cardekho_case_study_springrest.response.AdminResponse;
import com.jspiders.cardekho_case_study_springrest.service.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService service;
	
	@PostMapping(path="/createAccount",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> createAccount(@RequestBody AdminPOJO pojo){
		AdminPOJO admin=service.createAccount(pojo);
		
		//Success
		if(admin!=null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Account Created Successfully...!!!", admin),HttpStatus.ACCEPTED);
		}
		//Failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Account Not Created...!!!", null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@PostMapping(path="/login",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<AdminResponse> login(@RequestBody AdminPOJO pojo){
		AdminPOJO admin=service.login(pojo);
		
		//Success
		if(admin!=null) {
			return new ResponseEntity<AdminResponse>(new AdminResponse("Login Successfull...!!!", admin),HttpStatus.OK);
		}
		
		//Failure
		return new ResponseEntity<AdminResponse>(new AdminResponse("Login Failed...!!!", admin),HttpStatus.NOT_FOUND);
	}
}
