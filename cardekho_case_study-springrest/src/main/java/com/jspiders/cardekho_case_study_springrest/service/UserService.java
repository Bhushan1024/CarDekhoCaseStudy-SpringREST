package com.jspiders.cardekho_case_study_springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jspiders.cardekho_case_study_springrest.POJO.UserPOJO;
import com.jspiders.cardekho_case_study_springrest.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	public UserPOJO addCar(UserPOJO pojo) {
		UserPOJO car=repository.addCar(pojo);
		return pojo;
	}
	public UserPOJO searchCar(int id) {
		UserPOJO car=repository.searchCar(id);
		return car;
	}
	public List<UserPOJO> searchAllCars() {
		List<UserPOJO> cars=repository.searchAllCars();
		return cars;
	}
	public UserPOJO removeCar(int id) {
		UserPOJO car=repository.removeCar(id);
		return car;
	}
	public UserPOJO updateCar(UserPOJO pojo) {
		UserPOJO car=repository.updateCar(pojo);
		return car;
	}

}
