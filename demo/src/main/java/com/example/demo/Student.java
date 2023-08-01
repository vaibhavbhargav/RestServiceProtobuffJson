package com.example.demo;

import java.util.List;

public class Student {
	
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private List<PhoneNumber> phone;
	public int getId() {
		return id;
	}
	public List<PhoneNumber> getPhone() {
		return phone;
	}
	public void setPhone(List<PhoneNumber> phones) {
		this.phone = phones;
	}
	public Student(int id, String firstName, String lastName, String email, List<PhoneNumber> phones) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phones;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	

}
