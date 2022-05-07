package com.spring;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.spring.dao.Student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
@RequestMapping("/")
@RestController
public class RestfulApplication {

	public static void main(String[] args) {
		// System.out.println("This is Main Method");
		SpringApplication.run(RestfulApplication.class, args);
	}
	// @Value("${greeting}") String message;

	// @GetMapping
	// private Collection<Student> helloWorld() {
	// 	Student s1= new Student("Bhavuk", 1);
	// 	Student s2 = new Student("Shubham", 3);
	// 	Student s3 = new Student("Abhi", 5);
	// 	List students = new ArrayList<Student>();
	// 	students.add(s1);
	// 	students.add(s2);
	// 	students.add(s3);
	// 	return students;
	// }
}
