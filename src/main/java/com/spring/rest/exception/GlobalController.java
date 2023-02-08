package com.spring.rest.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.spring.rest.controller.StudentErrorResponse;
@ControllerAdvice
public class GlobalController {
	@ExceptionHandler
	ResponseEntity<StudentErrorResponse> handleStudentNotFoundexception(StudentNotFound snf) {
		System.out.println("Inside handleStudentNotFoundexception ");
		StudentErrorResponse studenterrorResponse = new StudentErrorResponse();
		studenterrorResponse.setDate(new Date());
		studenterrorResponse.setErrorClass(snf.getClass().toString());
		studenterrorResponse.setErrorMessage(snf.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(studenterrorResponse);
	}
}
