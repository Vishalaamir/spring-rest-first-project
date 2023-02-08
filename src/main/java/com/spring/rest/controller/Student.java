package com.spring.rest.controller;

public class Student {
	private String name;
	private String batch;
	private  int id;

	public Student() {
		System.out.println("In Student class default constructor");
	}

	
	public Student(String name, String batch, int id) {
		this.name = name;
		this.batch = batch;
		this.id = id;
	
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBatch() {
		return batch;
	}
	public void setBatch(String batch) {
		this.batch = batch;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}


	@Override
	public String toString() {
		return "Student [name=" + name + ", batch=" + batch + ", id=" + id + "]";
	}
	
}
