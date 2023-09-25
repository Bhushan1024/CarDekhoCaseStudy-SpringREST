package com.jspiders.cardekho_case_study_springrest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jspiders.cardekho_case_study_springrest.POJO.UserPOJO;
import com.jspiders.cardekho_case_study_springrest.response.UserResponse;
import com.jspiders.cardekho_case_study_springrest.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(path="/add",
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> addCar(@RequestBody UserPOJO pojo){
		UserPOJO car=service.addCar(pojo);
		
		//Success
		if(car!=null) {
			return new ResponseEntity<UserResponse>(new UserResponse("Car Added Successfully...!!!", car, null),HttpStatus.ACCEPTED);
		}
		
		//Failure
		return new ResponseEntity<UserResponse>(new UserResponse("Car Not Added...!!!", null, null),HttpStatus.NOT_ACCEPTABLE);
	}
	
	@GetMapping(path = "search/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse>searchCar(@PathVariable int id){
		UserPOJO car=service.searchCar(id);
		
		//Success
		if(car!=null) {
			return new ResponseEntity<UserResponse>(new UserResponse("Car Found Successfully...!!!", car, null),HttpStatus.FOUND);
		}
		//Failure
		return new ResponseEntity<UserResponse>(new UserResponse("Car Not Found...!!!",null, null),HttpStatus.NOT_FOUND);
	}

	@GetMapping(path="/searchAll",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse>searchAll(){
		List<UserPOJO>cars=service.searchAllCars();
		
		//Success
		if(cars.isEmpty()==false) {
			return new ResponseEntity<UserResponse>(new UserResponse("Cars Found Successfully...!!!", null, cars),HttpStatus.FOUND);
		}
		//Failure
		return new ResponseEntity<UserResponse>(new UserResponse("Cars Not Found...!!!", null, null),HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping(path="/remove/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse> removeCar(@PathVariable int id){
		UserPOJO car=service.removeCar(id);
		
		//Success
		if(car!=null) {
			return new ResponseEntity<UserResponse>(new UserResponse("Car Removed Successfully...!!!", car, null),HttpStatus.OK);
		}
		
		//Failure
		return new ResponseEntity<UserResponse>(new UserResponse("Car Not Removed...!!!", null, null),HttpStatus.BAD_REQUEST);
	}
	
	@PutMapping(path="/update",consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<UserResponse>updateCar(@RequestBody UserPOJO pojo){
		UserPOJO car=service.updateCar(pojo);
		
		//Success
		if(car!=null) {
			return new ResponseEntity<UserResponse>(new UserResponse("Car Updated Successfully...!!!", car, null),HttpStatus.ACCEPTED);
		}
		
		//Failure
		return new ResponseEntity<UserResponse>(new UserResponse("Car Not Updated...!!!", null, null),HttpStatus.NOT_ACCEPTABLE);
	}
}


