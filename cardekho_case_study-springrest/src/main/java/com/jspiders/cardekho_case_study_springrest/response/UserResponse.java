package com.jspiders.cardekho_case_study_springrest.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.jspiders.cardekho_case_study_springrest.POJO.UserPOJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {

	private String msg;
	private UserPOJO car;
	private List<UserPOJO>cars;
	
}
