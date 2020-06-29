package com.cos.project.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Users {
	private int id;
	private String username;
	private String displayName;
	private String email;
	private String password;
	private String userRole;
	private String userProfile;
	private Timestamp createDate;
	private String tel;
	private String address;
	private String company;
	private int companyVAT;
	private String companyAddress;

	
}
