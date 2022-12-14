package com.valtech.health.app.model;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;

public class UserModel {

	private int id;

	@NotBlank(message = "Name cannot be empty!!")
	private String name;
	private String number;
	@Column(nullable = false, unique = true)
	private String email;
	@Column(nullable = false, unique = true)
	private String username;
	private String password;
	private String confirmpassword;
	private String role;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String name, String number, String email, String username, String password, String confirmpassword,
			String role) {
		super();

		this.name = name;
		this.number = number;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.role = role;
	}

	public UserModel(int id, String name, String number, String email, String username, String password,
			String confirmpassword, String role) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
		this.role = role;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
