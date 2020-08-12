package com.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.backendninja.component.ExampleComponent;
import com.backendninja.model.Person;
import com.backendninja.service.ExampleService;

/**
 * los Controller solo llama a los Servicios
 * @author gigio
 *
 */
@Controller
@RequestMapping("/example") // la URL que va a tener este controlado
public class ExampleController {

	public static final String EXAMPLE_VIEW = "example";

	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	@Autowired //esto indica que vamos a utilizar un componente que esta en su memoria, sin necesidad de hacer un new o dar memoria
	@Qualifier("NameExampleComponent") //Nombre de bean que esta en memoria
	private ExampleComponent exampleController;
	
	// Tercera forma
	@GetMapping("/exampleGetMapping") // desde la pagina nos tiene que venir el model, y le pasamos el objeto que esta en la pagina de example.html								 
	public String exampleGetMapping(Model model) {
		exampleController.sayHello();
		model.addAttribute("title", "Welcome exampleGetMapping");
		model.addAttribute("people", exampleService.getListPeople());
		return EXAMPLE_VIEW;
	}

	// Cuarta forma
	@GetMapping("/exampleGetMappingModel") // en este ejemplo no nos entregan nada y lo hacemos desde aca
	public ModelAndView exampleGetMappingModel() {
		ModelAndView modelAndView=new ModelAndView(EXAMPLE_VIEW);//tenemos que pasarle el objeto de la plantilla para que reconozca
		modelAndView.addObject("title", "Welcome exampleGetMappingModel");
		modelAndView.addObject("people", exampleService.getListPeople());
		return modelAndView;
	}
} 
