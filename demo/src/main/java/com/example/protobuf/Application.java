package com.example.protobuf;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.protobuf.ProtobufHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.example.protobuf.CoursesProto.Course;
import com.example.protobuf.CoursesProto.Student;
import com.example.protobuf.CoursesProto.Student.PhoneNumber;
import com.example.protobuf.CoursesProto.Student.PhoneType;

@SpringBootApplication
public class Application {
    
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    RestTemplate restTemplate(ProtobufHttpMessageConverter hmc) {
        return new RestTemplate(Arrays.asList(hmc));
    }

    @Bean
    ProtobufHttpMessageConverter protobufHttpMessageConverter() {
        return new ProtobufHttpMessageConverter();
    }

    @Bean
    public CourseRepository createTestCourses() {
    	Map<Integer, Course> courses = new HashMap<>();

    	Course course1 = Course.newBuilder().setId(1).setCourseName("REST with Spring").addAllStudent(createTestStudents()).build();

    	Course course2 = Course.newBuilder().setId(2).setCourseName("Learn Spring Security").addAllStudent(new ArrayList<>()).build();

    	courses.put(course1.getId(), course1);
    	courses.put(course2.getId(), course2);

    	return new CourseRepository(courses);
    }

    private List<Student> createTestStudents() {
    	List<Student> students = new ArrayList<>();
    	for(int index=0; index<200; index++) {
    		PhoneNumber phone1 = createPhone("123456", PhoneType.LANDLINE);
    		Student student1 = createStudent(1, "John", "Doe", "john.doe@testing.com", Arrays.asList(phone1));

    		PhoneNumber phone2 = createPhone("234567", PhoneType.LANDLINE);
    		Student student2 = createStudent(2, "Richard", "Roe", "richard.roe@testing.com", Arrays.asList(phone2));

    		PhoneNumber phone3_1 = createPhone("345678", PhoneType.LANDLINE);
    		PhoneNumber phone3_2 = createPhone("456789", PhoneType.LANDLINE);
    		Student student3 = createStudent(3, "Jane", "Doe", "jane.doe@testing.com", Arrays.asList(phone3_1, phone3_2));
    		students.add(student1);
    		students.add(student2);
    		students.add(student3);
    	}
        return students;
    }

    private Student createStudent(int id, String firstName, String lastName, String email, List<PhoneNumber> phones) {
        return Student.newBuilder().setId(id).setFirstName(firstName).setLastName(lastName).setEmail(email).addAllPhone(phones).build();
    }

    private PhoneNumber createPhone(String number, PhoneType type) {
        return PhoneNumber.newBuilder().setNumber(number).setType(type).build();
    }
    
    @Bean
    public CourseJsonRepo createTestJsonCourses() {
    	Map<Integer, com.example.demo.Course> courses = new HashMap<>();

    	com.example.demo.Course course1 = new com.example.demo.Course(1, "REST with Spring", createTestStudents1());
    	com.example.demo.Course course2 = new com.example.demo.Course(2, "Learn Spring Security", createTestStudents1());
    	courses.put(course1.getId(), course1);
    	courses.put(course2.getId(), course2);


    	return new CourseJsonRepo(courses);
    }
    
    private List<com.example.demo.Student> createTestStudents1() {
    	List<com.example.demo.Student> students = new ArrayList<>();
    	for(int index=0; index<200; index++) {
    		com.example.demo.PhoneNumber phone1 = createPhone1("123456", com.example.demo.PhoneType.LANDLINE);
    		com.example.demo.Student student1 = createStudent1(1, "John", "Doe", "john.doe@testing.com", Arrays.asList(phone1));

    		com.example.demo.PhoneNumber phone2 = createPhone1("234567", com.example.demo.PhoneType.LANDLINE);
    		com.example.demo.Student student2 = createStudent1(2, "Richard", "Roe", "richard.roe@testing.com", Arrays.asList(phone2));

    		com.example.demo.PhoneNumber phone3_1 = createPhone1("345678", com.example.demo.PhoneType.LANDLINE);
    		com.example.demo.PhoneNumber phone3_2 = createPhone1("456789", com.example.demo.PhoneType.LANDLINE);
    		com.example.demo.Student student3 = createStudent1(3, "Jane", "Doe", "jane.doe@testing.com", Arrays.asList(phone3_1, phone3_2));
    		students.add(student1);
    		students.add(student2);
    		students.add(student3);
    	}
        return students;
    }

	private com.example.demo.Student createStudent1(int id, String firstName, String lastName, String email,
			List<com.example.demo.PhoneNumber> asList) {
		// TODO Auto-generated method stub
		return new com.example.demo.Student(id, firstName, lastName, email, asList);
	}

	private com.example.demo.PhoneNumber createPhone1(String string, com.example.demo.PhoneType mobile) {
		return new com.example.demo.PhoneNumber(string, mobile);
	}
    
    
}