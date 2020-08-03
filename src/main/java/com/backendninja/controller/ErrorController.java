package com.backendninja.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //este es el que captura los errores
public class ErrorController {

	public static final String ISE_VIEW ="error/500";
	
	@ExceptionHandler(Exception.class)
	public String showInternalServerError() {
		return ISE_VIEW;
	}
}
