package com.luv2code.springdemo.rest;

import java.util.ArrayList;
import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.luv2code.springdemo.entity.Student;

import javax.annotation.PostConstruct;

@RestController
@RequestMapping("/api")
public class StudentRestController {

	private List<Student> theStudents;

	// define post constructor to define the data and load it once
	@PostConstruct
	public void loadData(){
		theStudents = new ArrayList<>();

		theStudents.add(new Student("Poornima", "Patel"));
		theStudents.add(new Student("Mario", "Rossi"));
		theStudents.add(new Student("Mary", "Smith"));	}
	// define endpoint for "/students" - return list of students
	
	@GetMapping("/students/{studentId}")
	public Student getStudents(@PathVariable int studentId) {

		//check Student id vs list size
		if(studentId>= theStudents.size() || studentId<0){

			throw new  StudentNotFoundException("Student not found - " + studentId);

		}

			
		return theStudents.get(studentId);
	}

//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(StudentNotFoundException exc){
//
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.NOT_FOUND.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
//	}
//
//
//	//add another generic exception handler
//	@ExceptionHandler
//	public ResponseEntity<StudentErrorResponse> handleException(Exception exc){
//
//		StudentErrorResponse error = new StudentErrorResponse();
//		error.setStatus(HttpStatus.BAD_REQUEST.value());
//		error.setMessage(exc.getMessage());
//		error.setTimeStamp(System.currentTimeMillis());
//
//		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
//	}

}









