package com.jspiders.cardekho_case_study_springrest.POJO;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class AdminPOJO {

	@Id
	private String username;
	private String password;
}
