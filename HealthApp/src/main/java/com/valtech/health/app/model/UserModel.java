package com.valtech.health.app.model;

public class UserModel {
	private int id;

	private String name;
	private String number;

	private String email;

	private String username;

	private String password;
	private String confirmpassword;

	public UserModel() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserModel(String name, String number, String email, String username, String password,
			String confirmpassword) {
		super();
		this.name = name;
		this.number = number;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public UserModel(int id, String name, String number, String email, String username, String password,
			String confirmpassword) {
		super();
		this.id = id;
		this.name = name;
		this.number = number;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmpassword = confirmpassword;
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

	@Override
	public String toString() {
		return "UserModel [id=" + id + ", name=" + name + ", number=" + number + ", email=" + email + ", username="
				+ username + ", password=" + password + ", confirmpassword=" + confirmpassword + "]";
	}

}
