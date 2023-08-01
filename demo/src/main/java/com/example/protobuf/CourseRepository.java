package com.example.protobuf;

import java.util.Collection;
import java.util.Map;

import com.example.protobuf.CoursesProto.Course;

public class CourseRepository {

    private final Map<Integer, Course> courses;

    public CourseRepository(Map<Integer, Course> courses) {
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
