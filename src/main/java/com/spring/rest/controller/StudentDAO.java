package com.spring.rest.controller;

import java.util.ArrayList;

public interface StudentDAO {
	ArrayList<Student> getStudentList();

	Student getparticularStudent(int id);

	Student getparticularStudentByName(String name);

	void addNewStudent(Student std);

	int getStudentListSize();

	Student performUpdateStudent(Student std,int id);

	void performDeleteStudent(int id);
}
