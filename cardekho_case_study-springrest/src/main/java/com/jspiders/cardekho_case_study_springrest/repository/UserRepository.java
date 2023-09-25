package com.jspiders.cardekho_case_study_springrest.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.jspiders.cardekho_case_study_springrest.POJO.UserPOJO;

@Repository
public class UserRepository {
	
	private static EntityManagerFactory factory;
	private static EntityManager manager;
	private static EntityTransaction transaction;
	private static Query query;
	private static void openConnection() {
		factory=Persistence.createEntityManagerFactory("carrest");
		manager=factory.createEntityManager();
		transaction=manager.getTransaction();
	}

	private static void closeConnection() {
		if(factory!=null) {
			factory.close();
		}
		if(manager!=null) {
			manager.close();
		}
		if(transaction!=null) {
			if(transaction.isActive()) {
				transaction.rollback();
			}
		}
	}
	
	public UserPOJO addCar(UserPOJO pojo) {
		openConnection();
		transaction.begin();
		
		manager.persist(pojo);
		
		transaction.commit();
		closeConnection();
		return pojo;
	}

	public UserPOJO searchCar(int id) {
		openConnection();
		transaction.begin();
		
		UserPOJO car=manager.find(UserPOJO.class, id);
		
		
		transaction.commit();
		closeConnection();
		return car;
	}

	public List<UserPOJO> searchAllCars() {
		openConnection();
		transaction.begin();
		
		String jpql="from UserPOJO";
		query=manager.createQuery(jpql);
		List<UserPOJO> cars=query.getResultList();
		
		transaction.commit();
		closeConnection();
		return cars;
	}

	public UserPOJO removeCar(int id) {
		openConnection();
		transaction.begin();
		
		UserPOJO car=manager.find(UserPOJO.class, id);
		if(car!=null) {
			manager.remove(car);
			transaction.commit();
			closeConnection();
			return car;
		}
		
		transaction.commit();
		closeConnection();
		return null;
	}

	public UserPOJO updateCar(UserPOJO pojo) {
		openConnection();
		transaction.begin();
		
		
		UserPOJO car=manager.find(UserPOJO.class, pojo.getId());
		car.setName(pojo.getName());
		car.setModel(pojo.getModel());
		car.setBrand(pojo.getBrand());
		car.setFuel_type(pojo.getFuel_type());
		car.setPrice(pojo.getPrice());
		manager.persist(car);
		
		transaction.commit();
		closeConnection();
		return car;
	}

}
