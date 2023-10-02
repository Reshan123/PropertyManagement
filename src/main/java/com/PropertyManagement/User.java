package com.PropertyManagement;

public class User {

	
	private int uid;
	private String name;
	private String email;
	private String phone;
	private String password;
	private String type;
	private String image;

	
	public User(int uid, String name, String email, String phone, String password, String type, String image) {
		super();
		this.uid = uid;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.type = type;
		this.image = image;
	}
	
	public int getUid() {
		return uid;
	}
	
	public String getName() {
		return name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public String getType() {
		return type;
	}

	public String getImage() {
		return image;
	}
}
