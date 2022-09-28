package com.cdac.restro.beans;

public class LoginResponse {

	private String role;
	private Integer id;
	private String message;

	public LoginResponse() {
		super();
	}

	public LoginResponse(String role, Integer id) {
		super();

		this.role = role;
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "LoginResponse [role=" + role + ", id=" + id + ", message=" + message + "]";
	}

}
