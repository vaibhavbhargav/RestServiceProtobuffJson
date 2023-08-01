package com.example.demo;

public class PhoneNumber {
	private String number;
	private PhoneType type;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PhoneType getType() {
		return type;
	}
	public PhoneNumber(String number, PhoneType type) {
		super();
		this.number = number;
		this.type = type;
	}
	public void setType(PhoneType type) {
		this.type = type;
	}
	
	
}
