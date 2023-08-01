package com.example.protobuf;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.protobuf.CoursesProto.Course;
import com.example.protobuf.convert.ProtobuffUtil;

@RestController
public class ExternalCourseController {
	
    @Autowired
    private RestTemplate restTemplate;
    
    @Autowired
    private RestTemplate restTemplate1;
	
    @RequestMapping(path="/v1/external/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<com.example.demo.Course> getCoursesJson(@PathVariable Integer id) throws IOException {
    	ResponseEntity<com.example.demo.Course> re = restTemplate1.getForEntity("http://localhost:9092/v1/courses/" + id, com.example.demo.Course.class);
    	return re;
    }
    
    @RequestMapping(path="/v2/external/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    String getCoursesPb(@PathVariable Integer id) throws IOException {
    	ResponseEntity<Course> re = restTemplate.getForEntity("http://localhost:9092/v2/courses/" + id, Course.class);
        return ProtobuffUtil.toJson(re.getBody());
    }

}
