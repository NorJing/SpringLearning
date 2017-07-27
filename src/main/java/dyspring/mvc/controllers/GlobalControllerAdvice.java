package dyspring.mvc.controllers;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;

import dyspring.mvc.data.invalidators.ProjectValidator;

@ControllerAdvice(annotations=Controller.class)
public class GlobalControllerAdvice {

	public GlobalControllerAdvice() {
		// TODO Auto-generated constructor stub
		System.out.println("GlobalControllerAdvice initialized.");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.addValidators(new ProjectValidator());
	}

	@ExceptionHandler(NullPointerException.class)
	public String handleError(HttpServletRequest request) {
		return "controller_error";
	}
	
	@ModelAttribute("currentTime")
	public Date getCurrentDate() {
		return new Date();
	}

}
