package com.example.protobuf;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Course;


@RestController
public class CourseJsonController {
	
	@Autowired
	CourseJsonRepo courseJsonRepo;
	
	@RequestMapping(path = "/v1/courses/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    Course getCourse(@PathVariable Integer id) {
        return courseJsonRepo.getCourse(id);
    }
	
	@RequestMapping("/v1/courses")
	Collection<Course> getAllCourse() {
	    return courseJsonRepo.getAllCourse();
	}
}
