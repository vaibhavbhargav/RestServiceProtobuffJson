package com.example.protobuf;

import java.io.IOException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.protobuf.CoursesProto.Course;
import com.example.protobuf.convert.ProtobuffUtil;

@RestController
public class CourseController {

    @Autowired
    CourseRepository courseRepo;
    
    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/v2/courses/{id}")
    Course getCourse(@PathVariable Integer id) {
        return courseRepo.getCourse(id);
    }
    
    @RequestMapping("/v2/courses")
    Collection<Course> getAllCourse() {
        return courseRepo.getAllCourse();
    }
    
    @RequestMapping("/v2/courses/json1/{id}")
    String customer(@PathVariable Integer id) throws IOException {
    	ResponseEntity<Course> re = restTemplate.getForEntity("http://localhost:9092/courses/" + id, Course.class);
        return ProtobuffUtil.toJson(re.getBody());
    }
}
