package com.spring.rest.controller;

import java.util.ArrayList;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

@Component
public class StudentDAOImpl implements StudentDAO {
	ArrayList<Student> sl=new ArrayList<Student>();
	
	@PostConstruct
	public void addStudentinfo() {
		System.out.println("In StudentDAOImpl");
		sl.add(new Student("v", "py", 1));
		sl.add(new Student("w", "jsp", 2));
	}
	public ArrayList<Student> getStudentList() {
		return sl;
	}
	public Student getparticularStudent(int id) {
		
		return sl.get(id);
	}
	public Student getparticularStudentByName(String name) {
		Student returnStudent=null;
		for (Student tempStudent:sl) {
			if(name==tempStudent.getName()) {
				returnStudent=tempStudent;
				
			}
			System.out.println(returnStudent.getName());
		}
		return returnStudent;
	}
	public void addNewStudent(Student std) {
		sl.add(std);
		
	}
	public int getStudentListSize() {
		
		int studentListSize=sl.size();
		return studentListSize;
	}
	@Override
	public Student performUpdateStudent(Student std,int id) {
		Student student= new Student();
		student=sl.get(--id);
		student.setName(std.getName());
		return student;
	}
	@Override
	public void performDeleteStudent(int id) {
		sl.remove(--id);
		
	}
	
}
