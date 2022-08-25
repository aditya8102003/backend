package com.cg.search.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

		@ControllerAdvice
		public class ExceptionInterceptor {

			@ExceptionHandler(NotFoundException.class)
			public final ResponseEntity<Object> handleAllExceptions(NotFoundException ex) {
				NotFoundExceptionSchema exceptionResponse = new NotFoundExceptionSchema(ex.getMessage());
				return new ResponseEntity<Object>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}



