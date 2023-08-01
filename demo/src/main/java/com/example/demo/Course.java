package com.example.demo;

import java.util.List;

public class Course {

	private int id;
	private String courseName;
	private List<Student> student;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public Course(int id, String courseName, List<Student> students) {
		super();
		this.id = id;
		this.courseName = courseName;
		this.student = students;
	}
	public List<Student> getStudent() {
		return student;
	}
	public void setStudent(List<Student> students) {
		this.student = students;
	}
	
	
}
