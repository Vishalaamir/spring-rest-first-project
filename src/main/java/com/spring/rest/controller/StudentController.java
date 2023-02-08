package com.spring.rest.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.spring.rest.exception.StudentNotFound;

@RestController
public class StudentController {

	@Autowired
	private StudentDAO studentDAO;

	
	//Handler method for getting Student list
	@GetMapping(value = "/student")
	public ArrayList<Student> studentInfo() {
		ArrayList<Student> studentlist = studentDAO.getStudentList();
		return studentlist;

	}

	// Handler method for getting Student by Id
	@GetMapping(value = "/student/{id}")
	public Student particularStudent(@PathVariable int id) throws Exception {
		if (id > studentDAO.getStudentListSize()) {
			throw new StudentNotFound("Student with id " + id + " " + "does not exist");
		}
		return studentDAO.getparticularStudent(--id);

	}

//	@GetMapping(value="/student/{name}",params="ByName")
//	public Student particlarStudentByName(@PathVariable String name) {
//		return studentDAO.getparticularStudentByName(name);
//		
//	}
	// Handler method for adding new Student
	@PostMapping(value = "/student", consumes = { MediaType.APPLICATION_XML_VALUE }, produces = {
			MediaType.APPLICATION_XML_VALUE })
	public ResponseEntity<Student> newStudent(@RequestBody Student std) {
		studentDAO.addNewStudent(std);
		System.out.println(std);
		return ResponseEntity.status(HttpStatus.CREATED).body(std);
	}
					
	// Handler method to update a Student
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@RequestBody Student std,@PathVariable int id) {
		
		studentDAO.performUpdateStudent(std,id);

		return ResponseEntity.status(HttpStatus.OK).body(std);

	}
	
	//Handler method for Delete Student
	@DeleteMapping("/student/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) throws StudentNotFound{
		if (id > studentDAO.getStudentListSize()) {
			throw new StudentNotFound("Student with id " + id + " " + "does not exist");
		}
		studentDAO.performDeleteStudent(id);
		return ResponseEntity.status(HttpStatus.OK).body("Student with id {id} has been deleted");
		
	}

}
