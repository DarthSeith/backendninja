package com.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

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
		model.addAttribute("title", "Welcome exampleGetMapping");
		model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}

	// Cuarta forma
	@GetMapping("/exampleGetMappingModel") // en este ejemplo no nos entregan nada y lo hacemos desde aca
	public ModelAndView exampleGetMappingModel() {
		ModelAndView modelAndView=new ModelAndView(EXAMPLE_VIEW);//tenemos que pasarle el objeto de la plantilla para que reconozca
		modelAndView.addObject("title", "Welcome exampleGetMappingModel");
		modelAndView.addObject("people", getPeople());
		return modelAndView;
	}
	
	private List<Person> getPeople(){
		List<Person> lst=new ArrayList<Person>();
		lst.add(new Person("one",1));
		lst.add(new Person("two",2));
		lst.add(new Person("tree",3));
		lst.add(new Person("forth",4));
		lst.add(new Person("five",5));
		lst.add(new Person("six",6));
		return lst;
	}
} 
