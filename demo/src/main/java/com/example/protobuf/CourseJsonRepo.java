package com.example.protobuf;

import java.util.Collection;
import java.util.Map;

import com.example.demo.Course;

public class CourseJsonRepo {
	
    private final Map<Integer, Course> courses;

    public CourseJsonRepo(Map<Integer, Course> courses) {
        this.courses = courses;
    }

    public Course getCourse(int id) {
        return courses.get(id);
    }
    
    public Collection<Course> getAllCourse() {
		// TODO Auto-generated method stub
		return courses.values();
	}
}
