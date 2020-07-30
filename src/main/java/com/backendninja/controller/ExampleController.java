package com.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backendninja.model.Person;

@Controller
@RequestMapping("/example") // la URL que va a tener este controlado
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";


	// Tercera forma
	@GetMapping("/exampleGetMapping") // desde la pagina nos tiene que venir el model, y le pasamos el objeto que esta en la pagina de example.html								 
	public String exampleGetMapping(Model model) {
		model.addAttribute("person", new Person("exampleGetMapping",31));
		return EXAMPLE_VIEW;
	}

	// Cuarta forma
	@GetMapping("/exampleGetMappingModel") // en este ejemplo no nos entregan nada y lo hacemos desde aca
	public ModelAndView exampleGetMappingModel() {
		ModelAndView modelAndView=new ModelAndView(EXAMPLE_VIEW);//tenemos que pasarle el objeto de la plantilla para que reconozca
		modelAndView.addObject("person", new Person("exampleGetMappingModel",31));
		return modelAndView;
	}
}
