package com.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/example2") // la URL que va a tener este controlado
public class Examplo2Controller {

	public static final String EXAMPLE2_VIEW = "example2";

	// primerta forma
	// localhost:8080/example2/request1?nm=example1
	// localhost:8080/example2/request1?nm=example2
	// en el parametro required = false cuando la variable no es requerido, true la
	// app se cae
	@GetMapping("/request1")
	public ModelAndView request1(
			@RequestParam(name = "nm", required = false, defaultValue = "Valor por Defecto") String name) {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE2_VIEW);
		modelAndView.addObject("nm_in_model", name);
		return modelAndView;
	}

	// primerta forma
	// http://localhost:8080/example2/request2/uno/dos
	// http://localhost:8080/example2/request2/tres/cuatro
	@GetMapping("/request2/{nm}/{nm2}")
	public ModelAndView request2(@PathVariable("nm") String nm, @PathVariable String nm2) {
		ModelAndView modelAndView = new ModelAndView(EXAMPLE2_VIEW);
		modelAndView.addObject("nm_in_model", nm);
		modelAndView.addObject("nm2_in_model", nm2);
		return modelAndView;
	}
}
